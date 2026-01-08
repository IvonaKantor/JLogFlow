
package com.logging.platform.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "logs")
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_seq)
    @SequenceGenerator(
            name = "log_seq",
            sequenceName = "log_id_sequence",
            allocationSize = 1
    )
    @Column(name="id")
    public int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    public ServicesEntity serviceId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exception_id")
    public ExceptionEntity exceptionId;

    @Column(name = "logger_class_name")
    public String loggerClassName;

    @Column(name = "logger_name")
    public String loggerName;

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
    public int threadId;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "mdc")
    public Map<String, Object> mdc;

    @Column(name = "ndc")
    public String ndc;

    @Column(name = "create_data", updatable = false)
    public LocalDateTime createData;

    @Column(name = "process_name", nullable = false)
    public String processName;

    @Column(name = "process_id", nullable = false)
    public Integer processId;
}
