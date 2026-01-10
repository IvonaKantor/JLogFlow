package com.logging.platform.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "mdc")
public class MdcEntity extends PanacheEntity {

    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> mdcData;

    @Column(updatable = false)
    private LocalDateTime timestamp;

    @OneToOne(mappedBy = "mdcEntity")
    private LogEntity logEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, Object> getMdcData() {
        return mdcData;
    }

    public void setMdcData(Map<String, Object> mdcData) {
        this.mdcData = mdcData;
    }

    public LogEntity getLogEntity() {
        return logEntity;
    }

    public void setLogEntity(LogEntity logEntity) {
        this.logEntity = logEntity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
