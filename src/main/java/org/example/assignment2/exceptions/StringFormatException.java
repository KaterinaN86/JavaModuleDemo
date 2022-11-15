package org.example.assignment2.exceptions;

public class StringFormatException extends RuntimeException{
    public StringFormatException(String message) {
        super(message);
    }
    public StringFormatException(Throwable cause) {
        super(cause);
    }
}
