package com.logging.platform.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "loggers")
public class LoggerEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "logger_name", nullable = false, unique = true)
    public String loggerName;

    @Column(name = "logger_class_name", length = 255)
    public String loggerClassName;

    @Column(name = "created_at", updatable = false)
    public LocalDateTime createdAt;

    @OneToMany(mappedBy = "logger", fetch = FetchType.LAZY)
    public List<LogEntity> logs;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public static LoggerEntity findByLoggerName(String loggerName) {
        return find("loggerName", loggerName).firstResult();
    }
}