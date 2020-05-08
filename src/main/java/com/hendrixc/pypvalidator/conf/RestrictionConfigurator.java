/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator.conf;

import com.hendrixc.pypvalidator.db.RestrictionDB;
import com.hendrixc.pypvalidator.model.Restriction;
import com.hendrixc.pypvalidator.model.Schedule;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class load in memory the default "pico y placa" restrictions.
 * 
 * @author Henry Coral
 */
public class RestrictionConfigurator {
    
    private static final RestrictionDB db = RestrictionDB.getInstance();
    
    /**
     * Default method to be called to load restrictions.
     */
    public static void config() {
        RestrictionConfigurator.loadDefaultRestrictions();
    }
    
    private static void loadDefaultRestrictions() {
        Schedule morning = new Schedule();
        morning.setStart(LocalTime.of(7, 0,0));
        morning.setEnd(LocalTime.of(9, 30,59));
        Schedule evening = new Schedule();
        evening.setStart(LocalTime.of(16, 0,0));
        evening.setEnd(LocalTime.of(19, 30,59));
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(morning);
        schedules.add(evening);
        final Integer digits[] = new Integer[]{1,2,3,4,5,6,7,8,9,0};
        int k = 0;
        for (int i=1; i<=5; i++, k++) {
            Restriction restriction = new Restriction(i);
            Set<Integer> digitsR = new HashSet<>();
            digitsR.add(digits[k]);
            digitsR.add(digits[++k]);
            restriction.setDigits(digitsR);
            restriction.setSchedules(schedules);
            db.setRestriction(i, restriction);
        }
        
    }
}
