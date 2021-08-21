package com.shecodes.exceptions;

public class FileNotFoundException extends Exception{
    public FileNotFoundException(String message) {
        super(message + "The file specified could not be found!!!");
    }
}
