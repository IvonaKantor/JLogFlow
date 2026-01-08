package com.logging.platform.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "services")
public class ServicesEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serv_seq")
    @SequenceGenerator(
            name = "serv_seq",
            sequenceName = "serv_id_sequence",
            allocationSize = 1
    )
    @Column(name="id")
    public int id;

    @Column(name = "service_name", nullable = false, unique = true)
    public String serviceName;

    @Column(name = "service_id", unique = true)
    public String service_id;

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
    public List<LogEntity> logs;
}