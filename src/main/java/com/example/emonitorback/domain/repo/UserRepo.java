package com.example.emonitorback.domain.repo;

import com.example.emonitorback.domain.entities.UserStatus;
import com.example.emonitorback.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("FROM User u WHERE u.status = :pending ")
    Optional<List<User>> findAllPendingUsers(@Param("pending") UserStatus pending);
}
