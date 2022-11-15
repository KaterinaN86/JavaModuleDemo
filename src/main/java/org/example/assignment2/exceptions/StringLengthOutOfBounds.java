package org.example.assignment2.exceptions;

public class StringLengthOutOfBounds extends RuntimeException{
    public StringLengthOutOfBounds(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
    public StringLengthOutOfBounds(String errorMessage) {
        super(errorMessage);
    }
}
