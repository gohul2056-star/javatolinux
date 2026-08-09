package com.gesture.main;

import com.gesture.model.AppConfig;
import com.gesture.network.VisionClient;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class GestureApp extends Application {

    private static AppConfig config;
    private static VisionClient visionClient;
    private static GestureEngine engine;
    private Process pythonProcess;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Platform.setImplicitExit(false); // Keep running in background

        config = AppConfig.load("config.json");
        visionClient = new VisionClient();
        engine = new GestureEngine(config, visionClient);
        
        startPythonBackend();
        visionClient.connect();

        TrayManager trayManager = new TrayManager();
        trayManager.setupTray(primaryStage);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Settings.fxml"));
        // If FXML is not ready, just make a basic scene
        Scene scene;
        try {
            scene = new Scene(loader.load(), 800, 600);
        } catch (Exception e) {
            System.err.println("Could not load FXML, using fallback UI.");
            scene = new Scene(new VBox(), 800, 600);
        }

        primaryStage.setTitle("Gesture Assistant");
        primaryStage.setScene(scene);
        
        // Hide on close instead of exit
        primaryStage.setOnCloseRequest(event -> {
            primaryStage.hide();
            event.consume();
        });

        // Uncomment to show on start
        // primaryStage.show();
    }

    private void startPythonBackend() {
        try {
            File visionDir = new File("vision");
            if (visionDir.exists()) {
                ProcessBuilder pb = new ProcessBuilder("python", "app.py");
                pb.directory(visionDir);
                // pb.inheritIO(); // uncomment for debugging
                pythonProcess = pb.start();
                System.out.println("Started Python Vision Microservice.");
            } else {
                System.err.println("Vision directory not found. Python backend not started.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception {
        config.save("config.json");
        if (visionClient != null) {
            visionClient.disconnect();
        }
        if (pythonProcess != null && pythonProcess.isAlive()) {
            pythonProcess.destroy();
        }
        super.stop();
    }

    public static AppConfig getConfig() {
        return config;
    }

    public static VisionClient getVisionClient() {
        return visionClient;
    }
}
