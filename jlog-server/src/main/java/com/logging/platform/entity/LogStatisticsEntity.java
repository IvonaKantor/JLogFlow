package com.logging.platform.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_statistics")
public class LogStatisticsEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    public ServiceEntity service;

    @Column(name = "log_date", nullable = false)
    public Time logDate;

    @Column(name = "hour", nullable = false)
    public Integer hour;

    @Column(name = "level", nullable = false, length = 20)
    public String level;

    @Column(name = "log_count")
    public Integer logCount;

    @Column(name = "last_updated")
    public LocalDateTime lastUpdated;
}