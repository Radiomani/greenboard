package com.example.exception;

import org.springframework.http.HttpStatus;

public class ResponseException extends RuntimeException {
    
    private HttpStatus status;

    public ResponseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
