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
    private Integer universityOrigin;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToMany
    @JoinTable(
        name = "monitorTopics",
        joinColumns = @JoinColumn(name = "monitorId"),
        inverseJoinColumns = @JoinColumn(name = "topicId")
    )
    private List<Topic> topics;

    public Monitor(Integer universityOrigin, User user) {
        this.universityOrigin = universityOrigin;
        this.user = user;
    }
}
