/*
 * System: PyPValidator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.pypvalidator.test;

import com.hendrixc.pypvalidator.conf.RestrictionConfigurator;
import com.hendrixc.pypvalidator.db.RestrictionDB;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * 
 * @author Henry Coral
 */
public class RestrictionsLoadTest {

    private static final Logger LOG = Logger.getLogger(RestrictionsLoadTest.class.getName());
    
    private RestrictionDB db; 
    
    public RestrictionsLoadTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        LOG.info("Starting RestrictionsLoad TestCase");
    }
    
    @AfterClass
    public static void tearDownClass() {
        LOG.info("RestrictionsLoad TestCase finished");
    }
    
    @Before
    public void setUp() {
        RestrictionConfigurator.config();
        this.db = RestrictionDB.getInstance();
    }
    
    @Test
    public void testNumberOfRestrictionsLoaded() {
        Assertions.assertNull(this.db.getRestrictionByDay(0));
        Assertions.assertNotNull(this.db.getRestrictionByDay(1));
        Assertions.assertNotNull(this.db.getRestrictionByDay(2));
        Assertions.assertNotNull(this.db.getRestrictionByDay(3));
        Assertions.assertNotNull(this.db.getRestrictionByDay(4));
        Assertions.assertNotNull(this.db.getRestrictionByDay(5));
        Assertions.assertNull(this.db.getRestrictionByDay(6));
        Assertions.assertNull(this.db.getRestrictionByDay(7));
        Assertions.assertNull(this.db.getRestrictionByDay(8));
    }
    
}
