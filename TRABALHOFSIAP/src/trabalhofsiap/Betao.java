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
public class Betao {
    private final double capTermica;
    private final String nome;

       //Medida em c/J KG K (a 25ºC)

    public Betao() {
        this.capTermica =3350;
        this.nome="Betão";
    }

    public double getCapTermica() {
        return capTermica;
    }

    public String getNome() {
        return nome;
    }
    
    
}