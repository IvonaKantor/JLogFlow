package com.logging.platform.webapp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;

import jakarta.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class LogEntity extends PanacheEntity {

    public String logId;
    public Level level;
    public String message;
    public String serviceName;
    public LocalDateTime timestamp;

    public static LogEntity findByLogId(String logId) {
        return find("logId", logId).firstResult();
    }
}