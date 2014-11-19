/*
 TRABALHO DE FÍSICA
 António Pinheiro 1130339
 Cristina Lopes 1130371
 Egídio Santos 1130348
 José Cabeda 1130395
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
 * Classe para importar ficheiro binário criado anteriormente
 * 
 */
public class ImportarFicheiro {

    //Inicialização do controller do programa
    private SimController dc;
    
    //Inicialização das mensagens do programa
    ResourceBundle mensagens;
    
    /**
     * 
     * Método para importar ficheiro binário 
     * 
     * @param pai
     * @param d 
     */
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
