package com.example.emonitorback.service;

import com.example.emonitorback.domain.entities.*;
import com.example.emonitorback.domain.repo.ReportRepo;
import com.example.emonitorback.domain.repo.TicketRepo;
import com.example.emonitorback.dto.ReportDto;
import com.example.emonitorback.dto.TicketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor()
public class TicketService {
    private final TicketRepo ticketRepo;
    private final ReportRepo reportRepo;
    private final UserService userService;
    private final MessageService messageService;

    public Long insertTicket(TicketDto ticketDto) {
        Long creatorId = userService.getCurrentUser().getId();
        Ticket ticket = ticketDto.getTicket(creatorId);
        Long ticketId = ticketRepo.save(ticket).getId();
        Message message = new Message(ticketDto.getContent(), ticketId, creatorId);
        messageService.save(message);
        return ticketId;
    }

    public Long claimTicket(Long ticketId) {
        User user = userService.getCurrentUser();
        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow();
        ticket.setAssignedMonitorId(user.getId());
        ticket.setStatus(Status.IN_PROGRESS);
        return ticketRepo.save(ticket).getId();
    }

    public Long closeTicket(Long ticketId) {
        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow();
        ticket.setStatus(Status.CLOSED);
        return ticketRepo.save(ticket).getId();
    }

    public Long passTicket(Long ticketId) {
        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow();
        ticket.setAssignedMonitorId(null);
        ticket.setStatus(Status.OPEN);
        return ticketRepo.save(ticket).getId();
    }

    public Long reportTicket(ReportDto reportDto) {
        Report report = reportDto.getReport();
        Ticket ticket = ticketRepo.findById(report.getTicketId()).orElseThrow();
        ticket.setStatus(Status.CLOSED);
        var id = ticketRepo.save(ticket).getId();
        reportRepo.save(report);
        return id;
    }

    public List<Report> getReports() {
        return reportRepo.findAll();
    }

    public List<Ticket> findTickets() {
        User user = userService.getCurrentUser();
        if (user.getRole() == Role.MONITOR) {
            return ticketRepo.findByAssignedMonitorIdOrOpen(user.getId(), Status.OPEN);
        } else {
            return ticketRepo.findByStudentCreatorId(user.getId());
        }
    }
}
