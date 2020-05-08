/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator.test;

import com.hendrixc.pypvalidator.utils.DataConverter;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Test Case used to validate all methods of DataConverter class.
 * @author Henry Coral
 */
public class DataConverterTest {

    private static final Logger LOG = Logger.getLogger(DataConverterTest.class.getName());
    
    DataConverter dataConverter;
    
    public DataConverterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        LOG.info("Starting DataConverter TestCase");
    }
    
    @AfterClass
    public static void tearDownClass() {
        LOG.info("DataConverter TestCase finished");
    }
    
    @Before
    public void setUp() {
        dataConverter = new DataConverter();
    }
    
    @Test
    public void testConvert() {
        Assertions.assertDoesNotThrow(()->{this.dataConverter.convert("2020-05-01","19:30");});
        Assertions.assertThrows(Exception.class, 
                ()->{this.dataConverter.convert("2020-02-30","19:30");});
         
    }
    
}
