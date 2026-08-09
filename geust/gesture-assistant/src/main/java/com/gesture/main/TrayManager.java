package com.gesture.main;

import javafx.application.Platform;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.InputStream;

public class TrayManager {

    private SystemTray tray;
    private TrayIcon trayIcon;

    public void setupTray(Stage primaryStage) {
        if (!SystemTray.isSupported()) {
            System.out.println("System tray is not supported!");
            return;
        }

        tray = SystemTray.getSystemTray();

        try {
            // A simple 16x16 icon could be loaded here. For now we use a default Toolkit image or a blank one.
            Image image = Toolkit.getDefaultToolkit().createImage(new byte[100]); // Dummy placeholder
            try (InputStream is = getClass().getResourceAsStream("/icon.png")) {
                if (is != null) {
                    image = ImageIO.read(is);
                }
            }

            PopupMenu popup = new PopupMenu();

            MenuItem settingsItem = new MenuItem("Settings");
            settingsItem.addActionListener(e -> Platform.runLater(() -> {
                primaryStage.show();
                primaryStage.toFront();
            }));

            MenuItem exitItem = new MenuItem("Exit");
            exitItem.addActionListener(e -> {
                System.exit(0);
            });

            popup.add(settingsItem);
            popup.addSeparator();
            popup.add(exitItem);

            trayIcon = new TrayIcon(image, "Gesture Assistant", popup);
            trayIcon.setImageAutoSize(true);
            
            trayIcon.addActionListener(e -> Platform.runLater(() -> {
                primaryStage.show();
                primaryStage.toFront();
            }));

            tray.add(trayIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
