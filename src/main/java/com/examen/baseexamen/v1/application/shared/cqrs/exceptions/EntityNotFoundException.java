package com.examen.baseexamen.v1.application.shared.cqrs.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
