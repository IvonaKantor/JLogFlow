
package com.logging.platform.entity;

import com.logging.platform.models.LogDataLevel;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "logs")
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_seq")
    @SequenceGenerator(
            name = "log_seq",
            sequenceName = "log_id_sequence",
            allocationSize = 1
    )
    public int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    public ServicesEntity serviceId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exception_id")
    public ExceptionEntity exceptionId;

    public String loggerClassName;

    public String loggerName;

    @Column(nullable = false)
    public LocalDateTime timestamp;

    public Integer sequence;

    @Enumerated
    @Column(nullable = false)
    public LogDataLevel level;

    @Column(nullable = false)
    public String message;

    public String threadName;

    public int threadId;

    @JdbcTypeCode(SqlTypes.JSON)
    public Map<String, Object> mdc;

    public String ndc;

    @Column(updatable = false)
    public LocalDateTime createData;

    @Column(nullable = false)
    public String processName;

    @Column(nullable = false)
    public Integer processId;
}
