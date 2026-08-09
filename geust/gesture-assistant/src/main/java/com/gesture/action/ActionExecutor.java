package com.gesture.action;

import com.gesture.model.ActionType;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ActionExecutor {
    private static Robot robot;
    
    // Virtual Key Codes for Media/Volume
    private static final int VK_VOLUME_MUTE = 0xAD;
    private static final int VK_VOLUME_DOWN = 0xAE;
    private static final int VK_VOLUME_UP = 0xAF;
    private static final int VK_MEDIA_NEXT_TRACK = 0xB0;
    private static final int VK_MEDIA_PREV_TRACK = 0xB1;
    private static final int VK_MEDIA_PLAY_PAUSE = 0xB3;
    
    public interface User32Ext extends User32 {
        User32Ext INSTANCE = Native.load("user32", User32Ext.class);
        void keybd_event(byte bVk, byte bScan, int dwFlags, int dwExtraInfo);
        boolean LockWorkStation();
        boolean ShowWindow(HWND hWnd, int nCmdShow);
    }

    private static final int SW_MINIMIZE = 6;
    private static final int SW_MAXIMIZE = 3;
    private static final int SW_RESTORE = 9;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void execute(ActionType action) {
        if (action == null || robot == null) return;

        System.out.println("Executing Action: " + action.getDisplayName());

        switch (action) {
            case MAXIMIZE_WINDOW:
                HWND hwndMax = User32Ext.INSTANCE.GetForegroundWindow();
                if (hwndMax != null) User32Ext.INSTANCE.ShowWindow(hwndMax, SW_MAXIMIZE);
                break;
            case MINIMIZE_WINDOW:
                HWND hwndMin = User32Ext.INSTANCE.GetForegroundWindow();
                if (hwndMin != null) User32Ext.INSTANCE.ShowWindow(hwndMin, SW_MINIMIZE);
                break;
            case RESTORE_WINDOW:
                HWND hwndRest = User32Ext.INSTANCE.GetForegroundWindow();
                if (hwndRest != null) User32Ext.INSTANCE.ShowWindow(hwndRest, SW_RESTORE);
                break;
            case SWITCH_TABS:
                pressCombination(KeyEvent.VK_CONTROL, KeyEvent.VK_TAB);
                break;
            case SCROLL_UP:
                robot.mouseWheel(-3);
                break;
            case SCROLL_DOWN:
                robot.mouseWheel(3);
                break;
            case ZOOM_IN:
                pressCombination(KeyEvent.VK_CONTROL, KeyEvent.VK_EQUALS);
                break;
            case ZOOM_OUT:
                pressCombination(KeyEvent.VK_CONTROL, KeyEvent.VK_MINUS);
                break;
            case LOCK_PC:
                User32Ext.INSTANCE.LockWorkStation();
                break;
            case SLEEP_PC:
                try {
                    Runtime.getRuntime().exec("rundll32.exe powrprof.dll,SetSuspendState 0,1,0");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case SCREENSHOT:
                pressCombination(KeyEvent.VK_WINDOWS, KeyEvent.VK_PRINTSCREEN);
                break;
            case VOLUME_UP:
                simulateMediaKey(VK_VOLUME_UP);
                break;
            case VOLUME_DOWN:
                simulateMediaKey(VK_VOLUME_DOWN);
                break;
            case VOLUME_MUTE:
                simulateMediaKey(VK_VOLUME_MUTE);
                break;
            case MEDIA_PLAY_PAUSE:
                simulateMediaKey(VK_MEDIA_PLAY_PAUSE);
                break;
            case MEDIA_NEXT:
                simulateMediaKey(VK_MEDIA_NEXT_TRACK);
                break;
            case MEDIA_PREV:
                simulateMediaKey(VK_MEDIA_PREV_TRACK);
                break;
        }
    }

    private static void pressCombination(int... keys) {
        for (int key : keys) robot.keyPress(key);
        for (int i = keys.length - 1; i >= 0; i--) robot.keyRelease(keys[i]);
    }

    private static void simulateMediaKey(int vkCode) {
        // KEYEVENTF_EXTENDEDKEY = 0x0001, KEYEVENTF_KEYUP = 0x0002
        User32Ext.INSTANCE.keybd_event((byte) vkCode, (byte) 0, 0x0001, 0);
        User32Ext.INSTANCE.keybd_event((byte) vkCode, (byte) 0, 0x0001 | 0x0002, 0);
    }
}
