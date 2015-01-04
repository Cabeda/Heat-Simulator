/*
 TRABALHO DE FÍSICA
 António Pinheiro 1130339
 Cristina Lopes 1130371
 Egídio Santos 1130348
 José Cabeda 1130395
 */
package trabalhofsiap;

/**
 *
 * Classe para criar objeto camada
 *
 */
public class Camada implements java.io.Serializable {

    //Inicialização da classe pai material
    private Material material;

    //Inicialização da classe limite
    private Limite limite;

    //Inicialização da variável da espessura da abertura
    private double espessura;

    //Inicialização do controller do programa
    private SimController dc;

    //Fluxo de calor na camada
    private double FluxoCalor;
            
    /**
     *
     * Construtor vazio
     *
     * @param d
     */
    public Camada(SimController d) {
        this.material = new Material();
        this.espessura = 0;
        this.dc = d;
    }

    /**
     *
     * Devolve o material da camada
     *
     * @return
     */
    public Material getMaterial() {
        return material;
    }

    /**
     *
     * Devolve a espessura da camada
     *
     * @return
     */
    public double getEspessura() {
        return espessura;
    }

    /**
     * Multiplica a altura pela largura e devolve a área
     *
     * @return area da abertura
     */
    public double getArea() {
        return limite.getArea();
    }

    /**
     *
     * Devolve a altura da camada
     *
     * @return
     */
    public double getAltura() {
        return getLimite().getAltura();
    }

    /**
     *
     * Devolve a altura da camada
     *
     * @return
     */
    public double getLargura() {
        return getLimite().getLargura();
    }

    /**
     *
     * Devolve o limite onde se encontra a camada
     *
     * @return the limite
     */
    public Limite getLimite() {
        return limite;
    }

    /**
     *
     * Define o material da camada
     *
     * @param material
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     *
     * Define o material pelo nome do mesmo
     *
     * @param tipo
     */
    public void setMaterialPeloNome(String tipo) {
        this.material = dc.getMaterialpeloNome(tipo);
    }

    /**
     *
     * Define a espessura da camada
     *
     * @param espessura
     */
    public void setEspessura(double espessura) {
        this.espessura = espessura;
    }

    /**
     * 
     * Define o limite onde se encontra a camada
     * 
     * @param limite the limite to set
     */
    public void setLimite(Limite limite) {
        this.limite = limite;
    }

    /**
     *
     * Devolve uma string com os dados da camada
     *
     * @return
     */
    @Override
    public String toString() {
        return limite.getTipo() + " | " + material.getNome() + " | " + limite.getAltura() + " | " + limite.getLargura() + " | " + espessura;
    }

    /**
     * @return the FluxoCalor
     */
    public double getFluxoCalor() {
        return FluxoCalor;
    }

    /**
     * @param FluxoCalor the FluxoCalor to set
     */
    public void setFluxoCalor(double FluxoCalor) {
        this.FluxoCalor = FluxoCalor;
    }

}
