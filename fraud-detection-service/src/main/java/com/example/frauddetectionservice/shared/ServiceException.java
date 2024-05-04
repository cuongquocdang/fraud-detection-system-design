package com.example.frauddetectionservice.shared;

public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
