package com.example.emonitorback.exception;

public class BannedUserException extends RuntimeException{
    public BannedUserException(String message){
        super(message);
    }
}
