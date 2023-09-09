package com.example.emonitorback.domain.repo;

import com.example.emonitorback.domain.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    @Query("FROM Message m WHERE m.ticketId = :ticketId")
    List<Message> findByTicketId(@Param("ticketId") Long ticketId);
}
