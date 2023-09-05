package com.example.emonitorback;

import org.springframework.data.jpa.repository.JpaRepository;

import java.security.InvalidParameterException;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

}
