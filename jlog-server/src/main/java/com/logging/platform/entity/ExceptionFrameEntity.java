package com.logging.platform.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exception_frames")
public class ExceptionFrameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exception_frame_seq")
    @SequenceGenerator(
            name = "exception_frame_seq",
            sequenceName = "exception_frame_id_seq",
            allocationSize = 1
    )
    public int id;

    @Column(nullable = false)
    public String className;

    @Column(nullable = false)
    public String methodName;

    public int lineNumber;
}