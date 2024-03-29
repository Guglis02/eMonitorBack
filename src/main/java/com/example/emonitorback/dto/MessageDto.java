package com.example.emonitorback.dto;

import com.example.emonitorback.domain.entities.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String content;
    private List<String> attachments;
    private Long ticketId;

    public Message getMessage(Long creatorId) {
        return new Message(content, ticketId, creatorId);
    }
}
