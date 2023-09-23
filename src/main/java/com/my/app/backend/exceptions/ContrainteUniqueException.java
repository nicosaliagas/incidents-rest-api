package com.my.app.backend.exceptions;

public class ContrainteUniqueException extends RuntimeException {
    public ContrainteUniqueException(String message) {
        super(message);
    }
}
