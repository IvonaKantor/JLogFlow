package com.logging.platform.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "processes")
public class ProcessEntity extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "process_name", nullable = false, unique = true)
    public String processName;

    @Column(name = "process_id", nullable = false,  unique = true)
    public Integer processId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id", unique = true)
    public HostEntity host;

    @Column(name = "start_time")
    public LocalDateTime startTime;

    @OneToMany(mappedBy = "process", fetch = FetchType.LAZY)
    public List<LogEntity> logs;

    @PrePersist
    protected void onCreate() {
        if (startTime == null) {
            startTime = LocalDateTime.now();
        }
    }
}