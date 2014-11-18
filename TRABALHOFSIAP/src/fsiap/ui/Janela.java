/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsiap.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Locale;
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

    private String fechar = "nao";
    private Dimension TXT_TAMANHO = new Dimension(585, 400);
    private SimController dc;
    String pais, lingua;
    Locale currentLocale;

    /**
     * Cria a Janela com o menu.
     *
     * @param d
     * @throws IOException
     */
    public Janela(SimController d) throws IOException {

        super(d.getMensagens().getString("janelaSimuTitulo"));
        this.dc = d;       
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(criarMenu());
        menuBar.add(criarAcerca());

        BorderLayout gl = new BorderLayout();
        setLayout(gl);

        add(criarTexto(), BorderLayout.NORTH);
        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(criarButtonComecar());
        add(buttons, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fechar();
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(570,165);
        setResizable(true);
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
        menu.add(importFich());
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
        JMenu menu = new JMenu(dc.getMensagens().getString("acerca"));
        menu.setMnemonic(KeyEvent.VK_A);

        menu.add(dc.getMensagens().getString("trabalhoreal")).setEnabled(false);
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
        JMenuItem item = new JMenuItem(dc.getMensagens().getString("sair"), KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

        return item;
    }

    private JMenuItem importFich() {
        JMenuItem item = new JMenuItem(dc.getMensagens().getString("importarFich"), KeyEvent.VK_F);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImportarFicheiro i = new ImportarFicheiro(Janela.this, dc);
            }
        });

        return item;
    }

    private JPanel criarTexto() {

        JPanel jp = new JPanel();
        
        JTextArea jt = new JTextArea(dc.getMensagens().getString("texto"));
        jt.setSize(400, 50);
        jt.setEditable(false);
        jt.setLineWrap(true);

        jp.add(jt);

        return jp;
    }

    private JPanel criarButtonComecar() {

        JPanel jp2 = new JPanel();
        JButton bu = new JButton(dc.getMensagens().getString("comecar"));
        bu.setSize(10, 5);
        jp2.add(bu, BorderLayout.CENTER);

        bu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dc.criarListaMaterial();
                JanelaSimu jd = new JanelaSimu(dc.getMensagens().getString("janelaSimuTitulo"), null, dc);
                Janela.this.dispose();
            }
        });

        return jp2;
    }

    /**
     * Opção para perguntar se deseja fechar a aplicação.
     */
    private void fechar() {
        String[] opSimNao = {dc.getMensagens().getString("sim"), dc.getMensagens().getString("nao")};
        int resposta = JOptionPane.showOptionDialog(this,
                dc.getMensagens().getString("fecharPrograma"),
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
        fechar = dc.getMensagens().getString("sim");
    }

}
