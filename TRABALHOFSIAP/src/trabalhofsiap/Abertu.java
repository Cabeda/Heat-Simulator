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
 * Classe para criar objeto abertura
 * 
 */
public class Abertu implements java.io.Serializable {

    //Inicialização da classe pai material
    private Material material;
    
    //Inicialização da classe limite
    private Limite limite;
    
    //Inicialização das variáveis das dimensões da abertura
    private double altura, largura, espessura;

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
    public Abertu(SimController d) {
        this.altura = 0;
        this.largura = 0;
        this.espessura = 0;
        this.material = new Material();
        this.dc = d;
    }

    /**
     * 
     * Retorna o material da abertura
     * 
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    
    /**
     * 
     * Retorna a altura
     * 
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * 
     * Retorna a largura
     * 
     * @return the largura
     */
    public double getLargura() {
        return largura;
    }
    
    /**
     * 
     * Retorna a espessura
     * 
     * @return 
     */
    public double getEspessura() {
        return espessura;
    }

    /**
     * Multiplica a altura pela largura e retorna a área
     *
     * @return area da abertura
     */
    public double getArea() {
        return altura * largura;
    }
    
    /**
     * 
     * Retorna o limite onde se encontra a abertura
     * 
     * @return the l
     */
    public Limite getLimite() {
        return limite;
    }
    
    /**
     * 
     * Define a largura da abertura
     * 
     * @param la 
     */
    public void setLargura(double la) {
        this.largura = la;
    }

    /**
     * 
     * Define a altura da abertura
     * 
     * @param al 
     */
    public void setAltura(double al) {
        this.altura = al;
    }

    /**
     * 
     * Define a espessura
     * 
     * @param espessura 
     */
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
     * 
     * Retorna string com os dados da abertura
     * 
     * @return 
     */
    @Override
    public String toString() {

        return limite.getTipo() + " | " +this.material.getNome() + " | " + this.altura + " | " + this.largura + " | " + this.espessura;
    }

    /**
     * 
     * Define o limite onde se encontra a abertura
     * 
     * @param limite the l to set
     */
    public void setLimite(Limite limite) {
        this.limite = limite;
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
