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

}