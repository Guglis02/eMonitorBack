package com.example.emonitorback.controller;

import com.example.emonitorback.dto.MessageDto;
import com.example.emonitorback.dto.TicketDto;
import com.example.emonitorback.domain.entities.Message;
import com.example.emonitorback.domain.entities.Ticket;
import com.example.emonitorback.service.MessageService;
import com.example.emonitorback.service.TicketService;
import org.springframework.web.bind.annotation.*;

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
    public List<Ticket> getTickets()
    {
        return ticketService.findTickets();
    }

    @PostMapping("/insert-ticket")
    public void insertTicket(@RequestBody TicketDto ticketDto){
        Ticket ticket = ticketDto.getTicket();
        Long ticketId = ticketService.save(ticket).getId();
        Message message = ticketDto.getMessage(ticketId);
        messageService.save(message);
    }

    @PostMapping("/claim-ticket")
    public void claimTicket(@RequestBody Long ticketId){
        ticketService.claimTicket(ticketId);
    }

    @GetMapping("/get-messages")
    public List<Message> getMessages(@RequestBody Long ticketId){
        return messageService.findByTicketId(ticketId);
    }

    @PostMapping("/insert-message")
    public void insertMessage(@RequestBody MessageDto messageDto){
        Message message = messageDto.getMessage();
        messageService.save(message);
    }
}
