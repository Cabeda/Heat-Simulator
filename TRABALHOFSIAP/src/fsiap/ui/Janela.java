/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsiap.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author i130348
 */
public class Janela extends JFrame {

    /**
     * Fechar (S/N)
     */
    private String fechar = "nao";

    /**
     * A Posição da janela.
     */
    private static final int JANELA_POSICAO_X = 700, JANELA_POSICAO_Y = 200;

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
        GridLayout gl = new GridLayout(2, 1);
        setLayout(gl);

        add(criarTexto());
        add(criarButtonOK());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fechar();
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(450, 230);
        setResizable(false);
        setLocation(JANELA_POSICAO_X, JANELA_POSICAO_Y);
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
        JMenu jm = new JMenu("Candeeiros");
        jm.add(criarItemVerCandeeiros());
        menu.add(jm);
        JMenu jm2 = new JMenu("Empresas");
        menu.add(jm2);
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
     * Criar item Ver Candeeiros
     *
     * @return item
     */
    private JMenuItem criarItemVerCandeeiros() {
        JMenuItem item = new JMenuItem("Ver Candeeiros", KeyEvent.VK_V);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        return item;
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
        JButton bu = new JButton("OK");
        bu.setSize(10, 5);
        jp2.add(bu, BorderLayout.CENTER);
        
        bu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

        return jp2;
    }
    
    private JPanel criarTexto() {
        
        JPanel jp = new JPanel();

        JLabel jl = new JLabel("     Deverá inserir as diferentes características do seu ambiente", SwingConstants.CENTER);
        JLabel jl2 = new JLabel("           para ser calculada a capacidade recomendada para");
        JLabel jl3 = new JLabel("       o seu ar condicionado.");

        jp.add(jl);
        jp.add(jl2);
        jp.add(jl3);
     
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
