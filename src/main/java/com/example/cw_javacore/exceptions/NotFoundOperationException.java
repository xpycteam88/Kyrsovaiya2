package com.example.cw_javacore.exceptions;

public class NotFoundOperationException extends RuntimeException {

    public NotFoundOperationException() {
    }

    public NotFoundOperationException(String message) {
        super(message);
    }

    public NotFoundOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
