package com.example.emonitorback.domain.repo;

import com.example.emonitorback.domain.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

}
