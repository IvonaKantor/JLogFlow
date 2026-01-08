package com.logging.platform.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "services")
public class ServicesEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_seq")
    @SequenceGenerator(
            name = "service_seq",
            sequenceName = "service_id_sequence",
            allocationSize = 1
    )
    public int id;

    @Column(nullable = false, unique = true)
    public String serviceName;

    @Column(unique = true)
    public String serviceId;

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
    public List<LogEntity> logs;
}