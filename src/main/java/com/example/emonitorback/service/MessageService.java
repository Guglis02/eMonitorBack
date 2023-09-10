package com.example.emonitorback.service;

import com.example.emonitorback.domain.entities.Message;
import com.example.emonitorback.domain.repo.MessageRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepo messageRepo;

    public MessageService(MessageRepo messageRepo){
        this.messageRepo = messageRepo;
    }

    public Message save(Message message){
        return messageRepo.save(message);
    }

    public List<Message> findByTicketId(Long ticketId){
        return messageRepo.findByTicketId(ticketId);
    }
}
