package com.logging.platform.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@RegisterForReflection
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogDataResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("uuid")
    private UUID uuid;

    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime timestamp;

    @JsonProperty("sequence")
    private Integer sequence;

    @JsonProperty("loggerClassName")
    private String loggerClassName;

    @JsonProperty("loggerName")
    private String loggerName;

    @JsonProperty("level")
    private String level;

    @JsonProperty("message")
    private String message;

    @JsonProperty("threadName")
    private String threadName;

    @JsonProperty("threadId")
    private Integer threadId;

    @JsonProperty("mdc")
    private Map<String, String> mdc;

    @JsonProperty("ndc")
    private String ndc;

    @JsonProperty("hostName")
    private String hostName;

    @JsonProperty("processName")
    private String processName;

    @JsonProperty("processId")
    private Integer processId;

    @JsonProperty("exception")
    private LogDataExceptionResponse exception;

    @JsonProperty("serviceName")
    private String serviceName;

    @JsonProperty("serviceId")
    private String serviceId;

    @JsonProperty("createdAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime createdAt;

    @JsonProperty("updatedAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime updatedAt;

    public LogDataResponse() {}

    public LogDataResponse(Long id, LocalDateTime timestamp, String level, String message) {
        this.id = id;
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
    }
}