package com.logging.platform.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "logs")
public class LogEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "uuid")
    public UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    public ServicesEntity service;

    @Column(name = "timestamp", nullable = false)
    public LocalDateTime timestamp;

    @Column(name = "sequence")
    public Integer sequence;

    @Column(name = "level", nullable = false, length = 20)
    public String level;

    @Column(name = "message", nullable = false)
    public String message;

    @Column(name = "thread_name", length = 255)
    public String threadName;

    @Column(name = "thread_id")
    public Integer threadId;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "mdc")
    public Map<String, Object> mdc;

    @Column(name = "ndc")
    public String ndc;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exception_id")
    public ExceptionEntity exception;

    @Column(name = "created_at", updatable = false)
    public LocalDateTime createdAt;

    @Column(name = "updated_at")
    public LocalDateTime updatedAt;
}