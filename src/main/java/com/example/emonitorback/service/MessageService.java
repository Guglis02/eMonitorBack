package com.example.emonitorback.service;

import com.example.emonitorback.domain.entities.Message;
import com.example.emonitorback.domain.repo.MessageRepo;
import com.example.emonitorback.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepo messageRepo;
    private final UserService userService;

    public Message save(Message message) {
        return messageRepo.save(message);
    }

    public Long insertMessage(MessageDto messageDto) {
        Long creatorId = userService.getCurrentUser().getId();
        Message message = messageDto.getMessage(creatorId);
        return messageRepo.save(message).getId();
    }

    public List<Message> findByTicketId(Long ticketId) {
        return messageRepo.findByTicketId(ticketId);
    }
}
