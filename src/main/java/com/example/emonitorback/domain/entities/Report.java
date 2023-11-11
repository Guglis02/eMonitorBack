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
    private Long authorId;

    @Column
    private Long reportedUserId;

    @Column
    private Long ticketId;

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String context;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public Report(Long authorId, Long reportedUserId, Long ticketId, String title, String context) {
        this.authorId = authorId;
        this.reportedUserId = reportedUserId;
        this.ticketId = ticketId;
        this.title = title;
        this.context = context;
    }
}
