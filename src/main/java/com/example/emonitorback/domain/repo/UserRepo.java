package com.example.emonitorback.domain.repo;

import com.example.emonitorback.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
