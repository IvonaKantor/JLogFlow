package com.logging.platform.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exceptions")
public class ExceptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exc_seq")
    @SequenceGenerator(
            name = "exc_seq",
            sequenceName = "exc_id_sequence",
            allocationSize = 1
    )
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRefIid() {
        return refIid;
    }

    public void setRefIid(int refIid) {
        this.refIid = refIid;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<ExceptionFrameEntity> getFrames() {
        return frames;
    }

    public void setFrames(List<ExceptionFrameEntity> frames) {
        this.frames = frames;
    }

    public LogEntity getLog() {
        return log;
    }

    public void setLog(LogEntity log) {
        this.log = log;
    }

    private int refIid;

    @Column(nullable = false)
    private String exceptionType;

    private String message;


    @Column(updatable = false)
    private LocalDateTime timestamp;

    @OneToMany(mappedBy = "exceptionId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExceptionFrameEntity> frames = new ArrayList<>();

    @OneToOne(mappedBy = "exceptionId")
    private LogEntity log;
}
