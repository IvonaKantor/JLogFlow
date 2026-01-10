
package com.logging.platform.entity;

import com.logging.platform.models.LogDataLevel;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "logs")
public class LogEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_seq")
    @SequenceGenerator(
            name = "log_seq",
            sequenceName = "log_id_sequence",
            allocationSize = 1
    )
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private ServicesEntity serviceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServicesEntity getServiceId() {
        return serviceId;
    }

    public void setServiceId(ServicesEntity serviceId) {
        this.serviceId = serviceId;
    }

    public ExceptionEntity getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(ExceptionEntity exceptionId) {
        this.exceptionId = exceptionId;
    }

    public String getLoggerClassName() {
        return loggerClassName;
    }

    public void setLoggerClassName(String loggerClassName) {
        this.loggerClassName = loggerClassName;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public LogDataLevel getLevel() {
        return level;
    }

    public void setLevel(LogDataLevel level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }

    public String getNdc() {
        return ndc;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }

    public LocalDateTime getCreateData() {
        return createData;
    }

    public void setCreateData(LocalDateTime createData) {
        this.createData = createData;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exception_id")
    private ExceptionEntity exceptionId;

    private String loggerClassName;

    private String loggerName;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    private Integer sequence;

    @Enumerated
    @Column(nullable = false)
    private LogDataLevel level;

    @Column(nullable = false)
    private String message;

    private String threadName;

    private int threadId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "mdc_id")
    private MdcEntity mdcEntity;

    private String ndc;

    @Column(updatable = false)
    private LocalDateTime createData;

    @Column(nullable = false)
    private String processName;

    @Column(nullable = false)
    private Integer processId;
}
