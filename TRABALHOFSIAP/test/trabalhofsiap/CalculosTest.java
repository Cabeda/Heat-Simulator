/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

import java.util.List;
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
public class CalculosTest {
    
    public CalculosTest() {
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
     * Test of calcularResistenciaTermica method, of class Calculos.
     */
    @Test
    public void testCalcularResistenciaTermica() {
        System.out.println("calcularResistenciaTermica");
        List<Limite> listaLim = null;
        Calculos instance = null;
        double expResult = 0.0;
        double result = instance.calcularResistenciaTermica(listaLim);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FluxoCalor1 method, of class Calculos.
     */
    @Test
    public void testFluxoCalor1() {
        System.out.println("FluxoCalor1");
        Calculos instance = null;
        double expResult = 0.0;
        double result = instance.FluxoCalor1();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FluxoCalor2 method, of class Calculos.
     */
    @Test
    public void testFluxoCalor2() {
        System.out.println("FluxoCalor2");
        Calculos instance = null;
        double expResult = 0.0;
        double result = instance.FluxoCalor2();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PotenciaFinal method, of class Calculos.
     */
    @Test
    public void testPotenciaFinal() {
        System.out.println("PotenciaFinal");
        Calculos instance = null;
        double expResult = 0.0;
        double result = instance.PotenciaFinal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculosIntermedios method, of class Calculos.
     */
    @Test
    public void testCalculosIntermedios() {
        System.out.println("calculosIntermedios");
        List<Abertu> la = null;
        List<Camada> lc = null;
        Calculos instance = null;
        double expResult = 0.0;
        double result = instance.calculosIntermedios(la, lc);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Resistencia method, of class Calculos.
     */
    @Test
    public void testResistencia() {
        System.out.println("Resistencia");
        double espessura = 0.0;
        double Area = 0.0;
        double condutividadeMaterial = 0.0;
        Calculos instance = null;
        double expResult = 0.0;
        double result = instance.Resistencia(espessura, Area, condutividadeMaterial);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
