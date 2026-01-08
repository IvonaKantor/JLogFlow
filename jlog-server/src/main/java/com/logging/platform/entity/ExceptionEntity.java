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
    @Column(name="id")
    public int id;

    public int ref_id;

    @Column(name = "exception_type", nullable = false, length = 255)
    public String exceptionType;

    public String message;


    @Column(name = "timestamp", updatable = false)
    public LocalDateTime timestamp;

    @OneToMany(mappedBy = "exception", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<ExceptionFrameEntity> frames = new ArrayList<>();

    @OneToOne(mappedBy = "exception")
    public LogEntity log;
}
