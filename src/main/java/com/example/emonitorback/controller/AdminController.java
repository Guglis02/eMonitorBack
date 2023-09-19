package com.example.emonitorback.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/get-monitor-solicitations")
    public void getMonitorSolicitations(){

    }
    @PostMapping("/approve-monitor")
    public void approveMonitor(){

    }
}
