/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

import fsiap.ui.Janela;
import fsiap.ui.JanelaSimu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author i130348
 */
public class TRABALHOFSIAP {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
        int resposta = 0;

        String[] opSimNao = {"Sim", "Não"};
        resposta = JOptionPane.showOptionDialog(null, "Iniciar através de ficheiro .bin?", "FSIAP", 0, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1]);

        final int SIM = 0;
        if (resposta == SIM) {

            File d = new File("dados.bin");
            if (d.exists()) {
                SimController dc = new SimController();
                dc.introduzirDados();
                JanelaSimu js = new JanelaSimu(null, dc);
            } else {
                JOptionPane.showMessageDialog(null, "Ficheiro Binário não encontrado", "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                Janela jan = new Janela();
            }
        } else {
            Janela jan = new Janela();
        }

    }
    
    

}
