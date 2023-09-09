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
    private Integer schoolYear;

    @Column
    private String schoolOrigin;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    public Student(Integer schoolYear, String schoolOrigin, User user) {
        this.schoolYear = schoolYear;
        this.schoolOrigin = schoolOrigin;
        this.user = user;
    }
}
