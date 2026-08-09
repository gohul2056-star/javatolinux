import os
import pickle
import numpy as np
from sklearn.svm import SVC
import json

class GestureClassifier:
    def __init__(self, model_path='gesture_model.pkl', data_path='gesture_data.json'):
        self.model_path = model_path
        self.data_path = data_path
        self.model = SVC(probability=True, kernel='rbf')
        self.is_trained = False
        self.data = {'X': [], 'y': [], 'labels': {}} # labels mapping: id -> name
        self.load_data()
        self.train()

    def add_data(self, landmarks, label_id, label_name):
        self.data['X'].append(landmarks)
        self.data['y'].append(label_id)
        self.data['labels'][label_id] = label_name

    def clear_gesture(self, label_id):
        # Remove all data associated with label_id
        indices_to_keep = [i for i, y in enumerate(self.data['y']) if y != label_id]
        self.data['X'] = [self.data['X'][i] for i in indices_to_keep]
        self.data['y'] = [self.data['y'][i] for i in indices_to_keep]
        if label_id in self.data['labels']:
            del self.data['labels'][label_id]

    def save_data(self):
        with open(self.data_path, 'w') as f:
            json.dump({
                'X': self.data['X'],
                'y': self.data['y'],
                'labels': self.data['labels']
            }, f)

    def load_data(self):
        if os.path.exists(self.data_path):
            with open(self.data_path, 'r') as f:
                loaded = json.load(f)
                self.data['X'] = loaded.get('X', [])
                self.data['y'] = loaded.get('y', [])
                # JSON keys are strings, convert to int
                labels = loaded.get('labels', {})
                self.data['labels'] = {int(k): v for k, v in labels.items()}

    def train(self):
        if len(self.data['X']) > 0 and len(set(self.data['y'])) > 1:
            X = np.array(self.data['X'])
            y = np.array(self.data['y'])
            self.model.fit(X, y)
            self.is_trained = True
            with open(self.model_path, 'wb') as f:
                pickle.dump(self.model, f)
            return True
        self.is_trained = False
        return False

    def predict(self, landmarks):
        if not self.is_trained:
            return None, 0.0
        X = np.array([landmarks])
        proba = self.model.predict_proba(X)[0]
        max_index = np.argmax(proba)
        predicted_id = self.model.classes_[max_index]
        confidence = proba[max_index]
        
        label_name = self.data['labels'].get(predicted_id, "Unknown")
        return label_name, float(confidence)
