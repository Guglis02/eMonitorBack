package com.example.emonitorback.service;

import com.example.emonitorback.domain.entities.Report;
import com.example.emonitorback.domain.entities.Ticket;
import com.example.emonitorback.domain.entities.User;
import com.example.emonitorback.domain.repo.ReportRepo;
import com.example.emonitorback.domain.repo.TicketRepo;
import com.example.emonitorback.domain.repo.UserRepo;
import com.example.emonitorback.dto.ReportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor()
public class ReportService {
    private final TicketRepo ticketRepo;
    private final ReportRepo reportRepo;
    private final UserRepo userRepo;
    private final UserService userService;

    private Long getReportedUserIdFromTicket(Ticket ticket, Long userId) {
        if (Objects.equals(ticket.getStudentCreatorId(), userId)) {
            return ticket.getAssignedMonitorId();
        } else {
            return ticket.getStudentCreatorId();
        }
    }

    public Long reportTicket(ReportDto reportDto) {
        Long userId = userService.getCurrentUser().getId();
        Ticket ticket = ticketRepo.findById(reportDto.getTicketId()).orElseThrow();

        Long reportedId = getReportedUserIdFromTicket(ticket, userId);
        Report report = reportDto.getReport(userId, reportedId);

        var id = ticketRepo.save(ticket).getId();
        reportRepo.save(report);
        return id;
    }

    public List<Report> getReports() {
        return reportRepo.findAll();
    }

    public void banUser(Long reportId) {
        Report report = reportRepo.findById(reportId).orElseThrow();
        User user = userRepo.findById(report.getReportedUserId()).orElseThrow();
        user.setBanned(true);
        reportRepo.delete(report);
    }

    public void rejectReport(Long reportId) {
        Report report = reportRepo.findById(reportId).orElseThrow();
        reportRepo.delete(report);
    }
}
