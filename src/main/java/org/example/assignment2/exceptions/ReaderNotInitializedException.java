package org.example.assignment2.exceptions;

public class ReaderNotInitializedException extends RuntimeException {
    public ReaderNotInitializedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
    public ReaderNotInitializedException(String errorMessage) {
        super(errorMessage);
    }
}
