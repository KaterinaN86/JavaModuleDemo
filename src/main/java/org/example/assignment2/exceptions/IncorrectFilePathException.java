package org.example.assignment2.exceptions;

public class IncorrectFilePathException extends Exception{
    public IncorrectFilePathException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }
}
