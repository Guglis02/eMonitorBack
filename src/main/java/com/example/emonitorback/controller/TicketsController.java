package com.example.emonitorback.controller;

import com.example.emonitorback.domain.dto.TicketDto;
import com.example.emonitorback.domain.entities.Ticket;
import com.example.emonitorback.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketsController {
    private final TicketService ticketService;

    public TicketsController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @GetMapping("/get-tickets")
    public List<Ticket> getTickets(){
        return ticketService.findAll();
    }

    @PostMapping("/insert-ticket")
    public void insertTicket(@RequestBody TicketDto ticketDto){
        Ticket ticket = ticketDto.getTicket();
        ticketService.save(ticket);
    }
}
