package com.example.emonitorback.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String subject;

    @Column
    private String content;

    @Column
    private String topicId;

    @Column
    private Long studentCreatorId;

    @Column
    private Long assignedMonitorId;

    @Column
    private String status;

    @ManyToMany
    @JoinTable(
        name = "ticket_users",
        joinColumns = @JoinColumn(name = "ticket_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    public  Ticket(String subject, String content, String topicId, Long studentCreatorId, Long assignedMonitorId, String status) {
        this.subject = subject;
        this.content = content;
        this.topicId = topicId;
        this.studentCreatorId = studentCreatorId;
        this.assignedMonitorId = assignedMonitorId;
        this.status = status;
    }
}
