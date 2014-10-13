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
        private double altura, largura, espessura;

    public Limite(String material, String tipo, double altura, double largura, double espessura) {
        this.material = material;
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.espessura= espessura;
    }

    public Limite() {
        this.material = "sem material";
        this.tipo = "sem tipo";
        this.altura = 0;
        this.largura = 0;
        this.espessura =0;
    }

    public String getMaterial() {
        return material;
    }

    public double getEspessura() {
        return espessura;
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

    public void setMaterial(String material) {
        this.material = material;
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

    public void setEspessura(double espessura) {
        this.espessura = espessura;
    }
    
    

    @Override
    public String toString() {
        return  "" + material + "/" + tipo + "/" + altura + "/" + largura +"/" + espessura;
    }
        
        
    
}
