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
public class Material {
    private double capTermica;
    private final String nome;

    public Material(double capTermica, String nome) {
        this.capTermica = capTermica;
        this.nome = nome;
    }

    public Material() {
        this.capTermica=0;
        this.nome="sem nome";
    }

    public double getCapTermica() {
        return capTermica;
    }

    public String getNome() {
        return nome;
    }
    
    
    

}
