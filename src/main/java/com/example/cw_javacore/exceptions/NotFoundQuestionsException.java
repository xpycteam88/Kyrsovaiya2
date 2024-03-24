package com.example.cw_javacore.exceptions;

public class NotFoundQuestionsException extends RuntimeException{
    public NotFoundQuestionsException() {
    }

    public NotFoundQuestionsException(String message) {
        super(message);
    }

    public NotFoundQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }
}
