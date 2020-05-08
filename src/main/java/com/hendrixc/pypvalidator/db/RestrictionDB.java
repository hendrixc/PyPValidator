/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator.db;

import com.hendrixc.pypvalidator.model.Restriction;
import java.util.HashMap;
import java.util.Map;

/**
 * Class which contains all restrictions grouped by day of week.
 * 
 * @author Henry Coral
 */
public class RestrictionDB {
    
    /**
     * Singleton instance.
     */
    private static RestrictionDB db;
    
    /**
     * Database representes as a Map objet.
     */
    private final Map<Integer,Restriction> restrictions = new HashMap<>();
    
    /**
     * Gets an instance of this class.
     * @return Singleton instance for this class.
     */
    public static RestrictionDB getInstance() {
        if (db == null) {
            RestrictionDB.db = new RestrictionDB();
        }
        return RestrictionDB.db;
    }
    
    /**
     * Default private constructor.
     */
    private RestrictionDB() {
    }
    
    /**
     * Get the restriction associated with one day of week.
     * @param dayOfWeek Day of week identified by values from 0 to 6 (Sunday to Saturday).
     * @return Restriction associated to day of week received.  If none restriction is
     * associated for an specific day of week, returns null.
     */
    public Restriction getRestrictionByDay(Integer dayOfWeek) {
        return this.restrictions.get(dayOfWeek);
    }
    
    /**
     * Method used to populate one by one the restrictions.
     * @param dayOfWeek Day of week identified by values from 0 to 6 (Sunday to Saturday).
     * @param restriction Restriction to be set.
     */
    public void setRestriction(Integer dayOfWeek, Restriction restriction) {
        this.restrictions.put(dayOfWeek, restriction);
    }
    
}
