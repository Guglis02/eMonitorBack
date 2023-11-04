package com.example.emonitorback.controller;


import com.example.emonitorback.domain.entities.User;
import com.example.emonitorback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping("/get-monitor-solicitations")
    public ResponseEntity<List<User>> getMonitorSolicitations(){
        return new ResponseEntity<>(userService.findMonitorRequests(), HttpStatus.OK);
    }
    @PostMapping("/approve-monitor")
    public HttpStatus approveMonitor(@RequestParam Long userId){
        userService.approveUser(userId);
        return HttpStatus.OK;
    }

    @PostMapping("/reject-monitor")
    public HttpStatus rejectMonitor(@RequestParam Long userId){
        userService.rejectUser(userId);
        return HttpStatus.OK;
    }
}
