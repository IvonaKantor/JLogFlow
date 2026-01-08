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
    public int ref_id;

    @Column(name = "exception_type", nullable = false, length = 255)
    public String exception_type;

    @Column(name = "message")
    public String message;


    @Column(name = "timestamp", updatable = false)
    public LocalDateTime timestamp;

    @OneToMany(mappedBy = "exception", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<ExceptionFrameEntity> frames = new ArrayList<>();

    @OneToOne(mappedBy = "exception")
    public LogEntity log;
}
