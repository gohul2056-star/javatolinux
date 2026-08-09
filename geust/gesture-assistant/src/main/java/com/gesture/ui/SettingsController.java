package com.gesture.ui;

import com.gesture.main.GestureApp;
import com.gesture.model.ActionType;
import com.gesture.model.AppConfig;
import com.gesture.network.VisionClient;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Map;
import java.util.Random;

public class SettingsController {
    
    @FXML private TextField gestureNameField;
    @FXML private Label trainingStatusLabel;
    @FXML private ProgressBar trainingProgressBar;
    @FXML private ListView<String> gestureListView;
    @FXML private ComboBox<ActionType> actionComboBox;
    @FXML private Slider confidenceSlider;
    @FXML private Slider holdSlider;

    private AppConfig config;
    private VisionClient client;
    
    @FXML
    public void initialize() {
        config = GestureApp.getConfig();
        client = GestureApp.getVisionClient();
        
        // Listeners for sliders
        confidenceSlider.setValue(config.getConfidenceThreshold());
        holdSlider.setValue(config.getHoldDelayMs());
        
        // Populate actions
        actionComboBox.getItems().addAll(ActionType.values());
        
        // Populate gestures
        refreshGestureList();
        
        // Add listener to vision client for training feedback
        // In a real app we'd want to aggregate listeners if GestureEngine also uses them
        // For simplicity here, we add it just to get updates and re-dispatch.
        // But since VisionClient only supports one listener currently, we'd need to modify it or 
        // handle it through a publisher/subscriber.
        // For this demo, let's assume the VisionClient could support an event bus or we just add a UI hook.
        
        client.addListener(new VisionClient.VisionListener() {
            @Override
            public void onPrediction(String gestureName, double confidence) {
                // UI could show real-time recognized gestures if we want
            }

            @Override
            public void onTrainingProgress(double progress) {
                Platform.runLater(() -> {
                    trainingProgressBar.setProgress(progress);
                    trainingStatusLabel.setText(String.format("Status: Training... %.0f%%", progress * 100));
                });
            }

            @Override
            public void onTrainingComplete(boolean success) {
                Platform.runLater(() -> {
                    if (success) {
                        trainingStatusLabel.setText("Status: Training Complete");
                        refreshGestureList(); // Refresh in case it's a new gesture
                    } else {
                        trainingStatusLabel.setText("Status: Training Failed (need varied data)");
                    }
                    trainingProgressBar.setProgress(0);
                });
            }
        });
    }

    private void refreshGestureList() {
        gestureListView.getItems().clear();
        for (Map.Entry<String, ActionType> entry : config.getGestureMappings().entrySet()) {
            gestureListView.getItems().add(entry.getKey() + " -> " + entry.getValue().getDisplayName());
        }
        // Also we should list gestures that have NO action mapped yet.
        // For now, when we train a gesture, we will default it to some action or null action in config.
    }

    @FXML
    private void handleTrainGesture() {
        String name = gestureNameField.getText().trim();
        if (name.isEmpty()) return;
        
        int id = Math.abs(name.hashCode());
        // Pre-add to config so it shows up in list if not there
        if (!config.getGestureMappings().containsKey(name)) {
            config.getGestureMappings().put(name, null); 
        }
        
        client.sendStartTraining(id, name);
    }

    @FXML
    private void handleMapAction() {
        String selected = gestureListView.getSelectionModel().getSelectedItem();
        ActionType action = actionComboBox.getValue();
        if (selected != null && action != null) {
            String name = selected.split(" -> ")[0];
            config.getGestureMappings().put(name, action);
            refreshGestureList();
        }
    }

    @FXML
    private void handleDeleteGesture() {
        String selected = gestureListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String name = selected.split(" -> ")[0];
            config.getGestureMappings().remove(name);
            int id = Math.abs(name.hashCode());
            client.sendDeleteGesture(id);
            refreshGestureList();
        }
    }

    @FXML
    private void handleSaveSettings() {
        config.setConfidenceThreshold(confidenceSlider.getValue());
        config.setHoldDelayMs((long) holdSlider.getValue());
        config.save("config.json");
        System.out.println("Settings saved.");
    }
}
