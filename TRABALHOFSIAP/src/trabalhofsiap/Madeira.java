/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

import java.io.Serializable;

/**
 *
 * @author Jecabeda
 */
public class Madeira extends Material implements Serializable{

    private SimController dc;

    //Medida em c/J KG K
    public Madeira(SimController d) {
        super(2330, "Madeira");
        this.dc = d;
    }

    public String getNome() {
        if (dc.getLinguagem() == 1) {
            return "Wood";
        } else {
            return "Madeira";
        }

    }

}
