/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator.model;

import java.util.Objects;

/**
 * Model class that represents a Vehicle.
 * 
 * @author Henry Coral
 */
public class Vehicle {
    
    /**
     * Property that represents a plate of vehicle.
     */
    private String plate;
    /**
     * Property that represents the type of vehicle.
     */
    private String type;

    /**
     * Getter for plate property.
     * @return The value asigned to plate.
     */
    public String getPlate() {
        return plate;
    }

    /**
     * Setter for plate property.
     * @param plate The value to be assigned.
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * Getter for type property.
     * @return The value asigned to type.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for type property.
     * @param type The value to be assigned.
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.plate);
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
        return !(!Objects.equals(this.plate, ((Vehicle) obj).plate));
    }
    
    
}
