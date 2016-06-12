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
@Suite.SuiteClasses({nl.acxdev.codewriters.cmsapi.sender.SenderITSuite.class, nl.acxdev.codewriters.cmsapi.factory.FactoryITSuite.class, nl.acxdev.codewriters.cmsapi.cors.CorsITSuite.class, nl.acxdev.codewriters.cmsapi.json.JsonITSuite.class, nl.acxdev.codewriters.cmsapi.commands.CommandsITSuite.class, nl.acxdev.codewriters.cmsapi.MainIT.class, nl.acxdev.codewriters.cmsapi.interfaces.InterfacesITSuite.class})
public class CmsapiITSuite {

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
