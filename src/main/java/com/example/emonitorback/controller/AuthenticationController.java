package com.example.emonitorback.controller;

import com.example.emonitorback.domain.entities.Role;
import com.example.emonitorback.dto.AuthenticationDto;
import com.example.emonitorback.dto.UserDto;
import com.example.emonitorback.response.AuthenticationResponse;
import com.example.emonitorback.service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication Controller", description = "Endpoints para autenticação. " +
        "O token retornado deve ser utilizado no header Authorization junto com o prefixo 'Bearer '.")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register-student")
    public ResponseEntity<AuthenticationResponse> registerStudent(@RequestBody UserDto request) {
        return ResponseEntity.ok(service.register(request, Role.STUDENT));
    }

    @PostMapping("/register-monitor")
    public ResponseEntity<AuthenticationResponse> registerMonitor(@RequestBody UserDto request) {
        return ResponseEntity.ok(service.register(request, Role.MONITOR));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationDto request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
