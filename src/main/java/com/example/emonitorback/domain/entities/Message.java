package com.example.emonitorback.domain.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @Column
    private String content;

    @Column
    private Long ticketId;

    @Column
    private Long senderId;

    public Message(String content, Long ticketId, Long senderId) {
        this.content = content;
        this.ticketId = ticketId;
        this.senderId = senderId;
    }
}
