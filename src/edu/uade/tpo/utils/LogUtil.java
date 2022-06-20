package edu.uade.tpo.utils;

public class LogUtil {
    public void logMessage(String message, Object... args) {
        System.out.printf("Log: " + message + "%n", args);
    }
}
