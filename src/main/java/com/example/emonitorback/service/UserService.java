package com.example.emonitorback.service;

import com.example.emonitorback.domain.entities.User;
import com.example.emonitorback.domain.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    public User save(User user) {
        return userRepo.save(user);
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }


}
