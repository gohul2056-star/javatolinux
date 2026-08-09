package com.gesture.model;

public enum ActionType {
    MAXIMIZE_WINDOW("Maximize Window"),
    MINIMIZE_WINDOW("Minimize Window"),
    RESTORE_WINDOW("Restore Window"),
    SWITCH_TABS("Switch Tabs"),
    SCROLL_UP("Scroll Up"),
    SCROLL_DOWN("Scroll Down"),
    ZOOM_IN("Zoom In"),
    ZOOM_OUT("Zoom Out"),
    LOCK_PC("Lock PC"),
    SLEEP_PC("Sleep PC"),
    SCREENSHOT("Screenshot"),
    VOLUME_UP("Volume Up"),
    VOLUME_DOWN("Volume Down"),
    VOLUME_MUTE("Mute Volume"),
    MEDIA_PLAY_PAUSE("Play/Pause Media"),
    MEDIA_NEXT("Next Track"),
    MEDIA_PREV("Previous Track");

    private final String displayName;

    ActionType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
