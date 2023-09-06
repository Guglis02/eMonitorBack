package com.example.emonitorback.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends User {
    @Column
    private Integer school_year;

    @Column
    private String school_origin;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    public Student(Integer school_year, String school_origin, User user) {
        this.school_year = school_year;
        this.school_origin = school_origin;
        this.user = user;
    }
}
