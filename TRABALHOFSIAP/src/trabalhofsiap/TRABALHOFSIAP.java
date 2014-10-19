/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

import fsiap.ui.Janela;
import fsiap.ui.JanelaSimu;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author i130348
 */
public class TRABALHOFSIAP {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        File d = new File("dados.bin");
        if (d.exists()) {
            SimController dc = new SimController();
            dc.introduzirDados();
            JanelaSimu js = new JanelaSimu(null, dc);
        } else {

            Janela jan = new Janela();
        }
    }

}
