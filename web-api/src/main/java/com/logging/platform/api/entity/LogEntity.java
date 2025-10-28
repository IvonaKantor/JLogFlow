package com.logging.platform.api.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import jakarta.persistence.*;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "logs", indexes = {
        @Index(name = "idx_logs_timestamp", columnList = "timestamp"),
        @Index(name = "idx_logs_level", columnList = "level"),
        @Index(name = "idx_logs_service", columnList = "serviceName"),
        @Index(name = "idx_logs_timestamp_level", columnList = "timestamp,level")
})
public class LogEntity extends PanacheEntity {

    @Column(nullable = false, unique = true)
    public String logId;

    @Column(nullable = false, length = 20)
    public String level;

    @Column(columnDefinition = "TEXT")
    public String message;

    @Column(nullable = false)
    public String serviceName;

    @Column(nullable = false)
    public LocalDateTime timestamp;

    @ElementCollection
    @CollectionTable(name = "metadata", joinColumns = @JoinColumn(name = "log_id"))
    @MapKeyColumn(name = "metadata_key")
    @Column(name = "metadata_value")
    public Map<String, String> metadata;

    @Column(length = 50)
    public String sourceIp;

    @Column(length = 100)
    public String userId;

    @Column
    public Long responseTime;

    @Column(length = 10)
    public String httpMethod;

    @Column
    public Integer httpStatus;

    public LogEntity() {
    }

    public LogEntity(String logId, String level, String message, String serviceName, LocalDateTime timestamp) {
        this.logId = logId;
        this.level = level;
        this.message = message;
        this.serviceName = serviceName;
        this.timestamp = timestamp;
    }

    public static List<LogEntity> findByLevel(String level) {
        return list("level", level);
    }

    public static List<LogEntity> findByService(String serviceName) {
        return list("serviceName", serviceName);
    }
}