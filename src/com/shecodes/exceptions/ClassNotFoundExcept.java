package com.shecodes.exceptions;

public class ClassNotFoundExcept extends Exception{
    public ClassNotFoundExcept(String message) {
        System.out.println(message+" Kindly make sure you have have added the JDBC driver in your project structure");
    }
}
