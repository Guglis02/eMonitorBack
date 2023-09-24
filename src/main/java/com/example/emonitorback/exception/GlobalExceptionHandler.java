package com.example.emonitorback.exception;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.emonitorback.response.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<ErrorResponse> handleMyCustomException(PSQLException ex) {
        return new ResponseEntity<>(new ErrorResponse("Data integrity violation"), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}