package org.example.assignment2.exceptions;

public class StringLengthOutOfBoundsException extends RuntimeException{
    public StringLengthOutOfBoundsException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
    public StringLengthOutOfBoundsException(String errorMessage) {
        super(errorMessage);
    }
}
