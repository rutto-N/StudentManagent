package com.shecodes.exceptions;

public class GenderException extends Exception{
    public GenderException(String message) {
        super(message + " An error occurred with gender.Kindly enter Male or Female");
    }
}
