# Gesture Assistant

A production-ready Windows background application for custom hand gesture recognition and action mapping.

## Architecture

This project uses a dual-process architecture:
- **Vision Microservice (Python):** Handles webcam capture and MediaPipe Hands inference. Uses scikit-learn (SVM) to train and predict custom gestures based on normalized hand landmarks. Communicates via a local socket server (Port 8123).
- **Core App (Java 21):** A JavaFX desktop application running in the system tray. Manages configuration, settings UI, maps gestures to actions, and executes Windows-specific actions using Java `Robot` and `JNA` (`user32.dll`).

## Setup Instructions

### 1. Python Environment

Ensure Python 3.9+ is installed.

```bash
cd vision
pip install -r requirements.txt
```

### 2. Java Environment

Ensure JDK 21 and Maven are installed.

```bash
# Build the project
mvn clean install
```

### 3. Running the Application

The Java Application will automatically spawn the Python Vision Microservice when started.

```bash
mvn javafx:run
```

## Features

- **Custom Gesture Training:** Provide a name and hold a pose in front of the camera to train your own gestures. The SVM model will learn your hand landmarks.
- **Action Mapping:** Map gestures to actions such as Maximize Window, Zoom In, Volume Up, Lock PC, and more.
- **Background Mode:** Runs silently in the System Tray. Right-click the tray icon to open Settings or Exit.
