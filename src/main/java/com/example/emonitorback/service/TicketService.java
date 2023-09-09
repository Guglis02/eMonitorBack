package com.example.emonitorback.service;

import com.example.emonitorback.domain.entities.Ticket;
import com.example.emonitorback.domain.repo.TicketRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepo ticketRepo;

    public TicketService(TicketRepo ticketRepo){
        this.ticketRepo = ticketRepo;
    }

    public Ticket save(Ticket ticket){
        return ticketRepo.save(ticket);
    }

    public List<Ticket> findAll(){
        return ticketRepo.findAll();
    }
}
