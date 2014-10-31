/*
TRABALHO DE FÍSICA
António Pinheiro 1130339
Cristina Lopes 1130371
Egídio Santos 1130348
José Cabeda 1130395
 */
package trabalhofsiap;

import java.io.Serializable;

public class Material implements Serializable{
    
    /**
     * Para calcular a Resistência Térmica é necessário a condutibilidade Térmica do material
     */
    private double condutibilidadeTermica;
    private final String nome;

    public Material(double condutibilidadeTermica, String nome) {
        this.condutibilidadeTermica = condutibilidadeTermica;
        this.nome = nome;
    }

    public Material() {
        this.condutibilidadeTermica=0;
        this.nome="sem nome";
    }

    public double getCondutibilidadeTermica() {
        return condutibilidadeTermica;
    }

    public String getNome() {
        return nome;
    }
}
