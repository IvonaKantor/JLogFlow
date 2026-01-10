package com.logging.platform.entity;

import jakarta.persistence.*;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.List;

@Entity
@Table(name = "services")
public class ServicesEntity extends PanacheEntity {

    @Column(nullable = false, unique = true)
    private String serviceName;

    @Column(unique = true)
    private String serviceId;

    @OneToMany(mappedBy = "serviceId", fetch = FetchType.LAZY)
    private List<LogEntity> logs;

    public List<LogEntity> getLogs() {
        return logs;
    }

    public void setLogs(List<LogEntity> logs) {
        this.logs = logs;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}