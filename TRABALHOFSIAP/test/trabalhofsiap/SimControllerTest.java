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
     * Test of getComprimento method, of class SimController.
     */
    @Test
    public void testGetComprimento() {
        System.out.println("getComprimento");
        SimController instance = new SimController();
        double expResult = 0.0;
        double result = instance.getComprimento();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLargura method, of class SimController.
     */
    @Test
    public void testGetLargura() {
        System.out.println("getLargura");
        SimController instance = new SimController();
        double expResult = 0.0;
        double result = instance.getLargura();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAltura method, of class SimController.
     */
    @Test
    public void testGetAltura() {
        System.out.println("getAltura");
        SimController instance = new SimController();
        double expResult = 0.0;
        double result = instance.getAltura();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTemperaturaEx method, of class SimController.
     */
    @Test
    public void testGetTemperaturaEx() {
        System.out.println("getTemperaturaEx");
        SimController instance = new SimController();
        float expResult = 0.0F;
        float result = instance.getTemperaturaEx();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTemperaturaPre method, of class SimController.
     */
    @Test
    public void testGetTemperaturaPre() {
        System.out.println("getTemperaturaPre");
        SimController instance = new SimController();
        float expResult = 0.0F;
        float result = instance.getTemperaturaPre();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAreaTotal method, of class SimController.
     */
    @Test
    public void testGetAreaTotal() {
        System.out.println("getAreaTotal");
        SimController instance = new SimController();
        double expResult = 0.0;
        double result = instance.getAreaTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumPessoas method, of class SimController.
     */
    @Test
    public void testGetNumPessoas() {
        System.out.println("getNumPessoas");
        SimController instance = new SimController();
        int expResult = 0;
        int result = instance.getNumPessoas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumAparelhos method, of class SimController.
     */
    @Test
    public void testGetNumAparelhos() {
        System.out.println("getNumAparelhos");
        SimController instance = new SimController();
        int expResult = 0;
        int result = instance.getNumAparelhos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaLim method, of class SimController.
     */
    @Test
    public void testGetListaLim() {
        System.out.println("getListaLim");
        SimController instance = new SimController();
        List<Limite> expResult = null;
        List<Limite> result = instance.getListaLim();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComprimento method, of class SimController.
     */
    @Test
    public void testSetComprimento() {
        System.out.println("setComprimento");
        double comprimento = 0.0;
        SimController instance = new SimController();
        instance.setComprimento(comprimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLargura method, of class SimController.
     */
    @Test
    public void testSetLargura() {
        System.out.println("setLargura");
        double largura = 0.0;
        SimController instance = new SimController();
        instance.setLargura(largura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAltura method, of class SimController.
     */
    @Test
    public void testSetAltura() {
        System.out.println("setAltura");
        double altura = 0.0;
        SimController instance = new SimController();
        instance.setAltura(altura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAreaTotal method, of class SimController.
     */
    @Test
    public void testSetAreaTotal_0args() {
        System.out.println("setAreaTotal");
        SimController instance = new SimController();
        instance.setAreaTotal();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAreaTotal method, of class SimController.
     */
    @Test
    public void testSetAreaTotal_double() {
        System.out.println("setAreaTotal");
        double area = 0.0;
        SimController instance = new SimController();
        instance.setAreaTotal(area);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumPessoas method, of class SimController.
     */
    @Test
    public void testSetNumPessoas() {
        System.out.println("setNumPessoas");
        int numPessoas = 0;
        SimController instance = new SimController();
        instance.setNumPessoas(numPessoas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTemperaturaEx method, of class SimController.
     */
    @Test
    public void testSetTemperaturaEx() {
        System.out.println("setTemperaturaEx");
        float temperatura = 0.0F;
        SimController instance = new SimController();
        instance.setTemperaturaEx(temperatura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTemperaturaPre method, of class SimController.
     */
    @Test
    public void testSetTemperaturaPre() {
        System.out.println("setTemperaturaPre");
        float temperaturaPre = 0.0F;
        SimController instance = new SimController();
        instance.setTemperaturaPre(temperaturaPre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumAparelhos method, of class SimController.
     */
    @Test
    public void testSetNumAparelhos() {
        System.out.println("setNumAparelhos");
        int numAparelhos = 0;
        SimController instance = new SimController();
        instance.setNumAparelhos(numAparelhos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
     * Test of getListaAberturas method, of class SimController.
     */
    @Test
    public void testGetListaAberturas() {
        System.out.println("getListaAberturas");
        SimController instance = new SimController();
        List<Abertu> expResult = null;
        List<Abertu> result = instance.getListaAberturas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCamadas method, of class SimController.
     */
    @Test
    public void testGetListaCamadas() {
        System.out.println("getListaCamadas");
        SimController instance = new SimController();
        List<Camada> expResult = null;
        List<Camada> result = instance.getListaCamadas();
        assertEquals(expResult, result);
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
     * Test of toString method, of class SimController.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SimController instance = new SimController();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
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
     * Test of setListaLim method, of class SimController.
     */
    @Test
    public void testSetListaLim() {
        System.out.println("setListaLim");
        List<Limite> listaLim = null;
        SimController instance = new SimController();
        instance.setListaLim(listaLim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMensagens method, of class SimController.
     */
    @Test
    public void testGetMensagens() {
        System.out.println("getMensagens");
        SimController instance = new SimController();
        ResourceBundle expResult = null;
        ResourceBundle result = instance.getMensagens();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMensagens method, of class SimController.
     */
    @Test
    public void testSetMensagens() {
        System.out.println("setMensagens");
        Locale currentLocale = null;
        SimController instance = new SimController();
        instance.setMensagens(currentLocale);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaterialpeloNome method, of class SimController.
     */
    @Test
    public void testGetMaterialpeloNome() {
        System.out.println("getMaterialpeloNome");
        String tipo = "";
        SimController instance = new SimController();
        Material expResult = null;
        Material result = instance.getMaterialpeloNome(tipo);
        assertEquals(expResult, result);
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
