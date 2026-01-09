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
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExceptionEntity getExceptionId() {
        return exceptionId;
    }

    public void setException(ExceptionEntity exceptionId) {
        this.exceptionId = exceptionId;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exception_id")
    private ExceptionEntity exceptionId;

    @Column(nullable = false)
    private String className;

    @Column(nullable = false)
    private String methodName;

    private int lineNumber;
}
