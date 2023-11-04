package com.example.emonitorback.service;

import com.example.emonitorback.domain.entities.UserStatus;
import com.example.emonitorback.domain.entities.User;
import com.example.emonitorback.domain.repo.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public List<User> findMonitorRequests(){
        return userRepo.findAllPendingUsers(UserStatus.PENDING).orElse(null);
    }

    public void approveUser(Long userId){
        User user = userRepo.findById(userId).orElseThrow(InvalidParameterException::new);
        user.setStatus(UserStatus.APPROVED);
        userRepo.save(user);
    }
    public void rejectUser(Long userId){
        User user = userRepo.findById(userId).orElseThrow(InvalidParameterException::new);
        user.setStatus(UserStatus.REJECTED);
        userRepo.save(user);
    }

    public User getCurrentUser() {
        return userRepo.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(InvalidParameterException::new);
    }
}
