
package com.logging.platform.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "logs")
public class LogEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    public ServicesEntity service_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exception_id")
    public ExceptionEntity exception_id;

    @Column(name = "logger_class_name")
    public String logger_class_name;

    @Column(name = "logger_name")
    public String logger_name;

    @Column(name = "timestamp", nullable = false)
    public LocalDateTime timestamp;

    @Column(name = "sequence")
    public Integer sequence;

    @Column(name = "level", nullable = false, length = 20)
    public String level;

    @Column(name = "message", nullable = false)
    public String message;

    @Column(name = "thread_name", length = 255)
    public String thread_name;

    @Column(name = "thread_id")
    public int thread_id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "mdc")
    public Map<String, Object> mdc;

    @Column(name = "ndc")
    public String ndc;

    @Column(name = "update_data", updatable = false)
    public LocalDateTime update_data;

    @Column(name = "create_data", updatable = false)
    public LocalDateTime create_data;

    @Column(name = "updated_at")
    public LocalDateTime updated_at;

    @Column(name = "process_name", nullable = false)
    public String process_name;

    @Column(name = "process_id", nullable = false)
    public Integer process_id;
}
