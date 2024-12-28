package com.examen.baseexamen.v1.application.shared.cqrscore.exceptions;

public class PaginationInvalidException extends RuntimeException {
    public PaginationInvalidException() {
        super("Requested pagination is invalid");
    }
}
