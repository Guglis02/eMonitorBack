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
@Table(name = "message")
public class Message {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private Long ticketId;

    @Column
    private Long senderId;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public Message(String content, Long ticketId, Long senderId) {
        this.content = content;
        this.ticketId = ticketId;
        this.senderId = senderId;
    }
}
