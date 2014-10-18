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
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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

    public String lingua = "";

    private String fechar = "nao";
    private Dimension TXT_TAMANHO = new Dimension(585, 400);
    private SimController dc = new SimController();

    /**
     * Cria a Janela com o menu.
     *
     * @throws IOException
     */
    public Janela() throws IOException {

        super("Capacidade Térmica de uma Sala de Computadores/Heat Capacity of a Computer Room");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(criarMenu());
        menuBar.add(criarAcerca());

        BorderLayout gl = new BorderLayout();
        setLayout(gl);

        add(criarTexto(), BorderLayout.NORTH);
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
        JMenu menu = new JMenu("Acerca/About");
        menu.setMnemonic(KeyEvent.VK_A);

        menu.add("Trabalho de FSIAP realizado por : /Project made by :").setEnabled(false);
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
        JMenuItem item = new JMenuItem("Sair/Exit", KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

        return item;
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
                dc.setLinguagem(1);
                JanelaSimu jd = new JanelaSimu(null,dc);
                Janela.this.dispose();
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
                        dc.setLinguagem(2);
                        JanelaSimu jd = new JanelaSimu(null,dc);
                        Janela.this.dispose();
                    }
                }
        );

        return jp2;
    }

    private JPanel criarTexto() {

        JPanel jp = new JPanel();

        JTextArea jt = new JTextArea(" Deverá inserir as diferentes características do seu ambiente para ser calculada a capacidade\n recomendada para o seu ar condicionado.\n"
                + " You must insert different features of your environment to calculate the recommended capacity of your\n air conditioning.");
        jt.setSize(580, 75);
        jt.setEditable(false);
        jt.setLineWrap(true);

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
