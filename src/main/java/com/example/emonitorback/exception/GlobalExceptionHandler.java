package com.example.emonitorback.exception;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.emonitorback.response.ErrorResponse;

import java.security.InvalidParameterException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<ErrorResponse> psqlException(PSQLException ex) {
        return new ResponseEntity<>(new ErrorResponse("Data integrity violation"), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(AuthorizationServiceException.class)
    public ResponseEntity<ErrorResponse> authorizationException(AuthorizationServiceException ex){
        return new ResponseEntity<>(new ErrorResponse("You're not authorized to do this action!"), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<ErrorResponse> invalidParameterException(InvalidParameterException ex){
        return new ResponseEntity<>(new ErrorResponse("The parameters provided does not match known data"), HttpStatus.EXPECTATION_FAILED);
    }

}