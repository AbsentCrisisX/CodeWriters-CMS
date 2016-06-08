/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.acxdev.codewriters.cmsapi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author absentium
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({nl.acxdev.codewriters.cmsapi.cors.CorsSuite.class, nl.acxdev.codewriters.cmsapi.json.JsonSuite.class, nl.acxdev.codewriters.cmsapi.methods.MethodsSuite.class, nl.acxdev.codewriters.cmsapi.MainTest.class})
public class CmsapiSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
