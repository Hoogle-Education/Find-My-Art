package com.lucas.findmyart.service.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyRegisteredException extends RuntimeException {

    private final HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;

    public UserAlreadyRegisteredException(String message) {
        super(message);
    }
}
