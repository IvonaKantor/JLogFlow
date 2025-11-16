package com.logging.platform;

import java.time.LocalDateTime;

public class Message {

    private String serviceName;
    private String level;
    private String message;
    private LocalDateTime timestamp;
    private String traceId;

    public Message() {
        this.timestamp = LocalDateTime.now();
    }

    public Message(String serviceName, String level, String message) {
        this();
        this.serviceName = serviceName;
        this.level = level;
        this.message = message;
    }

    public Message(String serviceName, String level, String message, String traceId) {
        this(serviceName, level, message);
        this.traceId = traceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public boolean isError() {
        return "ERROR".equalsIgnoreCase(level);
    }

    public boolean isWarning() {
        return "WARN".equalsIgnoreCase(level) || "WARNING".equalsIgnoreCase(level);
    }

    public boolean isInfo() {
        return "INFO".equalsIgnoreCase(level);
    }

    public boolean isDebug() {
        return "DEBUG".equalsIgnoreCase(level);
    }
}
