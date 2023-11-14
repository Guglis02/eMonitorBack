package com.example.emonitorback.exception;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.emonitorback.response.ErrorResponse;

import java.rmi.AlreadyBoundException;
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
    @ExceptionHandler(AlreadyBoundException.class)
    public ResponseEntity<ErrorResponse> alreadyBoundException(AlreadyBoundException ex){
        return new ResponseEntity<>(new ErrorResponse("The ticket was already claimed!"), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(InvalidDataFormatException.class)
    public ResponseEntity<ErrorResponse> invalidDataFormatException(InvalidDataFormatException ex){
        return new ResponseEntity<>(new ErrorResponse("Invalid email format or password size"), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(BannedUserException.class)
    public ResponseEntity<ErrorResponse> bannedUserException(BannedUserException ex){
        return new ResponseEntity<>(new ErrorResponse("The user is banned from the plataform!"), HttpStatus.LOCKED);
    }

    @ExceptionHandler(NotApprovedUserException.class)
    public ResponseEntity<ErrorResponse> notApprovedUserException(NotApprovedUserException ex){
        return new ResponseEntity<>(new ErrorResponse("The user is not approved yet!"), HttpStatus.UPGRADE_REQUIRED);
    }

    @ExceptionHandler(RejectedUserException.class)
    public ResponseEntity<ErrorResponse> rejectedUserException(RejectedUserException ex){
        return new ResponseEntity<>(new ErrorResponse("The user was rejected!"), HttpStatus.NOT_ACCEPTABLE);
    }

}