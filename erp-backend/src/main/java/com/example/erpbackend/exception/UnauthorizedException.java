package com.example.erpbackend.exception;

public class UnauthorizedException  extends RuntimeException{
    public UnauthorizedException(String message) {
        super(message);
    }
}
