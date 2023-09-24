package com.example.emonitorback.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private String message;
}
