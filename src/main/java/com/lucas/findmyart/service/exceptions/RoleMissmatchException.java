package com.lucas.findmyart.service.exceptions;

public class RoleMissmatchException extends RuntimeException {

    public RoleMissmatchException(String role) {
        super("The " + role + " doesn't exist!");
    }
    
}
