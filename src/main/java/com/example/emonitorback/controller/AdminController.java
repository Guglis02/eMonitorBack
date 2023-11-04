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
    public HttpStatus approveMonitor(@RequestParam Long userId){
        userService.approveUser(userId);
        return HttpStatus.OK;
    }

    @PostMapping("/reject-monitor")
    public HttpStatus rejectMonitor(@RequestParam Long userId){
        userService.rejectUser(userId);
        return HttpStatus.OK;
    }

    @GetMapping("/get-reports")
    @Operation(summary = "Retorna todas as denúncias.")
    public List<Report> getReports() {
        return reportService.getReports();
    }

    @PostMapping("/accept-report")
    @Operation(summary = "Aceita uma denúncia, banindo o usuário reportado.")
    public void acceptReport(@RequestParam Long reportId){
        reportService.banUser(reportId);
    }

    @PostMapping("/reject-report")
    @Operation(summary = "Rejeite uma denúncia.")
    public void rejectReport(@RequestParam Long reportId){
        reportService.rejectReport(reportId);
    }
}
