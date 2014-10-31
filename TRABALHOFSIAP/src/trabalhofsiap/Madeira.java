/*
TRABALHO DE FÍSICA
António Pinheiro 1130339
Cristina Lopes 1130371
Egídio Santos 1130348
José Cabeda 1130395
 */
package trabalhofsiap;

import java.io.Serializable;

public class Madeira extends Material implements Serializable{

    private SimController dc;

    //[K] = W·m-1·K-1 (J·s-1·m-1·K-1)
    public Madeira(SimController d) {
        super(0.13, "Madeira");
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
