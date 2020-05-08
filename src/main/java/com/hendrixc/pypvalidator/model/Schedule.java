/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator.model;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Model class that represents a schedule of one restriction.
 * @author Henry Coral
 */
public class Schedule {
    
    /**
     * Property that represents the start time of restriction.
     */
    private LocalTime start;
    /**
     * Property that represents the end time of restriction.
     */
    private LocalTime end;

    /**
     * Getter for start property.
     * @return The value asigned to start time.
     */
    public LocalTime getStart() {
        return start;
    }

    /**
     * Setter for start property.
     * @param start The value to be assigned.
     */
    public void setStart(LocalTime start) {
        this.start = start;
    }

    /**
     * Getter for end property.
     * @return The value asigned to end time.
     */
    public LocalTime getEnd() {
        return end;
    }

    /**
     * Setter for end property.
     * @param end The value to be assigned.
     */
    public void setEnd(LocalTime end) {
        this.end = end;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.start);
        hash = 67 * hash + Objects.hashCode(this.end);
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
        final Schedule other = (Schedule) obj;
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        return true;
    }
    
}
