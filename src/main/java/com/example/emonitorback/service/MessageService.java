package com.example.emonitorback.service;

import com.example.emonitorback.domain.entities.Attachment;
import com.example.emonitorback.domain.entities.Message;
import com.example.emonitorback.domain.repo.AttachmentRepo;
import com.example.emonitorback.domain.repo.MessageRepo;
import com.example.emonitorback.dto.GetMessageDto;
import com.example.emonitorback.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepo messageRepo;
    private final AttachmentRepo attachmentRepo;
    private final UserService userService;

    public Message save(Message message) {
        return messageRepo.save(message);
    }

    public Long insertMessage(MessageDto messageDto) {
        Long creatorId = userService.getCurrentUser().getId();
        Long messageId = messageRepo.save(messageDto.getMessage(creatorId)).getId();

        for (String attachment : messageDto.getAttachments())
        {
            Attachment att = new Attachment(attachment, messageId);
            attachmentRepo.save(att);
        }

        return messageId;
    }

    private List<String> getAttachments(Long messageId)
    {
        return attachmentRepo.findByMessageId(messageId).stream().map(Attachment::getAttachment).toList();
    }

    public List<GetMessageDto> getTicketMessages(Long ticketId)
    {
        List<GetMessageDto> dtos = new java.util.ArrayList<>();

        for( Message message : messageRepo.findByTicketId(ticketId))
        {
            GetMessageDto dto = new GetMessageDto(
                    message.getCreatedAt(),
                    message.getContent(),
                    message.getSenderId(),
                    getAttachments(message.getId())
            );
            dtos.add(dto);
        }

        return dtos;
    }
}
