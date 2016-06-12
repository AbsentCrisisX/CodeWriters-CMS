/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.acxdev.codewriters.cmsapi.commands;

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
@Suite.SuiteClasses({nl.acxdev.codewriters.cmsapi.commands.RemoveIT.class, nl.acxdev.codewriters.cmsapi.commands.MoveIT.class, nl.acxdev.codewriters.cmsapi.commands.CreateIT.class, nl.acxdev.codewriters.cmsapi.commands.StopIT.class, nl.acxdev.codewriters.cmsapi.commands.RenameIT.class, nl.acxdev.codewriters.cmsapi.commands.GetServersIT.class, nl.acxdev.codewriters.cmsapi.commands.StartIT.class})
public class CommandsITSuite {

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
