/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

import java.util.ArrayList;
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
        SimController dc = new SimController();
        List<Limite> listaLim = new ArrayList<>();
        Calculos instance = new Calculos(dc);
        double expResult = 0.0;
        double result = instance.calcularResistenciaTermica(listaLim);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of FluxoCalor1 method, of class Calculos.
     */
    @Test
    public void testFluxoCalor1() {
        System.out.println("FluxoCalor1");
        SimController dc = new SimController();
        Calculos instance = new Calculos(dc);
        double expResult = 0.0;
        double result = instance.FluxoCalor1();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of FluxoCalor2 method, of class Calculos.
     */
    @Test
    public void testFluxoCalor2() {
        System.out.println("FluxoCalor2");
                
        double espessura = 1;
        double Area = 1;
        double condutividadeMaterial = 0.03;
        
        SimController dc = new SimController();
        dc.setTemperaturaEx(1);
        dc.setTemperaturaPre(1);
        dc.addLim(new Limite("teste", null));
        Calculos instance = new Calculos(dc);
        instance.Resistencia(espessura, Area, condutividadeMaterial);
        double expResult = 0.0;
        double result = instance.FluxoCalor2();
        assertEquals(expResult, result, 0.0);        
    }

    /**
     * Test of PotenciaFinal method, of class Calculos.
     */
    @Test
    public void testPotenciaFinal() {
        System.out.println("PotenciaFinal");
        
        double espessura = 1;
        double Area = 1;
        double condutividadeMaterial = 0.03;
        
        SimController dc = new SimController();
        dc.setTemperaturaEx(1);
        dc.setTemperaturaPre(1);
        dc.addLim(new Limite("teste", null));
        Calculos instance = new Calculos(dc);
        instance.Resistencia(espessura, Area, condutividadeMaterial);
        double expResult = 0.0;
        double result = instance.PotenciaFinal();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculosIntermedios method, of class Calculos.
     */
    @Test
    public void testCalculosIntermedios() {
        System.out.println("calculosIntermedios");
        List<Abertu> la = new ArrayList<>();
        List<Camada> lc = new ArrayList<>();
        SimController dc = new SimController();
        Calculos instance = new Calculos(dc);
        double soma = 0;      
        double expResult = 1/soma;
        double result = instance.calculosIntermedios(la, lc);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of Resistencia method, of class Calculos.
     */
    @Test
    public void testResistencia() {
        System.out.println("Resistencia");
        double espessura = 1;
        double Area = 1;
        double condutividadeMaterial = 0.03;
        SimController dc = new SimController();
        Calculos instance = new Calculos(dc);
        double expResult = 0.03;
        double result = instance.Resistencia(espessura, Area, condutividadeMaterial);
        assertEquals(expResult, result, 0.0);
    }
    
}
