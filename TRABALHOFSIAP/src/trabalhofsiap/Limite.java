/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author Jecabeda
 */
public class Limite implements java.io.Serializable {

    private String tipo;
    private double altura, largura, area;
    private transient ResourceBundle mensagens;
    private List<Abertu> listaAberturas;
    private List<Camada> listaCamadas;

    public Limite(String tipo,ResourceBundle mens) {
        this.tipo = tipo;
        this.mensagens=mens;
        listaAberturas = new ArrayList<>();
        listaCamadas = new ArrayList<>();
    }

    public Limite(ResourceBundle mens) {
        this.altura = 0;
        this.largura = 0;
        this.mensagens = mens;
        this.area = altura*largura;
        listaAberturas = new ArrayList<>();
        listaCamadas = new ArrayList<>();
    }

    public String getTipo() {
        return mensagens.getString(tipo);
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
    
    public double getEspessura(){
        double espessura = 0;
        for (Camada c: listaCamadas){
            espessura += c.getEspessura();
        }
        return espessura;
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
    /**
     * Devolve a area do limite
     * @return area (altura x largura)
     */
    public double getArea(){
        return area;
    }
    
    /**
     * Modifica a área do limite
     * @param area 
     */
    public void setArea(double area){
        this.area = area;
    }
    
    public void addAbertura(Abertu a) {
        listaAberturas.add(a);
        setArea(this.area-a.getArea());
    }

    @Override
    public String toString() {
        return getTipo() + " | " + String.format("%1$,.2f", getAltura()) + " | " + String.format("%1$,.2f", getLargura());
    }

    /**
     * @param mensagens the mensagens to set
     */
    public void setMensagens(ResourceBundle mensagens) {
        this.mensagens = mensagens;
    }

}
