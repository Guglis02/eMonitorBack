package com.example.emonitorback.dto;

import com.example.emonitorback.domain.entities.Message;
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

    public Report getReport()
    {
        return new Report(ticketId, context);
    }
}