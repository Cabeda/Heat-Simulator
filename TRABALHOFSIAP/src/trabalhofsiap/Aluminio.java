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
public class Aluminio extends Material {
     //Medida em c/J KG K
    
    private SimController dc;
    
    public Aluminio(SimController d) {
        super( 900, "Aluminio");
        this.dc=d;
    }
    
     public String getNome() {
        if (dc.getLinguagem() == 1) {
            return "Aluminum";
        } else {
            return "Aluminio";
        }

    }


    
}
