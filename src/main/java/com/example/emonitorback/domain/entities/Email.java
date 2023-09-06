package com.example.emonitorback.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "email")
public class Email {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long notification_id;

    @Column
    private String subject;

    @Column
    private String content;

    public Email(Long notification_id, String subject, String content) {
        this.notification_id = notification_id;
        this.subject = subject;
        this.content = content;
    }
}
