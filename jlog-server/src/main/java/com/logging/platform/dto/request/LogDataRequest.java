package com.logging.platform.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.smallrye.common.constraint.NotNull;

import java.util.Date;
import java.util.Map;

public class LogDataRequest {

    @NotNull
    @JsonProperty("timestamp")
    private Date timestamp;

    @JsonProperty("sequence")
    private int sequence;

    @NotNull
    @JsonProperty("message")
    private String message;

    @NotNull
    @JsonProperty("level")
    private String level;

    @JsonProperty("loggerClassName")
    private String loggerClassName;

    @JsonProperty("loggerName")
    private String loggerName;

    @JsonProperty("threadName")
    private String threadName;

    @JsonProperty("threadId")
    private int threadId;

    @JsonProperty("mdc")
    private Map<String, Object> mdc;

    @JsonProperty("exception")
    private LogDataExceptionRequest exception;

    @JsonProperty("serviceName")
    private String serviceName;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLoggerClassName() {
        return loggerClassName;
    }

    public void setLoggerClassName(String loggerClassName) {
        this.loggerClassName = loggerClassName;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }

    public Map<String, Object> getMdc() {
        return mdc;
    }

    public void setMdc(Map<String, Object> mdc) {
        this.mdc = mdc;
    }

    public LogDataExceptionRequest getException() {
        return exception;
    }

    public void setException(LogDataExceptionRequest exception) {
        this.exception = exception;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @JsonProperty("serviceId")
    private String serviceId;
}
