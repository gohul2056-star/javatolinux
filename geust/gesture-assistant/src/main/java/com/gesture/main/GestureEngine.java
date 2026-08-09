package com.gesture.main;

import com.gesture.action.ActionExecutor;
import com.gesture.model.AppConfig;
import com.gesture.model.ActionType;
import com.gesture.network.VisionClient;

public class GestureEngine implements VisionClient.VisionListener {

    private AppConfig config;
    private VisionClient client;
    
    private String currentGesture = null;
    private long gestureStartTime = 0;
    private long lastActionTime = 0;

    public GestureEngine(AppConfig config, VisionClient client) {
        this.config = config;
        this.client = client;
        this.client.addListener(this);
    }

    @Override
    public void onPrediction(String gestureName, double confidence) {
        if (confidence < config.getConfidenceThreshold()) {
            currentGesture = null;
            return;
        }

        long now = System.currentTimeMillis();

        if (gestureName.equals(currentGesture)) {
            if (now - lastActionTime > config.getCooldownMs()) {
                if (now - gestureStartTime >= config.getHoldDelayMs()) {
                    triggerAction(gestureName);
                    lastActionTime = now;
                    gestureStartTime = now; // Reset hold
                }
            }
        } else {
            currentGesture = gestureName;
            gestureStartTime = now;
        }
    }

    private void triggerAction(String gestureName) {
        ActionType action = config.getGestureMappings().get(gestureName);
        if (action != null) {
            ActionExecutor.execute(action);
        }
    }

    @Override
    public void onTrainingProgress(double progress) {
        // Handled by UI if registered
    }

    @Override
    public void onTrainingComplete(boolean success) {
        // Handled by UI if registered
    }
}
