package com.example.emonitorback.dto;

import com.example.emonitorback.domain.entities.Ticket;
import com.example.emonitorback.domain.entities.TopicEnum;
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
    private TopicEnum topicId;

    public Ticket getTicket(Long studentCreatorId) {
        return new Ticket(subject, topicId, studentCreatorId);
    }

    public String getContent() {
        return content;
    }
}
