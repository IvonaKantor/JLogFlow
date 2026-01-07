package com.logging.platform.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogDataExceptionResponse {

    @JsonProperty("refId")
    private Long refId;

    @JsonProperty("exceptionType")
    private String exceptionType;

    @JsonProperty("message")
    private String message;

    @JsonProperty("frames")
    private List<LogDataExceptionFrameResponse> frames;

    @JsonProperty("frameCount")
    private Integer frameCount;

    @JsonProperty("rootCause")
    private String rootCause;

    public LogDataExceptionResponse() {}

    public LogDataExceptionResponse(String exceptionType, String message) {
        this.exceptionType = exceptionType;
        this.message = message;
    }
}