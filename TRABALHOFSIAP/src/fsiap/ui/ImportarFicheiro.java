/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsiap.ui;

import java.io.File;
import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import trabalhofsiap.SimController;

/**
 *
 * @author Antonio Pinheiro
 */
public class ImportarFicheiro {

    private SimController dc;
    ResourceBundle mensagens;
    public ImportarFicheiro(JFrame pai,SimController d) {
        
        try {

            this.dc = d;
            mensagens = this.dc.getMensagens();
            File selectedFile = null;

            do {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                    fileChooser.setApproveButtonText(mensagens.getString("selecionar"));
                    fileChooser.setApproveButtonToolTipText(mensagens.getString("selecionarFicheiro"));
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile != null) {
                        if (selectedFile.exists()) {
                            if (selectedFile.getName().contains(".bin")) {
                                dc.introduzirDados(selectedFile);
                                pai.dispose();
                                JanelaSimu js = new JanelaSimu(mensagens.getString("janelaSimuTitulo"),null, dc);
                            } else {
                                    JOptionPane.showMessageDialog(fileChooser, mensagens.getString("selecionarFicheiroInv"), mensagens.getString("importarFich"), JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                                JOptionPane.showMessageDialog(fileChooser, mensagens.getString("selecionarFicheiroNexiste"), mensagens.getString("importarFich"), JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            } while (!selectedFile.exists() || !selectedFile.getName().contains(".bin"));
        } catch (NullPointerException p) {
            System.out.println("Saiu JFileChooser");
        }
    }
}
