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

/**
 * 
 * Objeto vidro
 * 
 */
public class Vidro extends Material implements Serializable{


    
    /**
     *
     * Retorna a condutividade térmica [K] = W·m-1·K-1 (J·s-1·m-1·K-1)
     *
     * @param mens
     */
    public Vidro(ResourceBundle mens) {
        super(0.79,mens.getString("vidro"),mens);
        this.mensagens=mens;
    }
        
    /**
     * 
     * Devolve o nome do material
     * 
     * @return 
     */
    @Override
     public String getNome() {
        return mensagens.getString("vidro");

    }

}
