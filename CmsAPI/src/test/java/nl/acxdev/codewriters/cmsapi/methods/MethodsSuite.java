/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.acxdev.codewriters.cmsapi.methods;

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
@Suite.SuiteClasses({nl.acxdev.codewriters.cmsapi.methods.GetServersTest.class, nl.acxdev.codewriters.cmsapi.methods.CreateContainerTest.class, nl.acxdev.codewriters.cmsapi.methods.StartContainerTest.class, nl.acxdev.codewriters.cmsapi.methods.MoveContainerTest.class, nl.acxdev.codewriters.cmsapi.methods.RenameContainerTest.class, nl.acxdev.codewriters.cmsapi.methods.RemoveContainerTest.class, nl.acxdev.codewriters.cmsapi.methods.StopContainerTest.class})
public class MethodsSuite {

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
