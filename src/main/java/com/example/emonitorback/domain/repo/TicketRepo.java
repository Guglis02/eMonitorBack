package com.example.emonitorback.domain.repo;

import com.example.emonitorback.domain.entities.Status;
import com.example.emonitorback.domain.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
    @Query("FROM Ticket t WHERE t.studentCreatorId = :studentCreatorId")
    List<Ticket> findByStudentCreatorId(@Param("studentCreatorId") Long studentCreatorId);

    @Query("FROM Ticket t WHERE t.assignedMonitorId = :assignedMonitorId or t.status = :open")
    List<Ticket> findByAssignedMonitorIdOrOpen(@Param("assignedMonitorId") Long assignedMonitorId, @Param("open") Status open);
}
