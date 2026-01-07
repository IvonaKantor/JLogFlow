package com.logging.platform.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "exception_frames")
public class ExceptionFrameEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exception_id", nullable = false)

    @Column(name = "frame_order", nullable = false)
    public Integer frameOrder;

    @Column(name = "class_name", nullable = false, length = 255)
    public String className;

    @Column(name = "method_name", nullable = false, length = 255)
    public String methodName;

    @Column(name = "line_number")
    public Integer lineNumber;

    @Column(name = "file_name", length = 255)
    public String fileName;

    @Column(name = "is_native")
    public Boolean isNative;
}