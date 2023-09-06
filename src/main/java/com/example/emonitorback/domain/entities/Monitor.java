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
public class Monitor extends User{
    @Column
    private Integer university_origin;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToMany
    @JoinTable(
        name = "monitor_topics",
        joinColumns = @JoinColumn(name = "monitor_id"),
        inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    private List<Topic> topics;

    public Monitor(Integer university_origin, User user) {
        this.university_origin = university_origin;
        this.user = user;
    }
}
