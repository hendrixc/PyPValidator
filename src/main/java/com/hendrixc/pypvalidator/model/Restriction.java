/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Model class that represents a Pico & Placa restriction.
 * One restriction must contains: day of week, digits (last plate's digit assigned for this restriction),
 * schedules (each schedula contains a couple of start and end time) to restriction apply.
 * @author Henry Coral
 */
public class Restriction {
    
    /**
     * Property that represents a day of week.
     */
    private Integer dayOfWeek;
    /**
     * Property that contains digits of the restriction.
     */
    private Set<Integer> digits;
    /**
     * Property that contains schedeules of the restriction.
     */
    private List<Schedule> schedules;

    /**
     * Default empty constrcutor.
     */
    public Restriction() {
        
    }
    
    /**
     * Constructor that admits a value for day of week.
     * @param dayOfWeek 
     */
    public Restriction(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    
    /**
     * Getter for dayOfWeek property.
     * @return The value asigned to day of week.
     */
    public Integer getDayOfWeek() {
        return dayOfWeek;
    }
    
    /**
     * Setter for dayOfWeek property.
     * @param dayOfWeek The value to be assigned.
     */
    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    /**
     * Getter for digits property.
     * @return The value asigned to digits.
     */
    public Set<Integer> getDigits() {
        return digits;
    }
    
    /**
     * Setter for digits property.
     * @param digits The value to be assigned.
     */
    public void setDigits(Set<Integer> digits) {
        this.digits = digits;
    }

    /**
     * Getter for schedules property.
     * @return The value asigned to schedules.
     */
    public List<Schedule> getSchedules() {
        return schedules;
    }

    /**
     * Setter for schedules property.
     * @param schedules The value to be assigned.
     */
    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.dayOfWeek);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return !(!Objects.equals(this.dayOfWeek, ((Restriction) obj).dayOfWeek));
    }

}
