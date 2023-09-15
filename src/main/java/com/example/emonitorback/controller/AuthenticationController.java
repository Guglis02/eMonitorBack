package com.example.emonitorback.controller;

import com.example.emonitorback.domain.entities.Role;
import com.example.emonitorback.dto.AuthenticationDto;
import com.example.emonitorback.dto.UserDto;
import com.example.emonitorback.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    @PostMapping("/register-student")
    public ResponseEntity<AuthenticationResponse> registerStudent(@RequestBody UserDto request){
        return ResponseEntity.ok(service.register(request, Role.STUDENT));
    }

    @PostMapping("/register-monitor")
    public ResponseEntity<AuthenticationResponse> registerMonitor(@RequestBody UserDto request){
        return ResponseEntity.ok(service.register(request, Role.MONITOR));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationDto request){
        System.out.println("batata");
        return ResponseEntity.ok(service.authenticate(request));
    }
}
