package org.example.assignment2.exceptions;

public class EmptyFileException extends Exception{
    public EmptyFileException(String errorMessage){
        super(errorMessage);
    }
}
