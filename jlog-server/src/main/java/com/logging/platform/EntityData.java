package com.logging.platform;

import jakarta.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.time.LocalDateTime;

@Entity
public class EntityData extends PanacheEntity {
    public String serviceName;
    public String level;
    public String message;
    public LocalDateTime timestamp;
    public String traceId;
}