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
@Table(name = "topic")
public class Topic {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(
        name = "monitor_topics",
        joinColumns = @JoinColumn(name = "monitor_id"),
        inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    private List<User> users;

    public Topic(String name) {
        this.name = name;
    }
}
