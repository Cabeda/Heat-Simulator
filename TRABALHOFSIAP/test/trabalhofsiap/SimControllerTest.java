/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    private transient ResourceBundle mensagens;

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
        boolean flag = false;
        Locale lo = new Locale("pt", "PT");
        mensagens = ResourceBundle.getBundle("MensagensBundle/MensagensBundle", lo);
        Limite lim = new Limite("teste", mensagens);
        SimController instance = new SimController();
        instance.addLim(lim);
        for (Limite l : instance.getListaLim()) {
            if (lim == l) {
                flag = true;
            }
        }
        assertTrue(flag);
    }

    /**
     * Test of altLim method, of class SimController.
     */
    @Test
    public void testAltLim() {
        System.out.println("altLim");
        Locale lo = new Locale("pt", "PT");
        mensagens = ResourceBundle.getBundle("MensagensBundle/MensagensBundle", lo);
        boolean flag = false;
        Limite lim = new Limite("tecto", mensagens);
        SimController instance = new SimController();
        instance.addLim(lim);
        lim.setArea(2);
        instance.altLim(lim);
        for (Limite l : instance.getListaLim()) {
            if (l == lim) {
                flag = true;
            }
        }
        assertTrue(flag);
    }

    /**
     * Test of criarFicheiroHTML method, of class SimController.
     */
    @Test
    public void testCriarFicheiroHTML() throws Exception {
        System.out.println("criarFicheiroHTML");
        String f = "teste";
        Locale lo = new Locale("pt", "PT");
        mensagens = ResourceBundle.getBundle("MensagensBundle/MensagensBundle", lo);
        SimController instance = new SimController();
        instance.setMensagens(lo);
        instance.criarFicheiroHTML(f);
        assertTrue(new File(f + "\\" + mensagens.getString("resultados") + ".html").isFile());
    }

    /**
     * Test of guardarDados method, of class SimController.
     */
    @Test
    public void testGuardarDados() throws IOException {
        System.out.println("guardarDados");
        String f = "teste";
        Locale lo = new Locale("pt", "PT");
        mensagens = ResourceBundle.getBundle("MensagensBundle/MensagensBundle", lo);
        SimController instance = new SimController();
        instance.setMensagens(lo);
        instance.guardarDados(f);

    }

    /**
     * Test of introduzirDados method, of class SimController.
     */
    @Test
    public void testIntroduzirDados() throws IOException {
        System.out.println("introduzirDados");
        File f = File.createTempFile("some-prefix", "some-ext");
        f.deleteOnExit();
        SimController instance = new SimController();
        instance.introduzirDados(f);
        assertTrue(f.exists());
    }

    /**
     * Test of criarListaMaterial method, of class SimController.
     */
    @Test
    public void testCriarListaMaterial() {
        System.out.println("criarListaMaterial");
        Locale lo = new Locale("pt", "PT");
        mensagens = ResourceBundle.getBundle("MensagensBundle/MensagensBundle", lo);
        SimController instance = new SimController();
        instance.setMensagens(lo);
        instance.criarListaMaterial();
        assertTrue(!instance.getListaMaterial().isEmpty());
    }

}
