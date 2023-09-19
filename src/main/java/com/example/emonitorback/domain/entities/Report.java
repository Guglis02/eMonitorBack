package com.example.emonitorback.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "report")
public class Report {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    @Column
    private Long ticketId;

    @Column(columnDefinition = "TEXT")
    private String context;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public Report(Long ticketId, String context) {
        this.ticketId = ticketId;
        this.context = context;
    }
}
