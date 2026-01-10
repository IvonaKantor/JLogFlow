package com.logging.platform.dto;

import java.time.LocalDateTime;

public class ExceptionDto {

    private int id;
    private int refIid;
    private String exceptionType;
    private String message;
    private LocalDateTime timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRefIid() {
        return refIid;
    }

    public void setRefIid(int refIid) {
        this.refIid = refIid;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
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
}
