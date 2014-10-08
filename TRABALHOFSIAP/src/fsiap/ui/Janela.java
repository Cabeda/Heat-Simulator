/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsiap.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import trabalhofsiap.SimController;

/**
 *
 * @author i130348
 */
public class Janela extends JFrame {

    /**
     * Fechar (S/N)
     */
    private String fechar = "nao";

    private Dimension TXT_TAMANHO = new Dimension(585,400);

    /**
     * Cria a Janela com o menu.
     *
     * @throws IOException
     */
    public Janela() throws IOException {

        super("Capacidade Térmica de uma Sala de Computadores");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(criarMenu());
        menuBar.add(criarAcerca());

        //ImageIcon i = new ImageIcon("xxxxxxx.jpg");
        //add(new JLabel(i));
        BorderLayout gl = new BorderLayout();
        setLayout(gl);

        add(new JLabel(" "), BorderLayout.NORTH);
        add(criarTexto(), BorderLayout.CENTER);
        add(criarButtonOK(), BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fechar();
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(585, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    /**
     * Cria o menu.
     *
     * @return Menu.
     * @throws IOException
     */
    private JMenu criarMenu() throws IOException {
        final JMenu menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_M);
        
        menu.addSeparator();
        menu.add(criarItemSair());
        return menu;
    }

    /**
     * Criar o menu Acerca.
     *
     * @return menu
     */
    private JMenu criarAcerca() {
        JMenu menu = new JMenu("Acerca");
        menu.setMnemonic(KeyEvent.VK_A);

        menu.add("Trabalho de FSIAP realizado por:").setEnabled(false);
        menu.add("António Pinheiro - 1130339").setEnabled(false);
        menu.add("Cristina Lopes - 1130371").setEnabled(false);
        menu.add("Egídio Santos - 1130348").setEnabled(false);
        menu.add("José Cabeda - 1130395").setEnabled(false);

        return menu;
    }

    /**
     * Criar item Sair
     *
     * @return item
     */
    private JMenuItem criarItemSair() {
        JMenuItem item = new JMenuItem("Sair", KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

        return item;
    }

    private JPanel criarButtonOK() {
        
        JPanel jp2 = new JPanel();
        JButton bu = new JButton("Começar");
        bu.setSize(10, 5);
        jp2.add(bu, BorderLayout.CENTER);
        
        bu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimController dc = new SimController();
                JanelaSimu jd = new JanelaSimu(null,dc);
                Janela.this.dispose();
            }
        });

        return jp2;
    }
    
    private JPanel criarTexto() {
        
        JPanel jp = new JPanel();
        
        JTextArea jt = new JTextArea("  Deverá inserir as diferentes características do seu\n   ambiente para ser calculada a capacidade recomendada parao seu ar condicionado.");
        jt.setEditable(false);
        jt.setLineWrap(true);
        jt.setPreferredSize(TXT_TAMANHO);
        
        jp.add(jt);
     
        return jp;
    }

    /**
     * Opção para perguntar se deseja fechar a aplicação.
     */
    private void fechar() {
        String[] opSimNao = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this,
                "Deseja fechar a aplicação?",
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
