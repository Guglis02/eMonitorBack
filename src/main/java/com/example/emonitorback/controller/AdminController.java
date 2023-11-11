package com.example.emonitorback.controller;


import com.example.emonitorback.domain.entities.User;
import com.example.emonitorback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.emonitorback.domain.entities.Report;
import com.example.emonitorback.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final ReportService reportService;

    private final UserService userService;

    @GetMapping("/get-monitor-solicitations")
    public ResponseEntity<List<User>> getMonitorSolicitations(){
        return new ResponseEntity<>(userService.findMonitorRequests(), HttpStatus.OK);
    }
    @PostMapping("/approve-monitor")
    public ResponseEntity<Long> approveMonitor(@RequestParam Long userId){
        userService.approveUser(userId);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @PostMapping("/reject-monitor")
    public ResponseEntity<Long> rejectMonitor(@RequestParam Long userId){
        userService.rejectUser(userId);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @GetMapping("/get-reports")
    @Operation(summary = "Retorna todas as denúncias.")
    public ResponseEntity<List<Report>> getReports() {
        return new ResponseEntity<>(reportService.getReports(), HttpStatus.OK);
    }

    @PostMapping("/accept-report")
    @Operation(summary = "Aceita uma denúncia, banindo o usuário reportado.")
    public ResponseEntity<Long> acceptReport(@RequestParam Long reportId){
        var user = reportService.banUser(reportId);
        return new ResponseEntity<>(user.getId(), HttpStatus.OK);
    }

    @PostMapping("/reject-report")
    @Operation(summary = "Rejeite uma denúncia.")
    public HttpStatus rejectReport(@RequestParam Long reportId){
        reportService.rejectReport(reportId);
        return HttpStatus.OK;
    }
}
