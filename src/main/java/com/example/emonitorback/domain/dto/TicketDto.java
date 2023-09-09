package com.example.emonitorback.domain.dto;

import com.example.emonitorback.domain.entities.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private String subject;
    private String content;
    private Long topicId;

    public Ticket getTicket(){
        return new Ticket(subject, content, topicId, (long) (Math.random()*100), (long)(Math.random()*100));
    }
}
