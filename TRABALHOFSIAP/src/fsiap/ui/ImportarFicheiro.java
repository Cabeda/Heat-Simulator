/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsiap.ui;

import java.io.File;
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

    public ImportarFicheiro(JFrame pai,SimController d) {

        try {

            this.dc = d;

            File selectedFile = null;

            do {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (dc.getLinguagem() == 1) {
                    fileChooser.setApproveButtonText("Select");
                    fileChooser.setApproveButtonToolTipText("Select the file to import");
                } else {
                    fileChooser.setApproveButtonText("Selecionar");
                    fileChooser.setApproveButtonToolTipText("Select the file to import");
                }
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile != null) {
                        if (selectedFile.exists()) {
                            if (selectedFile.getName().contains(".bin")) {
                                dc.introduzirDados(selectedFile);
                                pai.dispose();
                                JanelaSimu js = new JanelaSimu(null, dc);
                            } else {
                                if (dc.getLinguagem() == 1) {
                                    JOptionPane.showMessageDialog(fileChooser, "The Selected File is invalid", "Import File", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(fileChooser, "O ficheiro selecionado é inválido", "Importar Ficheiro", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        } else {
                            if (dc.getLinguagem() == 1) {
                                JOptionPane.showMessageDialog(fileChooser, "The Selected File doesn't exist!", "Import File", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(fileChooser, "O ficheiro selecionado não existe!", "Importar Ficheiro", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                }
            } while (!selectedFile.exists() || !selectedFile.getName().contains(".bin"));
        } catch (NullPointerException p) {
            System.out.println("Saiu JFileChooser");
        }
    }
}
