package com.gesture.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AppConfig {
    private double confidenceThreshold = 0.7;
    private long holdDelayMs = 500;
    private long cooldownMs = 1000;
    
    // Map of Gesture Name -> ActionType
    private Map<String, ActionType> gestureMappings = new HashMap<>();

    public AppConfig() {}

    public double getConfidenceThreshold() {
        return confidenceThreshold;
    }

    public void setConfidenceThreshold(double confidenceThreshold) {
        this.confidenceThreshold = confidenceThreshold;
    }

    public long getHoldDelayMs() {
        return holdDelayMs;
    }

    public void setHoldDelayMs(long holdDelayMs) {
        this.holdDelayMs = holdDelayMs;
    }

    public long getCooldownMs() {
        return cooldownMs;
    }

    public void setCooldownMs(long cooldownMs) {
        this.cooldownMs = cooldownMs;
    }

    public Map<String, ActionType> getGestureMappings() {
        return gestureMappings;
    }

    public void setGestureMappings(Map<String, ActionType> gestureMappings) {
        this.gestureMappings = gestureMappings;
    }

    public static AppConfig load(String filepath) {
        File file = new File(filepath);
        if (!file.exists()) {
            return new AppConfig();
        }
        try (Reader reader = new FileReader(file)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, AppConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new AppConfig();
        }
    }

    public void save(String filepath) {
        try (Writer writer = new FileWriter(filepath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
