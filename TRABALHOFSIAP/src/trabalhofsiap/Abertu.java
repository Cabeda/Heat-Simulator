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
public class Abertu {
        private String material,tipo;
        private int altura, largura;

    public Abertu(String nome) {
        this.altura=0;
        this.largura=0;
        this.material="";
        this.tipo="";
    }

    public Abertu() {
    }

  
    public void setLargura(int la) {
        this.largura=la;
    }
    
    public void setAltura(int al) {
        this.altura=al;
    }

    /**
     * @return the material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @return the largura
     */
    public int getLargura() {
        return largura;
    }

        @Override
    public String toString(){

        return ""+this.altura+""+this.largura+""+this.material+""+this.tipo;
    }    
    
}
