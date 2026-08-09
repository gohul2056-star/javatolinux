package com.gesture.network;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VisionClient {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8123;
    
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private boolean running = false;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    
    public interface VisionListener {
        void onPrediction(String gestureName, double confidence);
        void onTrainingProgress(double progress);
        void onTrainingComplete(boolean success);
    }
    
    private final List<VisionListener> listeners = new ArrayList<>();
    private final Gson gson = new Gson();

    public void addListener(VisionListener listener) {
        listeners.add(listener);
    }


    public void connect() {
        if (running) return;
        
        executor.submit(() -> {
            while (true) {
                try {
                    socket = new Socket(HOST, PORT);
                    out = new PrintWriter(socket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    running = true;
                    System.out.println("Connected to Vision Microservice");
                    
                    String line;
                    while ((line = in.readLine()) != null) {
                        try {
                            JsonObject msg = gson.fromJson(line, JsonObject.class);
                            String type = msg.has("type") ? msg.get("type").getAsString() : "";
                            
                            if ("PREDICTION".equals(type)) {
                                String gesture = msg.get("gesture").getAsString();
                                double confidence = msg.get("confidence").getAsDouble();
                                for (VisionListener l : listeners) l.onPrediction(gesture, confidence);
                            } else if ("TRAINING_PROGRESS".equals(type)) {
                                double progress = msg.get("progress").getAsDouble();
                                for (VisionListener l : listeners) l.onTrainingProgress(progress);
                            } else if ("TRAINING_COMPLETE".equals(type)) {
                                boolean success = msg.get("success").getAsBoolean();
                                for (VisionListener l : listeners) l.onTrainingComplete(success);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    running = false;
                    System.out.println("Could not connect to Vision Microservice, retrying in 2 seconds...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
            }
        });
    }
    
    public void sendStartTraining(int id, String name) {
        if (out != null) {
            JsonObject msg = new JsonObject();
            msg.addProperty("command", "START_TRAINING");
            msg.addProperty("id", id);
            msg.addProperty("name", name);
            out.println(msg.toString());
        }
    }
    
    public void sendDeleteGesture(int id) {
        if (out != null) {
            JsonObject msg = new JsonObject();
            msg.addProperty("command", "DELETE_GESTURE");
            msg.addProperty("id", id);
            out.println(msg.toString());
        }
    }
    
    public void disconnect() {
        if (out != null) {
            JsonObject msg = new JsonObject();
            msg.addProperty("command", "STOP");
            out.println(msg.toString());
        }
        running = false;
        try {
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        executor.shutdownNow();
    }
}
