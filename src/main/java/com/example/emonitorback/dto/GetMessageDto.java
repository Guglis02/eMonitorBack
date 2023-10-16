package com.example.emonitorback.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetMessageDto {
    private Date createdAt;
    private String content;
    private Long senderId;
    private List<String> attachments;
}
