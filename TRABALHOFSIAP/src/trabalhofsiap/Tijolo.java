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

public class Tijolo extends Material implements Serializable{


    //[K] = W·m-1·K-1 (J·s-1·m-1·K-1)
    public Tijolo(ResourceBundle mens) {
        super(0.6,mens.getString("tijolo"),mens);
       this.mensagens=mens;
    }

    public String getNome() {
         return mensagens.getString("tijolo");
}

}
