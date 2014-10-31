/*
TRABALHO DE FÍSICA
António Pinheiro 1130339
Cristina Lopes 1130371
Egídio Santos 1130348
José Cabeda 1130395
 */
package trabalhofsiap;

import java.io.Serializable;

public class Aluminio extends Material implements Serializable{
       
    private SimController dc;
    
    //[K] = W·m-1·K-1 (J·s-1·m-1·K-1)
    public Aluminio(SimController d) {
        super( 237, "Aluminio");
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
