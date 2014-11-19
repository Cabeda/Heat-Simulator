/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jecabeda
 */
public class SimControllerTest {
    
    public SimControllerTest() {
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
     * Test of addLim method, of class SimController.
     */
    @Test
    public void testAddLim() {
        System.out.println("addLim");
        Limite listaLim = null;
        SimController instance = new SimController();
        instance.addLim(listaLim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of altLim method, of class SimController.
     */
    @Test
    public void testAltLim() {
        System.out.println("altLim");
        Limite listaLim2 = null;
        SimController instance = new SimController();
        instance.altLim(listaLim2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarFicheiroHTML method, of class SimController.
     */
    @Test
    public void testCriarFicheiroHTML() throws Exception {
        System.out.println("criarFicheiroHTML");
        String f = "";
        SimController instance = new SimController();
        instance.criarFicheiroHTML(f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarDados method, of class SimController.
     */
    @Test
    public void testGuardarDados() {
        System.out.println("guardarDados");
        String f = "";
        SimController instance = new SimController();
        instance.guardarDados(f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of introduzirDados method, of class SimController.
     */
    @Test
    public void testIntroduzirDados() {
        System.out.println("introduzirDados");
        File f = null;
        SimController instance = new SimController();
        instance.introduzirDados(f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarListaMaterial method, of class SimController.
     */
    @Test
    public void testCriarListaMaterial() {
        System.out.println("criarListaMaterial");
        SimController instance = new SimController();
        instance.criarListaMaterial();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
