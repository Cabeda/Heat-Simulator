/*
 TRABALHO DE FÍSICA
 António Pinheiro 1130339
 Cristina Lopes 1130371
 Egídio Santos 1130348
 José Cabeda 1130395
 */
package trabalhofsiap;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * Classe do objeto limite
 *
 */
public class Limite implements java.io.Serializable {

    //Inicialização da variável para guardar o tipo de limite
    private String tipo;

    //Inicalização das variáveis das dimensões do limite
    private double altura, largura, area;

    //ResourceBundle com todas as mensagens apresentadas no programa
    private transient ResourceBundle mensagens;
    
    //Inicialização da lista de aberturas dentro do limite
    private List<Abertu> listaAberturas;
    
    //Inicialização da lista de camadas dentro do limite
    private List<Camada> listaCamadas;

    /**
     * 
     * Construtor do limite
     * 
     * @param tipo
     * @param mens 
     */
    public Limite(String tipo, ResourceBundle mens) {
        this.tipo = tipo;
        this.mensagens = mens;
        listaAberturas = new ArrayList<>();
        listaCamadas = new ArrayList<>();
    }

    /**
     * 
     * Construtor vazio
     * 
     * @param mens 
     */
    public Limite(ResourceBundle mens) {
        this.altura = 0;
        this.largura = 0;
        this.mensagens = mens;
        this.area = altura * largura;
        listaAberturas = new ArrayList<>();
        listaCamadas = new ArrayList<>();
    }

    /**
     * 
     * Get tipo de limite
     * 
     * @return 
     */
    public String getTipo() {
        return mensagens.getString(tipo);
    }

    /**
     * 
     * Get altura do limite
     * 
     * @return 
     */
    public double getAltura() {
        return altura;
    }

    /**
     * 
     * Get largura do limite
     * 
     * @return 
     */
    public double getLargura() {
        return largura;
    }

    /**
     * 
     * Get lista de aberturas do limite
     * 
     * @return 
     */
    public List<Abertu> getListaAberturas() {
        return listaAberturas;
    }

    /**
     * 
     * Get lista de camadas do limite
     * 
     * @return 
     */
    public List<Camada> getListaCamadas() {
        return listaCamadas;
    }

    /**
     * 
     * Get espessura do limite
     * 
     * @return 
     */
    public double getEspessura() {
        double espessura = 0;
        for (Camada c : listaCamadas) {
            espessura += c.getEspessura();
        }
        return espessura;
    }
    
    
   /**
    * 
    * Devolve área do limite
    * 
    * @return 
    */
    public double getArea() {
        double soma=0;
        for(Abertu a : listaAberturas)
        {
            soma +=a.getArea();
        }
        return area-soma;
    }

    /**
     * 
     * Define tipo do limite
     * 
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * 
     * Define altura do limite
     * 
     * @param altura 
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * 
     * Define largura do limite
     * 
     * @param largura 
     */
    public void setLargura(double largura) {
        this.largura = largura;
    }
    
    /**
     * 
     * Define as mensagens do programa
     * 
     * @param mensagens the mensagens to set
     */
    public void setMensagens(ResourceBundle mensagens) {
        this.mensagens = mensagens;
    }

    /**
     * 
     * Adiciona camada ao limite
     * 
     * @param c 
     */
    public void addCamada(Camada c) {
        listaCamadas.add(c);
    }

    /**
     * Modifica a área do limite
     *
     * @param area
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * 
     * Adiciona abertura ao limite
     * 
     * @param a 
     */
    public void addAbertura(Abertu a) {
        listaAberturas.add(a);
    }

    /**
     * 
     * Retorna os dados do limite
     * 
     * @return 
     */
    @Override
    public String toString() {
        return getTipo() + " | " + String.format("%1$,.2f", getAltura()) + " | " + String.format("%1$,.2f", getLargura());
    }


}
