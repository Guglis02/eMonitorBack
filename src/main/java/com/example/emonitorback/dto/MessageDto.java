package com.example.emonitorback.dto;

import com.example.emonitorback.domain.entities.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String content;
    private Long ticketId;

    public Message getMessage()
    {
        return new Message(content, ticketId, (long)(Math.random()*100));
    }
}
