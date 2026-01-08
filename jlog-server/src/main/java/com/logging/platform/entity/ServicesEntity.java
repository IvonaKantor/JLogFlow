package com.logging.platform.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "services")
public class ServicesEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "service_name", nullable = false, unique = true)
    public String serviceName;

    @Column(name = "service_id", unique = true)
    public String serviceId;

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
    public List<LogEntity> logs;
}