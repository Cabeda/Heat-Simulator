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
 * Objeto ar
 *
 */
public class Ar extends Material implements Serializable {

    /**
     *
     * Retorna a condutividade térmica [K] = W·m-1·K-1 (J·s-1·m-1·K-1)
     *
     * @param mens
     */
    public Ar(ResourceBundle mens) {
        super(0.03, mens.getString("ar"), mens);
        this.mensagens = mens;
    }

    /**
     *
     * Retorna o nome do material
     *
     * @return
     */
    public String getNome() {
        return mensagens.getString("ar");
    }

}
