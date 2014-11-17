/*
TRABALHO DE FÍSICA
António Pinheiro 1130339
Cristina Lopes 1130371
Egídio Santos 1130348
José Cabeda 1130395
 */
package trabalhofsiap;

public class Abertu implements java.io.Serializable {

    private Material material;
    private Limite limite;
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

        return limite.getTipo() + " | " +this.material.getNome() + " | " + this.altura + " | " + this.largura + " | " + this.espessura;
    }

    /**
     * @return the l
     */
    public Limite getLimite() {
        return limite;
    }

    /**
     * @param limite the l to set
     */
    public void setLimite(Limite limite) {
        this.limite = limite;
    }

}
