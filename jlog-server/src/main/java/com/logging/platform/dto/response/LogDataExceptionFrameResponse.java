package com.logging.platform.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogDataExceptionFrameResponse {

    @JsonProperty("class")
    private String clazz;

    @JsonProperty("method")
    private String method;

    @JsonProperty("line")
    private Integer line;

    @JsonProperty("fileName")
    private String fileName;

    @JsonProperty("isNative")
    private Boolean isNative;

    public LogDataExceptionFrameResponse() {}

    public LogDataExceptionFrameResponse(String clazz, String method, Integer line) {
        this.clazz = clazz;
        this.method = method;
        this.line = line;
    }
}