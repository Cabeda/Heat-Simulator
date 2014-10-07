/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

/**
 *
 * @author Jecabeda
 */


public class DimensaoController {

    private float comprimento, largura, altura, volume;
    
    public DimensaoController() {
        this.comprimento=0;
        this.largura=0;
        this.altura=0;
        this.volume=0;
    }

    public DimensaoController(float comprimento, float largura, float altura) {
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
    }
    
    public DimensaoController(DimensaoController dc)
    {
        this.comprimento=dc.comprimento;
        this.largura=dc.largura;
        this.altura=dc.largura;
        
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
    
    
    
    
}
