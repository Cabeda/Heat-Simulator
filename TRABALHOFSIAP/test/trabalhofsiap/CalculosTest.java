/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
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

    private transient ResourceBundle mensagens;

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
        String lingua = new String("en");
        String pais = new String("EN");
        Locale currentLocale = new Locale(lingua, pais);
        ResourceBundle mensagens = ResourceBundle.getBundle("MensagensBundle/MensagensBundle", currentLocale);
        Madeira m = new Madeira(mensagens);
        Limite l = new Limite("",mensagens);
        l.setAltura(2);
        l.setLargura(2);
        l.setArea(4);
        Camada c = new Camada (dc);
        c.setEspessura(1);
        c.setLimite(l);
        c.setMaterial(m);
        l.addCamada(c);
        listaLim.add(l);
        Calculos instance = new Calculos(dc);
        double expResult = 1.923;
        double result = instance.calcularResistenciaTermica(listaLim);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of FluxoCalor1 method, of class Calculos.
     */
    @Test
    public void testFluxoCalor1() {
        System.out.println("FluxoCalor1");
        SimController dc = new SimController();
        Calculos instance = new Calculos(dc);
        dc.setNumAparelhos(1);
        dc.setNumPessoas(1);
        double expResult = 425.8;
        double result = instance.FluxoCalor1();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of FluxoCalor2 method, of class Calculos.
     */
    @Test
    public void testFluxoCalor2() {
        System.out.println("FluxoCalor2");
        
        SimController dc = new SimController();
        dc.setTemperaturaEx(10);
        dc.setTemperaturaPre(20);
        List<Limite> listaLim = new ArrayList<>();
        String lingua = new String("en");
        String pais = new String("EN");
        Locale currentLocale = new Locale(lingua, pais);
        ResourceBundle mensagens = ResourceBundle.getBundle("MensagensBundle/MensagensBundle", currentLocale);
        Madeira m = new Madeira(mensagens);
        Limite l = new Limite("",mensagens);
        l.setAltura(2);
        l.setLargura(2);
        l.setArea(4);
        Camada c = new Camada (dc);
        c.setEspessura(1);
        c.setLimite(l);
        c.setMaterial(m);
        l.addCamada(c);
        listaLim.add(l);
        dc.setListaLim(listaLim);
        
        Calculos instance = new Calculos(dc);
        
        double expResult = 5.2;
        double result = instance.FluxoCalor2();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of PotenciaFinal method, of class Calculos.
     */
    @Test
    public void testPotenciaFinal() {
        System.out.println("PotenciaFinal");

        SimController dc = new SimController();
        dc.setNumAparelhos(1);
        dc.setNumPessoas(1);
        dc.setTemperaturaEx(10);
        dc.setTemperaturaPre(20);
        List<Limite> listaLim = new ArrayList<>();
        String lingua = new String("en");
        String pais = new String("EN");
        Locale currentLocale = new Locale(lingua, pais);
        ResourceBundle mensagens = ResourceBundle.getBundle("MensagensBundle/MensagensBundle", currentLocale);
        Madeira m = new Madeira(mensagens);
        Limite l = new Limite("",mensagens);
        l.setAltura(2);
        l.setLargura(2);
        l.setArea(4);
        Camada c = new Camada (dc);
        c.setEspessura(1);
        c.setLimite(l);
        c.setMaterial(m);
        l.addCamada(c);
        listaLim.add(l);
        dc.setListaLim(listaLim);
        
        Calculos instance = new Calculos(dc);
        double expResult = 420.6;
        double result = instance.PotenciaFinal();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of calculosIntermedios method, of class Calculos.
     */
    @Test
    public void testCalculosIntermedios() {
        System.out.println("calculosIntermedios");
         SimController dc = new SimController();
        List<Limite> listaLim = new ArrayList<>();
        List<Abertu> listaAber = new ArrayList<>();
        String lingua = new String("en");
        String pais = new String("EN");
        Locale currentLocale = new Locale(lingua, pais);
        ResourceBundle mensagens = ResourceBundle.getBundle("MensagensBundle/MensagensBundle", currentLocale);
        Madeira m = new Madeira(mensagens);
        Limite l = new Limite("",mensagens);
        l.setAltura(2);
        l.setLargura(2);
        l.setArea(4);
        Camada c = new Camada (dc);
        c.setEspessura(1);
        c.setLimite(l);
        c.setMaterial(m);
        l.addCamada(c);
        listaLim.add(l);
        Calculos instance = new Calculos(dc);
        double expResult = 0.52;
        double result = instance.calculosIntermedios(listaAber, listaLim.get(0).getListaCamadas());
        assertEquals(expResult, result, 0.01);
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
        double expResult = 33.33;
        double result = instance.Resistencia(espessura, Area, condutividadeMaterial);
        assertEquals(expResult, result, 0.01);
    }

}
