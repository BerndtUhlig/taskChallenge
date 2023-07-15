package com.example.craftworkschallenge.exceptions;

/**
 * NotFoundException to be thrown should a given ID for a requested Task not exist.
 */
public class NotFoundException  extends RuntimeException{

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Exception e) {
        super(e);
    }
}
