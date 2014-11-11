/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsiap.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import trabalhofsiap.SimController;

/**
 *
 * @author egidio
 */
public class JanelaSelLing extends JFrame {

    private String fechar = "nao";
    private Dimension TXT_TAMANHO = new Dimension(585, 400);
    private SimController dc;
    String pais, lingua;
    Locale currentLocale;

    /**
     * Cria a Janela com o menu.
     *
     * @throws IOException
     */
    public JanelaSelLing() throws IOException {

        super("Select Language");
        this.dc = new SimController();

        BorderLayout gl = new BorderLayout();
        setLayout(gl);

        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(criarButtonPT());
        buttons.add(criarButtonEN());
        add(buttons, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fechar();
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(400, 100);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private JPanel criarButtonEN() {

        JPanel jp2 = new JPanel();
        Icon iconUk = new ImageIcon("uk.png");
        JButton bu = new JButton("English", iconUk);
        bu.setSize(10, 5);
        jp2.add(bu, BorderLayout.CENTER);

        bu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lingua = new String("en");
                pais = new String("EN");
                currentLocale = new Locale(lingua, pais);
                dc.setMensagens(currentLocale);
                dc.criarListaMaterial();
                try {
                    Janela jd = new Janela(dc);
                } catch (IOException ex) {
                    Logger.getLogger(JanelaSelLing.class.getName()).log(Level.SEVERE, null, ex);
                }
                JanelaSelLing.this.dispose();
            }
        });

        return jp2;
    }

    private JPanel criarButtonPT() {

        JPanel jp2 = new JPanel();
        Icon iconPt = new ImageIcon("pt.png");
        JButton bu = new JButton("Português", iconPt);

        bu.setSize(
                10, 5);
        jp2.add(bu, BorderLayout.CENTER);

        bu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        lingua = new String("pt");
                        pais = new String("PT");
                        currentLocale = new Locale(lingua, pais);
                        dc.setMensagens(currentLocale);
                        dc.criarListaMaterial();
                        try {
                            Janela jd = new Janela(dc);
                        } catch (IOException ex) {
                            Logger.getLogger(JanelaSelLing.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JanelaSelLing.this.dispose();
                    }
                }
        );

        return jp2;
    }

    /**
     * Opção para perguntar se deseja fechar a aplicação.
     */
    private void fechar() {
        String[] opSimNao = {"Yes", "No"};
        int resposta = JOptionPane.showOptionDialog(this,
                "Do you wish to close the program?",
                "FSIAP",
                0,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opSimNao,
                opSimNao[1]);

        final int SIM = 0;
        if (resposta == SIM) {
            dispose();
        }
        fechar = "sim";
    }

}
