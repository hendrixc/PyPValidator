/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator.exeption;

/**
 * Exception class used to represent an error in data validation process.
 * @author Henry Coral
 */
public class ValidationException extends Exception{

    /**
     * Default constructor
     */
    public ValidationException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message. 
     * @param message the detail message. 
     */
    public ValidationException(String message) {
        super(message);
    }
    
    
}
