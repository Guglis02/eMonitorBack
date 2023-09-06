package com.example.emonitorback.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attachment")
public class Attachment {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String path;

    @Column
    private Long message_id;

    public Attachment(String path, Long message_id) {
        this.path = path;
        this.message_id = message_id;
    }
}
