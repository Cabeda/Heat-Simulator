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
public class Camada implements java.io.Serializable {

    private Material material;
    private Limite limite;
    private double altura, largura, espessura, area;
    private SimController dc;

    public Camada(Material material, double altura, double largura, double espessura, SimController d) {
        this.material = material;
        this.espessura = espessura;
        this.dc = d;
    }

    public Camada(Material material, Limite l, double espessura, SimController d) {
        this.material = material;

        this.limite = l;
        this.espessura = espessura;
        this.dc = d;
    }

    public Camada(SimController d) {
        this.material = new Material();
        this.espessura = 0;
        this.dc = d;
    }

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
        return limite.getArea();
    }

    public double getAltura() {
        return getLimite().getAltura();
    }

    public double getLargura() {
        return getLimite().getLargura();
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setMaterialPeloNome(String tipo) {
        this.material = dc.getMaterialpeloNome(tipo);
    }

    public void setEspessura(double espessura) {
        this.espessura = espessura;
    }

    @Override
    public String toString() {
        return limite.getTipo()+ " | "+material.getNome() + " | " + limite.getAltura() + " | " + limite.getLargura() + " | " + espessura;
    }

    /**
     * @return the limite
     */
    public Limite getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(Limite limite) {
        this.limite = limite;
    }

}
