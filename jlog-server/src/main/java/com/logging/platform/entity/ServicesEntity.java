package com.logging.platform.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "services")
public class ServicesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_seq")
    @SequenceGenerator(
            name = "service_seq",
            sequenceName = "service_id_sequence",
            allocationSize = 1
    )
    private int id;

    @Column(nullable = false, unique = true)
    private String serviceName;

    @Column(unique = true)
    private String serviceId;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "serviceId", fetch = FetchType.LAZY)
    private List<LogEntity> logs;
}