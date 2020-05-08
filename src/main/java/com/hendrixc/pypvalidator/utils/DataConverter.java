/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Utility class used to convert a date and time Strings in LocalDateTime object.
 * @author Henry Coral
 */
public class DataConverter {
    
    /**
     * Method that converts a date and time Strings into a LocalDateTime object.
     * This method could be throw an exception if one of the strings have not a valid date or time values.
     * @param date String with a valid date (yyyy-mm-dd).
     * @param time String with a valid time (HH:MM).
     * @return The LocalDateTime object converted.  
     */
    public LocalDateTime convert(String date, String time) {
        LocalDate dateTmp = LocalDate.parse(date);
        LocalTime timeTmp = LocalTime.parse(time);
        return LocalDateTime.of(dateTmp, timeTmp).plusSeconds(30);
    }
    
}
