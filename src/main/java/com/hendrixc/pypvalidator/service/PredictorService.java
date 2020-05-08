/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator.service;

import com.hendrixc.pypvalidator.db.RestrictionDB;
import com.hendrixc.pypvalidator.exeption.ValidationException;
import com.hendrixc.pypvalidator.model.Restriction;
import com.hendrixc.pypvalidator.model.Schedule;
import com.hendrixc.pypvalidator.model.Vehicle;
import com.hendrixc.pypvalidator.utils.DataValidator;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Service used to predict if a vehicle has a restriction in a determinated date and time.
 * @author Henry Coral
 */
public class PredictorService {
    
    /**
     * Invoques the DB with the defined restrictions. 
     */
    private final RestrictionDB db = RestrictionDB.getInstance();
    
    /**
     * 
     * @param vehicle Object with the plate to be validated.
     * @param dateTime Object with a date and time to be validated.
     * @return true if the vehicle has a restriction in the date and time specified; otherwise returns false. 
     * @throws ValidationException Exception thrown if one of the params passed is not valid.
     */
    public boolean predict(Vehicle vehicle, LocalDateTime dateTime) throws ValidationException {
        Restriction restriction = db.getRestrictionByDay(dateTime.getDayOfWeek().getValue());
        if (restriction!=null && restriction.getDigits().contains(this.getLastDigitPlate(vehicle))) {
            for (Schedule schedule : restriction.getSchedules()) {
                LocalTime time =dateTime.toLocalTime();
                if (time.isAfter(schedule.getStart()) && time.isBefore(schedule.getEnd())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Internal method used to obtain the last digit of a vehicle's plate.
     * @param vehicle Vehicle with the plate to be validated.
     * @return The last digit of the vehicle's plate.
     * @throws ValidationException Exception thrown if the plate is invalid.
     */
    private Integer getLastDigitPlate(Vehicle vehicle) throws ValidationException {
        if (vehicle!=null && vehicle.getPlate()!=null) {
            DataValidator validator = new DataValidator();
            validator.validatePlate(vehicle.getPlate());
            return Integer.parseInt(vehicle.getPlate().substring(vehicle.getPlate().length()-1));
        } else {
            throw new ValidationException("Vehicle or plate is null");
        }
    }
}
