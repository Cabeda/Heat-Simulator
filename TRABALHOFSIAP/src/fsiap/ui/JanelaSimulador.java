/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsiap.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author i130348
 */
public class JanelaSimulador extends JDialog {

    /**
     * Fechar (S/N)
     */
    private String fechar = "nao";
    private Dimension LABEL_TAMANHO2 = new JLabel("Dimensóes do ambiente ").getPreferredSize();
    private Dimension Campo2_TAMANHO = new Dimension(250, 20);
    private Dimension Campo3_TAMANHO = new Dimension(250, 40);
    private Dimension Scroll_TAMANHO = new Dimension(250, 90);
    private Dimension BTN_TAMANHO = new Dimension(200, 40);

    private JTabbedPane jt = new JTabbedPane();

    public JanelaSimulador(JFrame pai) {

        super(pai, "Capacidade Térmica de uma Sala de Computadores");

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        getContentPane().add(jp);

        //ImageIcon icon = createImageIcon("images/middle.gif");
        jt.addTab("Dimensões", panel1());

        jt.addTab("Aberturas", panel2());

        jt.addTab("Cobertura", panel3());

        jt.addTab("Iluminação", panel4());

        jt.addTab("Pessoas", panel5());

        jt.addTab("Aparelhos", panel6());

        jt.addTab("Temperatura", panel7());

        jt.addTab("Resultado", panel8());
        jt.repaint();

        jp.add(jt);
        jt.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        jt.repaint();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fechar();
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(670, 290);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    protected JPanel panel1() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JLabel label0 = new JLabel("Dimensóes do ambiente", JLabel.CENTER);
        label0.setPreferredSize(LABEL_TAMANHO2);
        panel0.add(label0);

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Comprimento:", JLabel.RIGHT);
        label1.setPreferredSize(LABEL_TAMANHO2);
        JTextField field1 = new JTextField();
        field1.setPreferredSize(Campo2_TAMANHO);
        panel1.add(label1);
        panel1.add(field1);

        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Largura:", JLabel.RIGHT);
        label2.setPreferredSize(LABEL_TAMANHO2);
        JTextField field2 = new JTextField();
        field2.setPreferredSize(Campo2_TAMANHO);
        panel2.add(label2);
        panel2.add(field2);

        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel("Altura:", JLabel.RIGHT);
        label3.setPreferredSize(LABEL_TAMANHO2);
        JTextField field3 = new JTextField();
        field3.setPreferredSize(Campo2_TAMANHO);
        panel3.add(label3);
        panel3.add(field3);

        JPanel panel4 = new JPanel();
        JLabel label4 = new JLabel("Area:", JLabel.RIGHT);
        label4.setPreferredSize(LABEL_TAMANHO2);
        JTextField field4 = new JTextField();
        field4.setPreferredSize(Campo2_TAMANHO);
        field4.setEditable(false);
        panel4.add(label4);
        panel4.add(field4);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setSelectedIndex(1);
            }
        }
        );
        btnMoveRight1.setPreferredSize(Campo2_TAMANHO);
        panel5.add(btnMoveRight1);

        panel.add(panel0, BorderLayout.NORTH);
        grid.add(panel1);
        grid.add(panel2);
        grid.add(panel3);
        grid.add(panel4);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);
        return panel;
    }

    protected JPanel panel2() {

        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        JPanel center = new JPanel(new BorderLayout());
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Aberturas ", JLabel.CENTER);
        label1.setPreferredSize(LABEL_TAMANHO2);
        panel1.add(label1);

        JPanel panel2 = new JPanel();
        JScrollPane pdados = new JScrollPane();
        pdados.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        pdados.setPreferredSize(Scroll_TAMANHO);
        panel2.add(pdados);

        JPanel panel3 = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        );
        btnAdicionar.setPreferredSize(Campo2_TAMANHO);
        panel3.add(btnAdicionar);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setSelectedIndex(2);
            }
        }
        );
        btnMoveRight1.setPreferredSize(Campo2_TAMANHO);
        panel5.add(btnMoveRight1);

        panel.add(panel1, BorderLayout.NORTH);
        center.add(panel2, BorderLayout.CENTER);
        center.add(panel3, BorderLayout.SOUTH);
        grid.add(center);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);
        return panel;
    }

    protected JPanel panel3() {

        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        JPanel center = new JPanel(new BorderLayout());
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Cobertura ", JLabel.CENTER);
        label1.setPreferredSize(LABEL_TAMANHO2);
        panel1.add(label1);

        JPanel panel2 = new JPanel();
        JScrollPane pdados = new JScrollPane();
        pdados.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        pdados.setPreferredSize(Scroll_TAMANHO);
        panel2.add(pdados);

        JPanel panel3 = new JPanel();
        JButton btnAdicionar = new JButton("Definir");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        );
        btnAdicionar.setPreferredSize(Campo2_TAMANHO);
        panel3.add(btnAdicionar);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setSelectedIndex(3);
            }
        }
        );
        btnMoveRight1.setPreferredSize(Campo2_TAMANHO);
        panel5.add(btnMoveRight1);

        panel.add(panel1, BorderLayout.NORTH);
        center.add(panel2, BorderLayout.CENTER);
        center.add(panel3, BorderLayout.SOUTH);
        grid.add(center);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);
        return panel;
    }

    protected JPanel panel4() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6, 1));
        JLabel lbl1 = new JLabel();

        p1.add(lbl1);
        return p1;
    }

    protected JPanel panel5() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6, 1));
        JLabel lbl1 = new JLabel();
        lbl1.add(new JTextField("Dimensiões do Ambiente"));

        p1.add(lbl1);
        return p1;
    }

    protected JPanel panel6() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6, 1));
        JLabel lbl1 = new JLabel();
        lbl1.add(new JTextField("Dimensiões do Ambiente"));

        p1.add(lbl1);
        return p1;
    }

    protected JPanel panel7() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6, 1));
        JLabel lbl1 = new JLabel();
        lbl1.add(new JTextField("Dimensiões do Ambiente"));

        p1.add(lbl1);
        return p1;
    }

    protected JPanel panel8() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6, 1));
        JLabel lbl1 = new JLabel();
        lbl1.add(new JTextField("Dimensiões do Ambiente"));

        p1.add(lbl1);
        return p1;
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
