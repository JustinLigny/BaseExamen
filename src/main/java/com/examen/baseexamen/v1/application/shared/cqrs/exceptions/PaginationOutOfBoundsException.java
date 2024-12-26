package com.examen.baseexamen.v1.application.shared.cqrs.exceptions;

public class PaginationOutOfBoundsException extends RuntimeException {
    public PaginationOutOfBoundsException() {
        super("Requested page is out of bounds. No data found for the given page number");
    }
}
