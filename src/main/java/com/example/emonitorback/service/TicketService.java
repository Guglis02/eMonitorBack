package com.example.emonitorback.service;

import com.example.emonitorback.domain.entities.Role;
import com.example.emonitorback.domain.entities.Status;
import com.example.emonitorback.domain.entities.Ticket;
import com.example.emonitorback.domain.entities.User;
import com.example.emonitorback.domain.repo.TicketRepo;
import com.example.emonitorback.domain.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor()
public class TicketService {
    private final TicketRepo ticketRepo;
    private final UserService userService;

    public Ticket save(Ticket ticket){
        return ticketRepo.save(ticket);
    }

    public void claimTicket(Long ticketId)
    {
        User user = userService.getCurrentUser();
        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow();
        ticket.setAssignedMonitorId(user.getId());
        ticket.setStatus(Status.IN_PROGRESS);
        ticketRepo.save(ticket);
    }

    public List<Ticket> findTickets()
    {
        User user = userService.getCurrentUser();
        if (user.getRole() == Role.MONITOR) {
            return ticketRepo.findByAssignedMonitorIdOrOpen(user.getId(), Status.OPEN);
        } else {
            return ticketRepo.findByStudentCreatorId(user.getId());
        }
    }
}
