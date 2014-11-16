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

public class Betao extends Material implements Serializable{


        
    //[K] = W·m-1·K-1 (J·s-1·m-1·K-1)
    public Betao(ResourceBundle mens) {
        super(1.7, mens.getString("betao"),mens);
        this.mensagens=mens;
    }
    
    public String getNome() {
         return mensagens.getString("betao");
    }

}
