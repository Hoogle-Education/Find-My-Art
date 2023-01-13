package com.lucas.findmyart.service.exceptions;

public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException() {
    }

    public EventNotFoundException(String message) {
        super(message);
    }

}
