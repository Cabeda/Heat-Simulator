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
public class Aluminio {
     //Medida em c/J KG K
    private final double capTermica;
    private final String nome;
    public Aluminio() {
        nome="Alumínio";
        capTermica= 900;
    }

    public double getCapTermica() {
        return capTermica;
    }

    public String getNome() {
        return nome;
    }   
}
