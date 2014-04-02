/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.kdg.repaircafemodel.dom.repairs;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wouter
 */
public class RepairDetailsTest
{
    
    public RepairDetailsTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getExpirationTime method, of class RepairDetails.
     */
    @Test
    public void testGetExpirationTime()
    {
        System.out.println("getExpirationTime");
        RepairDetails instance = new RepairDetails();
        DateTime dueDate = new DateTime().plusDays(5).plusHours(3).plusMinutes(5);
        instance.setDueDate(dueDate);
        Period expResult = new Period(new DateTime(),dueDate);
        Period result = instance.getExpirationTime();
        assertEquals(expResult.getDays(), result.getDays());
        assertEquals(expResult.getHours(), result.getHours());
        assertEquals(expResult.getMinutes(), result.getMinutes());
    }

}
