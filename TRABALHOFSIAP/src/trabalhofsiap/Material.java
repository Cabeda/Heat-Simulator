/*
 TRABALHO DE FÍSICA
 António Pinheiro 1130339
 Cristina Lopes 1130371
 Egídio Santos 1130348
 José Cabeda 1130395
 */
package trabalhofsiap;

import java.io.Serializable;
import java.util.ResourceBundle;

/**
 *
 * Classe pai de todos os materiais
 *
 */
public class Material implements Serializable {

    /**
     * Para calcular a Resistência Térmica é necessário a condutibilidade
     * Térmica do material
     */
    private double condutibilidadeTermica;

    //Variável do nome do material
    private final String nome;

    //Inicialização das mensagens do programa
    protected transient ResourceBundle mensagens;

    /**
     *
     * Construor material
     *
     * @param condutibilidadeTermica
     * @param nome
     * @param mens
     */
    public Material(double condutibilidadeTermica, String nome, ResourceBundle mens) {
        this.condutibilidadeTermica = condutibilidadeTermica;
        this.nome = nome;
        this.mensagens = mens;
    }

    /**
     *
     * Construtor vazio
     *
     */
    public Material() {
        this.condutibilidadeTermica = 0;
        this.nome = "sem nome";
    }

    /**
     *
     * Retorna a condutibilidade térmica do material
     *
     * @return
     */
    public double getCondutibilidadeTermica() {
        return condutibilidadeTermica;
    }

    /**
     *
     * Retorna o nome do material
     *
     * @return
     */
    public String getNome() {
        return nome;
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
}
