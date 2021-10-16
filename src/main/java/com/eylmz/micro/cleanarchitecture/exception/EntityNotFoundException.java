package com.eylmz.micro.cleanarchitecture.exception;

import lombok.Data;

@Data
public class EntityNotFoundException extends RuntimeException {

    private String message;

    public EntityNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}