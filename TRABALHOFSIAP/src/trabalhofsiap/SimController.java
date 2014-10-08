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


public class SimController {

    private float comprimento, largura, altura, volume, potenciaMedia;
    int numPessoas, temperatura, numAparelhos;
    private List<Limite> listaLim  = new ArrayList();
    private List<Abertu> listaAber  = new ArrayList();

    public SimController(float comprimento, float largura, float altura, float volume, float potenciaMedia, int numPessoas, int temperatura, int numAparelhos) {
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.volume = volume;
        this.potenciaMedia = potenciaMedia;
        this.numPessoas = numPessoas;
        this.temperatura = temperatura;
        this.numAparelhos = numAparelhos;
    }
    
    public SimController() {
        this.comprimento=0;
        this.largura=0;
        this.altura=0;
        this.volume=0;
        this.numPessoas=0;
    }
    
    public SimController(SimController dc)
    {
        this.comprimento=dc.comprimento;
        this.largura=dc.largura;
        this.altura=dc.largura;
        this.numPessoas=dc.numPessoas;
        this.temperatura = dc.temperatura;
        this.numAparelhos = dc.numAparelhos;
        this.potenciaMedia = dc.potenciaMedia;
        
    }

    public float getComprimento() {
        return comprimento;
    }

    public float getLargura() {
        return largura;
    }

    public float getAltura() {
        return altura;
    }
    
    public float getVolume() {
        
        return volume;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public float getPotenciaMedia() {
        return potenciaMedia;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getNumAparelhos() {
        return numAparelhos;
    }

    
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    public void setVolume()
    {
        volume=comprimento*largura*altura;
        
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public void setPotenciaMedia(float potenciaMedia) {
        this.potenciaMedia = potenciaMedia;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public void setNumAparelhos(int numAparelhos) {
        this.numAparelhos = numAparelhos;
    }

    @Override
    public String toString() {
        return  "Comprimento:" + comprimento + ", Largura:" + largura + ", Altura:"
                + "" + altura + ", Volume:" + volume + ", Potencia Media: " 
                + potenciaMedia + ", Numero de Pessoas:" + numPessoas + ", Temperatura:"
                + "" + temperatura + ", Numero de Aparelhos:" + numAparelhos;
    }
    
    public String calcular(){
        String x ="";
        
        return x;
    }
    
    
    
    
    
}
