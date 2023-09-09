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

    @Column(columnDefinition="TEXT")
    private String content;

    @Column
    private Long topicId;

    @Column
    private Long studentCreatorId;

    @Column
    private Long assignedMonitorId;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany
    @JoinTable(
        name = "ticketUsers",
        joinColumns = @JoinColumn(name = "ticketId"),
        inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private List<User> users;

    public  Ticket(String subject, String content, Long topicId, Long studentCreatorId, Long assignedMonitorId) {
        this.subject = subject;
        this.content = content;
        this.topicId = topicId;
        this.studentCreatorId = studentCreatorId;
        this.assignedMonitorId = assignedMonitorId;
        this.status = Status.OPEN;
    }
}
