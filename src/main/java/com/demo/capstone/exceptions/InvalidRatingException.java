package com.demo.capstone.exceptions;

public class InvalidRatingException extends RuntimeException {
    private String message;

    public InvalidRatingException() {
    }

    public InvalidRatingException(String msg) {
        super(msg);
        this.message = msg;
    }
}
