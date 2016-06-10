/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.acxdev.codewriters.cmsapi.methods;

import nl.acxdev.codewriters.cmsapi.commands.StopContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author absentium
 */
public class StopContainerTest {
    
    public StopContainerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of stopIt method, of class StopContainer.
     */
    @Test
    public void testStopIt() {
        System.out.println("stopIt");
        StopContainer instance = null;
        String expResult = "";
        String result = instance.stopIt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
