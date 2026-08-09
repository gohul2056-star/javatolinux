import cv2
import mediapipe as mp
import socket
import threading
import json
import numpy as np
from classifier import GestureClassifier

mp_hands = mp.solutions.hands
mp_drawing = mp.solutions.drawing_utils

PORT = 8123

class VisionServer:
    def __init__(self):
        self.classifier = GestureClassifier()
        self.training_mode = False
        self.training_label_id = -1
        self.training_label_name = ""
        self.training_frames_collected = 0
        self.max_training_frames = 100 # ~3 seconds at 30fps
        
        self.server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.server_socket.bind(('127.0.0.1', PORT))
        self.server_socket.listen(1)
        self.client_socket = None
        self.running = True

    def process_landmarks(self, hand_landmarks):
        # Normalize landmarks relative to the wrist (landmark 0)
        base_x = hand_landmarks.landmark[0].x
        base_y = hand_landmarks.landmark[0].y
        base_z = hand_landmarks.landmark[0].z
        
        features = []
        for lm in hand_landmarks.landmark:
            features.extend([lm.x - base_x, lm.y - base_y, lm.z - base_z])
            
        return features

    def handle_client(self):
        while self.running:
            try:
                conn, addr = self.server_socket.accept()
                self.client_socket = conn
                while True:
                    data = conn.recv(1024)
                    if not data:
                        break
                    
                    try:
                        msg = json.loads(data.decode('utf-8'))
                        cmd = msg.get('command')
                        if cmd == 'START_TRAINING':
                            self.training_label_id = msg.get('id')
                            self.training_label_name = msg.get('name')
                            self.training_frames_collected = 0
                            self.training_mode = True
                            print(f"Started training for {self.training_label_name}")
                        elif cmd == 'DELETE_GESTURE':
                            gid = msg.get('id')
                            self.classifier.clear_gesture(gid)
                            self.classifier.save_data()
                            self.classifier.train()
                            print(f"Deleted gesture {gid}")
                        elif cmd == 'STOP':
                            self.running = False
                            break
                    except json.JSONDecodeError:
                        pass
            except Exception as e:
                print(f"Socket error: {e}")
                self.client_socket = None

    def send_message(self, msg):
        if self.client_socket:
            try:
                self.client_socket.sendall((json.dumps(msg) + '\n').encode('utf-8'))
            except:
                self.client_socket = None

    def start(self):
        server_thread = threading.Thread(target=self.handle_client, daemon=True)
        server_thread.start()

        cap = cv2.VideoCapture(0)
        with mp_hands.Hands(
            model_complexity=0,
            min_detection_confidence=0.5,
            min_tracking_confidence=0.5) as hands:
            
            while cap.isOpened() and self.running:
                success, image = cap.read()
                if not success:
                    continue

                image.flags.writeable = False
                image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
                results = hands.process(image)

                image.flags.writeable = True
                image = cv2.cvtColor(image, cv2.COLOR_RGB2BGR)

                if results.multi_hand_landmarks:
                    for hand_landmarks in results.multi_hand_landmarks:
                        features = self.process_landmarks(hand_landmarks)
                        
                        if self.training_mode:
                            self.classifier.add_data(features, self.training_label_id, self.training_label_name)
                            self.training_frames_collected += 1
                            
                            self.send_message({
                                'type': 'TRAINING_PROGRESS',
                                'progress': self.training_frames_collected / self.max_training_frames
                            })
                            
                            if self.training_frames_collected >= self.max_training_frames:
                                self.training_mode = False
                                self.classifier.save_data()
                                success = self.classifier.train()
                                self.send_message({
                                    'type': 'TRAINING_COMPLETE',
                                    'success': success
                                })
                        else:
                            name, confidence = self.classifier.predict(features)
                            if name:
                                self.send_message({
                                    'type': 'PREDICTION',
                                    'gesture': name,
                                    'confidence': confidence
                                })
                        
                        # Draw landmarks for debug/UI feedback if needed
                        # mp_drawing.draw_landmarks(image, hand_landmarks, mp_hands.HAND_CONNECTIONS)

                # cv2.imshow('MediaPipe Hands', image)
                # if cv2.waitKey(5) & 0xFF == 27:
                #     break

        cap.release()
        self.server_socket.close()

if __name__ == '__main__':
    server = VisionServer()
    server.start()
