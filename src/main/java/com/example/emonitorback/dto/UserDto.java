package com.example.emonitorback.dto;

import com.example.emonitorback.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private String password;

    public User getUser(){
        return new User(name, email, password);
    }
}
