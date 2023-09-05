package com.example.emonitorback;

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
