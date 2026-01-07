package com.logging.platform.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exceptions")
public class ExceptionEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "ref_id")
    public int refId;

    @Column(name = "exception_type", nullable = false, length = 255)
    public String exceptionType;

    @Column(name = "exception_message")
    public String exceptionMessage;

    @Column(name = "root_cause")
    public String rootCause;

    @Column(name = "created_at", updatable = false)
    public LocalDateTime createdAt;

    @OneToMany(mappedBy = "exception", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("frameOrder ASC")
    public List<ExceptionFrameEntity> frames = new ArrayList<>();

    @OneToOne(mappedBy = "exception", fetch = FetchType.LAZY)
    public LogEntity log;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public static ExceptionEntity findByRefId(Long refId) {
        return find("refId", refId).firstResult();
    }

    public static List<ExceptionEntity> findByType(String exceptionType) {
        return list("exceptionType", exceptionType);
    }
}