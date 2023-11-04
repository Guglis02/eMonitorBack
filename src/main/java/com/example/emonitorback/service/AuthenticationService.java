package com.example.emonitorback.service;

import com.example.emonitorback.config.JwtService;
import com.example.emonitorback.domain.entities.Role;
import com.example.emonitorback.domain.entities.UserStatus;
import com.example.emonitorback.domain.entities.User;
import com.example.emonitorback.domain.repo.UserRepo;
import com.example.emonitorback.dto.AuthenticationDto;
import com.example.emonitorback.dto.UserDto;
import com.example.emonitorback.exception.InvalidDataFormatException;
import com.example.emonitorback.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import java.security.InvalidParameterException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(UserDto request, Role role) {
        if(!Pattern
                .compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")
                .matcher(request.getEmail())
                .find() || !(request.getPassword().length() >= 8)){
            throw new InvalidDataFormatException("Invalid email format or password size");
        }
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .banned(false)
                .build();
        if(user.getRole() == Role.MONITOR){
            user.setStatus(UserStatus.PENDING);
        } else{
            user.setStatus(UserStatus.APPROVED);
        }
        userRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(role)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationDto request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(InvalidParameterException::new);
        var token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .role(user.getRole())
                .build();

    }

}
