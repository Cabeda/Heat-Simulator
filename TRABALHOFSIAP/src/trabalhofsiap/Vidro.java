/*
TRABALHO DE FÍSICA
António Pinheiro 1130339
Cristina Lopes 1130371
Egídio Santos 1130348
José Cabeda 1130395
 */
package trabalhofsiap;

import java.io.Serializable;

public class Vidro extends Material implements Serializable{

    private SimController dc;
    
    //[K] = W·m-1·K-1 (J·s-1·m-1·K-1)
    public Vidro(SimController dc) {
        super(0.79,dc.getMensagens().getString("vidro"));
        this.dc=dc;
    }
        
     public String getNome() {
        return dc.getMensagens().getString("vidro");

    }

    
}
