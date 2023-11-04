package com.example.emonitorback;

import com.example.emonitorback.domain.entities.Role;
import com.example.emonitorback.domain.entities.User;
import com.example.emonitorback.domain.entities.UserStatus;
import com.example.emonitorback.domain.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EMonitorBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(EMonitorBackApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            User admin = User.builder()
                    .name("admin")
                    .email("admin@admin.com")
                    .password(passwordEncoder.encode("gustavo-batata-123"))
                    .role(Role.ADMIN)
                    .status(UserStatus.APPROVED)
                    .banned(false)
                    .build();
            User user = userRepo.findByEmail(admin.getEmail()).orElse(null);
            if(user == null){
                userRepo.save(admin);
            }
        };
    }
}
