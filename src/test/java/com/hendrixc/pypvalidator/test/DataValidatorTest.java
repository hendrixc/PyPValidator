/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator.test;

import com.hendrixc.pypvalidator.exeption.ValidationException;
import com.hendrixc.pypvalidator.utils.DataValidator;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Test Case used to validate all methods of DataValidator class.
 * @author Henry Coral
 */
public class DataValidatorTest {
    
    private static final Logger LOG = Logger.getLogger(DataValidatorTest.class.getName());
    
    private DataValidator dataValidator;

    public DataValidatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        LOG.info("Starting DataValidator TestCase");
    }
    

    @AfterClass
    public static void tearDownClass() {
        LOG.info("DataValidator TestCase finished");
    }

    @Before
    public void setUp() {
        this.dataValidator = new DataValidator();
    }

    
    @Test
    public void testValidatePlate() {
        Assertions.assertDoesNotThrow(()->{this.dataValidator.validatePlate("PCM3820");});
        Assertions.assertDoesNotThrow(()->{this.dataValidator.validatePlate("pcm382");});
        Assertions.assertThrows(ValidationException.class, 
                ()->{this.dataValidator.validatePlate("AA90");});
    }
    
    @Test
    public void testValidateDate() {
        Assertions.assertDoesNotThrow(()->{this.dataValidator.validateDate("2020-05-01");});
        Assertions.assertThrows(ValidationException.class, 
                ()->{this.dataValidator.validateDate("2020-02-30");});
        Assertions.assertThrows(ValidationException.class, 
                ()->{this.dataValidator.validateDate("2020/02/30");});
    }
    
    @Test
    public void testValidateTime() {
        Assertions.assertDoesNotThrow(()->{this.dataValidator.validateTime("15:30");});
        Assertions.assertThrows(ValidationException.class, 
                ()->{this.dataValidator.validateTime("5:5");});
        Assertions.assertThrows(ValidationException.class, 
                ()->{this.dataValidator.validateTime("5:05");});
        Assertions.assertThrows(ValidationException.class, 
                ()->{this.dataValidator.validateTime("05:5");});
        Assertions.assertThrows(ValidationException.class, 
                ()->{this.dataValidator.validateTime("24:00");});
    }
}
