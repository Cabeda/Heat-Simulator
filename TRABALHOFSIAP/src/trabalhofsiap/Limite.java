/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jecabeda
 */
public class Limite implements java.io.Serializable {

    private String tipo;
    private double altura, largura;
    private SimController dc;
    private List<Abertu> listaAberturas;
    private List<Camada> listaCamadas;

    public Limite(String tipo, double altura, double largura, SimController d) {
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.dc = d;
        listaAberturas = new ArrayList<Abertu>();
        listaCamadas = new ArrayList<>();

    }

    public Limite(String tipo, SimController d) {
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.dc = d;
        listaAberturas = new ArrayList<Abertu>();
        listaCamadas = new ArrayList<>();

    }

    public Limite(SimController d) {
        this.altura = 0;
        this.largura = 0;
        this.dc = d;
        listaAberturas = new ArrayList<Abertu>();
        listaCamadas = new ArrayList<>();

    }

    public String getTipo() {
        return tipo;
    }

    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }

    public List<Abertu> getListaAberturas() {
        return listaAberturas;
    }

    public List<Camada> getListaCamadas() {
        return listaCamadas;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public void addCamada(Camada c) {
        listaCamadas.add(c);
        
    }
    
    public void addAbertura(Abertu a) {
        listaAberturas.add(a);
        
    }

    @Override
    public String toString() {
        return getTipo() + " | " + getAltura() + " | " + getLargura();
    }

}
