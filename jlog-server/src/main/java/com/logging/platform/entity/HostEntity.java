package com.logging.platform.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "hosts")
public class HostEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "host_name", nullable = false, unique = true)
    public String hostName;

    @Column(name = "ip_address")
    public String ipAddress;

    @Column(name = "environment")
    public String environment;

    @Column(name = "created_at", updatable = false)
    public LocalDateTime createdAt;

    @OneToMany(mappedBy = "host", fetch = FetchType.LAZY)
    public List<ProcessEntity> processes;

    @OneToMany(mappedBy = "host", fetch = FetchType.LAZY)
    public List<LogEntity> logs;
}