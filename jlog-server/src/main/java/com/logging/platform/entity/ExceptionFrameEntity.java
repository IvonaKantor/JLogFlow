package com.logging.platform.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "exception_frames")
public class ExceptionFrameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exc_fr_seq")
    @SequenceGenerator(
            name = "exc_fr_seq",
            sequenceName = "exc_fr_id_sequence",
            allocationSize = 1
    )
    @Column(name="id")
    public int id;

    @Column(name = "class_name", nullable = false)
    public String className;

    @Column(name = "method_name", nullable = false)
    public String methodName;

    @Column(name = "line_number")
    public int lineNumber;
}