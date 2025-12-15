package com.logging.platform.models;

public class LogDataExceptionFrame {
    private String clazz;
    private String method;
    private int line;

    public String getClazz() {
        return clazz;
    }

    public void setClass(String clazz) {
        this.clazz = clazz;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }
}
