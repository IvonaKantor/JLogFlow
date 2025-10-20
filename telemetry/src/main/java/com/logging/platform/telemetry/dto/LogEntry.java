package com.logging.platform.telemetry.dto;

import java.time.LocalTime;

public class LogEntry {
    private String appName;
    private String level;
    private String message;
    private LocalTime timestamp;
    private String threadName;

    public LogEntry() {
    }

    public LogEntry(String appName, String level, String message, LocalTime timestamp, String threadName) {
        this.appName = appName;
        this.level = level;
        this.message = message;
        this.timestamp = timestamp;
        this.threadName = threadName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "appName='" + appName + '\'' +
                ", level='" + level + '\'' +
                ", message'" + message + '\'' +
                ", timestamp'" + timestamp + '\'' +
                ", threadName'" + threadName + '}';

    }
}
