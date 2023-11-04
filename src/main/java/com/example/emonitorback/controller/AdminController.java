package com.example.emonitorback.controller;


import com.example.emonitorback.domain.entities.Report;
import com.example.emonitorback.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final ReportService reportService;

    @GetMapping("/get-monitor-solicitations")
    public void getMonitorSolicitations(){

    }
    @PostMapping("/approve-monitor")
    public void approveMonitor(){

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
