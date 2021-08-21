package com.shecodes.exceptions;

public class DateException extends Exception{
    public DateException(String message) {
        super(message + "An error occurred with your date ");
    }
}
