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

    @Column(columnDefinition="TEXT")
    private String attachment;

    @Column
    private Long messageId;

    public Attachment(String attachment, Long messageId) {
        this.attachment = attachment;
        this.messageId = messageId;
    }
}
