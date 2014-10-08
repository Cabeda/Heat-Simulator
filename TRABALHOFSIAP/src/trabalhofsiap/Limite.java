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
public class Limite {
    
    private String material,tipo;
        private int altura, largura;

    public Limite(String material, String tipo, int altura, int largura) {
        this.material = material;
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
    }

    public Limite() {
        this.material = "sem material";
        this.tipo = "sem tipo";
        this.altura = 0;
        this.largura = 0;
    }

    public String getMaterial() {
        return material;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }
        
        
    
}
