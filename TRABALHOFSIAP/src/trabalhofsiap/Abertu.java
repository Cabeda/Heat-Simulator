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
public class Abertu implements java.io.Serializable {

    private Material material;
    private double altura, largura, espessura;

    private SimController dc;

    public Abertu(SimController d) {
        this.altura = 0;
        this.largura = 0;
        this.espessura = 0;
        this.material = new Material();
        this.dc = d;
    }

    public void setLargura(double la) {
        this.largura = la;
    }

    public void setAltura(double al) {
        this.altura = al;
    }

    /**
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    public double getEspessura() {
        return espessura;
    }

    /**
     * Multiplica a altura pela largura
     *
     * @return area da abertura
     */
    public double getArea() {
        return altura * largura;
    }

    public void setEspessura(double espessura) {
        this.espessura = espessura;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

     public void setMaterialPeloNome(String tipo) {
        this.material = dc.getMaterialpeloNome(tipo);
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @return the largura
     */
    public double getLargura() {
        return largura;
    }

    @Override
    public String toString() {

        return this.material.getNome() + " | " + this.altura + " | " + this.largura + " | " + " | " + this.espessura;
    }

}
