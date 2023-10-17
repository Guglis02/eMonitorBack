package com.example.emonitorback.exception;

public class InvalidDataFormatException extends RuntimeException{
    public InvalidDataFormatException(String message){
        super(message);
    }
}
