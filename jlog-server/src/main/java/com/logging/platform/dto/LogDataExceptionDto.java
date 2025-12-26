package com.logging.platform.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.smallrye.common.constraint.NotNull;

public class LogDataExceptionDto {

    @NotNull
    @JsonProperty("refId")
    public Long refId;

    @JsonProperty("exceptionType")
    public String exceptionType;

    @NotNull
    @JsonProperty("message")
    public String message;

    public Long getRefId() {
        return refId;
    }

    public void setRefId(Long refId) {
        this.refId = refId;
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
}
