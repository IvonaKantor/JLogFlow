package com.logging.platform.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.smallrye.common.constraint.NotNull;

public class LogDataExceptionframeRequest {

    @NotNull
    @JsonProperty("clazz")
    private String clazz;

    @NotNull
    @JsonProperty("method")
    private String method;

    @NotNull
    @JsonProperty("line")
    private int line;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
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
