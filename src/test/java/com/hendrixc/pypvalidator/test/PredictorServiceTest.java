/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator.test;

import com.hendrixc.pypvalidator.conf.RestrictionConfigurator;
import com.hendrixc.pypvalidator.exeption.ValidationException;
import com.hendrixc.pypvalidator.model.Vehicle;
import com.hendrixc.pypvalidator.service.PredictorService;
import com.hendrixc.pypvalidator.utils.DataConverter;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Test Case used to validate restrictions loaded by default.
 * @author Henry Coral
 */
public class PredictorServiceTest {

    private static final Logger LOG = Logger.getLogger(PredictorServiceTest.class.getName());
    
    private PredictorService service;
    private DataConverter converter;
    private Vehicle vehicle;
    
    public PredictorServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        LOG.info("Starting PredictorService TestCase");
    }
    
    @AfterClass
    public static void tearDownClass() {
        LOG.info("PredictorService TestCase finished");
    }
    
    @Before
    public void setUp() {
        RestrictionConfigurator.config();
        this.service = new PredictorService();
        this.converter = new DataConverter();
        this.vehicle = new Vehicle();
        vehicle.setPlate("PCM3820");
    }
    
    @Test
    public void testPredictorWithRestriction() {
        String date = "2020-05-01";
        String time = "08:00";
        try {
            Assertions.assertEquals(true, this.callService(this.vehicle, date, time));
        } catch (ValidationException ex) {
            LOG.info("This log must no be printed!");
        }
    }
    
    @Test
    public void testPredictorWithNoRestriction() {
        String date = "2020-05-01";
        String time = "11:00";
        try {
            Assertions.assertEquals(false, this.callService(this.vehicle, date, time));
        } catch (ValidationException ex) {
            LOG.info("This log must no be printed!");
        }
    }
    
    @Test
    public void testPredictorLowerLimit() {
        String date = "2020-05-01";
        String time = "07:00";
        try {
            Assertions.assertEquals(true, this.callService(this.vehicle, date, time));
        } catch (ValidationException ex) {
            LOG.info("This log must no be printed!");
        }
    }
    
    @Test
    public void testPredictorHigherLimit() {
        String date = "2020-05-01";
        String time = "09:30";
        try {
            Assertions.assertEquals(true, this.callService(this.vehicle, date, time));
        } catch (ValidationException ex) {
            LOG.info("This log must no be printed!");
        }
    }
    
    
    private boolean callService(Vehicle vehicle, String date, String time) throws ValidationException {
        return this.service.predict(vehicle, converter.convert(date, time));
    }
}
