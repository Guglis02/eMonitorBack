package com.example.emonitorback.dto;

import com.example.emonitorback.domain.entities.Message;
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

    public Ticket getTicket()
    {
        return new Ticket(subject, topicId, (long) (Math.random()*100), (long)(Math.random()*100));
    }

    public Message getMessage(Long ticketId)
    {
        return new Message(content, ticketId, (long)(Math.random()*100));
    }
}
