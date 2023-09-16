package com.example.emonitorback.controller;

import com.example.emonitorback.domain.entities.Message;
import com.example.emonitorback.domain.entities.Report;
import com.example.emonitorback.domain.entities.Ticket;
import com.example.emonitorback.dto.MessageDto;
import com.example.emonitorback.dto.ReportDto;
import com.example.emonitorback.dto.TicketDto;
import com.example.emonitorback.service.MessageService;
import com.example.emonitorback.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketsController {
    private final TicketService ticketService;
    private final MessageService messageService;

    public TicketsController(TicketService ticketService, MessageService messageService) {
        this.ticketService = ticketService;
        this.messageService = messageService;
    }

    @GetMapping("/get-tickets")
    public List<Ticket> getTickets() {
        return ticketService.findTickets();
    }

    @PostMapping("/insert-ticket")
    public void insertTicket(@RequestBody TicketDto ticketDto) {
        ticketService.insertTicket(ticketDto);
    }

    @PostMapping("/claim-ticket")
    public void claimTicket(@RequestBody Long ticketId) {
        ticketService.claimTicket(ticketId);
    }

    @PostMapping("/close-ticket")
    public void closeTicket(@RequestBody Long ticketId) {
        ticketService.closeTicket(ticketId);
    }

    @PostMapping("/pass-ticket")
    public void passTicket(@RequestBody Long ticketId) {
        ticketService.passTicket(ticketId);
    }

    @PostMapping("/report-ticket")
    public void reportTicket(@RequestBody ReportDto reportDto) {
        ticketService.reportTicket(reportDto);
    }

    @GetMapping("/get-reports")
    public List<Report> getReports() {
        return ticketService.getReports();
    }

    @GetMapping("/get-messages")
    public List<Message> getMessages(@RequestBody Long ticketId) {
        return messageService.findByTicketId(ticketId);
    }

    @PostMapping("/insert-message")
    public void insertMessage(@RequestBody MessageDto messageDto) {
        messageService.insertMessage(messageDto);
    }
}
