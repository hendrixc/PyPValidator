/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator.utils;

import com.hendrixc.pypvalidator.exeption.ValidationException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Utility class used to validate plate, date and time.
 * @author Henry Coral
 */
public class DataValidator {
    
    /**
     * Method that validates a plate according to the Ecuatorian regulations.
     * Three letters plus 3 or 4 numbers.
     * @param plate value to be validated.
     * @throws ValidationException An exception is thrown in case of the plate is invalid.
     */
    public void validatePlate(String plate) throws ValidationException {
        if (!(plate!=null && plate.matches("^([A-z]{3}\\d{3,4})$"))) {
            throw new ValidationException("Format for plate: "+plate+", is invalid.");
        }
    }
    
    /**
     * Method that validates a date according to the format: YYYY-MM-dd.
     * @param date value to be validated.
     * @throws ValidationException An exception is thrown in case of the date is invalid.
     */
    public  void validateDate(String date) throws ValidationException {
        try {
            LocalDate.parse(date);
        } catch (Exception pe) {
            throw new ValidationException("Format for date: "+date+", is invalid.");
        }
    }
    
    /**
     * Method that validates a time according to the format: HH:mm.
     * @param time value to be validated.
     * @throws ValidationException An exception is thrown in case of the date is invalid.
     */
    public void validateTime(String time) throws ValidationException {
        try {
            LocalTime.parse(time);
        } catch (Exception ex) {
            throw new ValidationException("Format for time: "+time+", is invalid.");
        } 
    }
}
