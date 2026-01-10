package com.logging.platform.entity;

import jakarta.persistence.*;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "exception_frames")
public class ExceptionFrameEntity extends PanacheEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exception_id")
    private ExceptionEntity exceptionId;

    @Column(nullable = false)
    private String className;

    @Column(nullable = false)
    private String methodName;

    private int lineNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
