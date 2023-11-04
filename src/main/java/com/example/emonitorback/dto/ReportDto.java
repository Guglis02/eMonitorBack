package com.example.emonitorback.dto;

import com.example.emonitorback.domain.entities.Report;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {
    private Long ticketId;
    private String context;

    public Report getReport(Long authorId, Long reportedUserId) {
        return new Report(authorId, reportedUserId, ticketId, context);
    }
}