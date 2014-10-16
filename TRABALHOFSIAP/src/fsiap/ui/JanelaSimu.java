/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsiap.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import trabalhofsiap.Abertu;
import trabalhofsiap.Limite;
import trabalhofsiap.SimController;

/**
 *
 * @author i130348
 */
public class JanelaSimu extends JDialog {

    private List<Limite> listaLim = new ArrayList();
    private List<Abertu> listaAber = new ArrayList();
    /**
     * Fechar (S/N)
     */
    public Icon icon = new ImageIcon("icon_device_settings.gif");
    private String fechar = "nao";
    private String resultado = "";
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private Dimension LABEL_TAMANHO2 = new JLabel("Temperatura pretendida na sala ").getPreferredSize();
    private Dimension CAMPO_TAMANHO = new Dimension(200, 20);
    private Dimension SCROLL_TAMANHO = new Dimension(200, 100);
    private Dimension RESULTADO_TAMANHO = new Dimension(300, 70);
    private Dimension BTN_TAMANHO = new Dimension(70, 40);

    private JTextField field4;
    private SimController dc = new SimController();

    public JPanel jpanel2, jpanel3;

    private JTabbedPane jt = new JTabbedPane();

    public JanelaSimu(JFrame pai) {

        super(pai, "Capacidade Térmica de uma Sala de Computadores");

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        getContentPane().add(jp);

        jt.addTab("Dimensões", panel1());

        jt.addTab("Limites", panel5());

        jt.addTab("Aberturas", panel2());

        jt.addTab("Pessoas", panel3());

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
        setSize(585, 400);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    protected JPanel panel1() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JLabel label0 = new JLabel("Dimensões do ambiente", JLabel.CENTER);
        label0.setPreferredSize(LABEL_TAMANHO2);
        panel0.add(label0);

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Comprimento:", JLabel.RIGHT);
        JLabel l1 = new JLabel("m", JLabel.LEFT);
        label1.setPreferredSize(LABEL_TAMANHO2);
        field1 = new JTextField();
        field1.setPreferredSize(CAMPO_TAMANHO);
        field1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!field1.getText().equals("") && !field2.getText().equals("") && !field3.getText().equals("")) {
                    dc.setAltura((Float.parseFloat(field3.getText())));
                    dc.setComprimento((Float.parseFloat(field1.getText())));
                    dc.setLargura((Float.parseFloat(field2.getText())));
                    dc.setAreaTotal();
                    field4.setText(Float.toString(dc.getAreaTotal()));
                    revalidate();
                }
                revalidate();
            }
        });
        panel1.add(label1);
        panel1.add(field1);
        panel1.add(l1);

        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Largura:", JLabel.RIGHT);
        JLabel l2 = new JLabel("m", JLabel.LEFT);
        label2.setPreferredSize(LABEL_TAMANHO2);
        field2 = new JTextField();
        field2.setPreferredSize(CAMPO_TAMANHO);
        field2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!field1.getText().equals("") && !field2.getText().equals("") && !field3.getText().equals("")) {
                    dc.setAltura((Float.parseFloat(field3.getText())));
                    dc.setComprimento((Float.parseFloat(field1.getText())));
                    dc.setLargura((Float.parseFloat(field2.getText())));
                    dc.setAreaTotal();
                    field4.setText(Float.toString(dc.getAreaTotal()));
                    revalidate();
                }
                revalidate();
            }
        });

        panel2.add(label2);
        panel2.add(field2);
        panel2.add(l2);

        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel("Altura:", JLabel.RIGHT);
        JLabel l3 = new JLabel("m", JLabel.LEFT);
        label3.setPreferredSize(LABEL_TAMANHO2);
        field3 = new JTextField();
        field3.setPreferredSize(CAMPO_TAMANHO);
        field3.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!field1.getText().equals("") && !field2.getText().equals("") && !field3.getText().equals("")) {
                    dc.setAltura((Float.parseFloat(field3.getText())));
                    dc.setComprimento((Float.parseFloat(field1.getText())));
                    dc.setLargura((Float.parseFloat(field2.getText())));
                    dc.setAreaTotal();
                    field4.setText(Float.toString(dc.getAreaTotal()));
                    revalidate();
                }
                revalidate();
            }
        });

        panel3.add(label3);
        panel3.add(field3);
        panel3.add(l3);

        JPanel panel4 = new JPanel();
        JLabel label4 = new JLabel("Area Total:", JLabel.RIGHT);
        JLabel l4 = new JLabel("m²", JLabel.LEFT);
        label4.setPreferredSize(LABEL_TAMANHO2);
        field4 = new JTextField();
        field4.setPreferredSize(CAMPO_TAMANHO);
        field4.setEditable(false);

        panel4.add(label4);
        panel4.add(field4);
        panel4.add(l4);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setSelectedIndex(1);
            }
        }
        );
        btnMoveRight1.setPreferredSize(CAMPO_TAMANHO);
        btnMoveRight1.setAlignmentX(RIGHT_ALIGNMENT);
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

        JPanel panel1 = new JPanel(new BorderLayout());
        JLabel label1 = new JLabel("Aberturas ", JLabel.CENTER);
        label1.setPreferredSize(LABEL_TAMANHO2);
        panel1.add(label1, BorderLayout.NORTH);

        jpanel2 = new JPanel();
        jpanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //jpanel2.setPreferredSize(new Dimension(50,100));

        final JScrollPane scroll = new JScrollPane(jpanel2);
        scroll.setPreferredSize(SCROLL_TAMANHO);

        panel1.add(scroll, BorderLayout.SOUTH);

        JPanel panel3 = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JanelaAber ja = new JanelaAber(dc, JanelaSimu.this, true, 0);
                revalidate();
                jpanel2.revalidate();
                scroll.revalidate();
                panel1.revalidate();
            }
        });

        btnAdicionar.setPreferredSize(CAMPO_TAMANHO);
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
        btnMoveRight1.setPreferredSize(CAMPO_TAMANHO);
        panel5.add(btnMoveRight1);

        panel.add(panel1, BorderLayout.NORTH);
        center.add(panel3, BorderLayout.SOUTH);
        grid.add(center);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);
        return panel;
    }

    protected JPanel panel3() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JLabel label0 = new JLabel("Pessoas ", JLabel.CENTER);
        label0.setPreferredSize(LABEL_TAMANHO2);
        panel0.add(label0);

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Nº de Pessoas:", JLabel.RIGHT);

        String vec[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
            "13", "14", "15", "16", "17", "18", "19", "20", "21"};
        label1.setPreferredSize(LABEL_TAMANHO2);
        JComboBox field1 = new JComboBox(vec);
        field1.setPreferredSize(CAMPO_TAMANHO);
        panel1.add(label1);
        panel1.add(field1);

        JPanel panel4 = new JPanel();
        JButton btnAdicionar = new JButton("Confirmar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dc.setNumPessoas(Integer.valueOf((String) field1.getSelectedItem()));
            }
        }
        );
        btnAdicionar.setPreferredSize(CAMPO_TAMANHO);
        panel4.add(btnAdicionar);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setSelectedIndex(4);
            }
        }
        );
        btnMoveRight1.setPreferredSize(CAMPO_TAMANHO);
        btnMoveRight1.setAlignmentX(RIGHT_ALIGNMENT);
        panel5.add(btnMoveRight1);

        panel.add(panel0, BorderLayout.NORTH);
        grid.add(panel1);
        grid.add(btnAdicionar);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);
        return panel;

    }

    protected JPanel panel5() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        JPanel center = new JPanel(new BorderLayout());
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel1 = new JPanel(new BorderLayout());
        JLabel label1 = new JLabel("Limites da sala ", JLabel.CENTER);
        label1.setPreferredSize(LABEL_TAMANHO2);
        panel1.add(label1, BorderLayout.NORTH);

        jpanel3 = new JPanel();
        jpanel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //jpanel2.setPreferredSize(new Dimension(50,100));

        final JScrollPane scroll = new JScrollPane(jpanel3);
        scroll.setPreferredSize(SCROLL_TAMANHO);

        panel1.add(scroll, BorderLayout.SOUTH);

        JPanel panel3 = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JanelaLim ja = new JanelaLim(dc, JanelaSimu.this, true, 0);
                revalidate();
                jpanel3.revalidate();
                scroll.revalidate();
                panel1.revalidate();
            }
        });

        btnAdicionar.setPreferredSize(CAMPO_TAMANHO);
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
        btnMoveRight1.setPreferredSize(CAMPO_TAMANHO);
        panel5.add(btnMoveRight1);

        panel.add(panel1, BorderLayout.NORTH);
        center.add(panel3, BorderLayout.SOUTH);
        grid.add(center);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);
        return panel;
    }

    protected JPanel panel6() {

        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JLabel label0 = new JLabel("Aparelhos na sala ", JLabel.CENTER);
        label0.setPreferredSize(LABEL_TAMANHO2);
        panel0.add(label0);

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Nº de aparelhos:", JLabel.RIGHT);
        JLabel l1 = new JLabel("      ");
        JTextField field1 = new JTextField();
        field1.setPreferredSize(CAMPO_TAMANHO);
        label1.setPreferredSize(LABEL_TAMANHO2);
        panel1.add(label1);
        panel1.add(field1);
        panel1.add(l1);

        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Potência média:", JLabel.RIGHT);
        JLabel l2 = new JLabel("Wh");
        label2.setPreferredSize(LABEL_TAMANHO2);
        JTextField field2 = new JTextField();
        field2.setPreferredSize(CAMPO_TAMANHO);

        panel2.add(label2);
        panel2.add(field2);
        panel2.add(l2);

        JPanel panelConf = new JPanel();
        JButton btnAdicionar = new JButton("Confirmar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dc.setNumAparelhos((Integer.parseInt(field1.getText())));
                dc.setPotenciaMedia((Integer.parseInt(field1.getText())));

            }
        }
        );
        btnAdicionar.setPreferredSize(CAMPO_TAMANHO);
        panelConf.add(btnAdicionar);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setSelectedIndex(5);
            }
        }
        );
        btnMoveRight1.setPreferredSize(CAMPO_TAMANHO);
        btnMoveRight1.setAlignmentX(RIGHT_ALIGNMENT);
        panel5.add(btnMoveRight1);

        panel.add(panel0, BorderLayout.NORTH);
        grid.add(panel1);
        grid.add(panel2);
        grid.add(panelConf);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);
        return panel;
    }

    protected JPanel panel7() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JLabel label0 = new JLabel("Temperatura ", JLabel.CENTER);
        label0.setPreferredSize(LABEL_TAMANHO2);
        panel0.add(label0);

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Temperatura pretendida:", JLabel.RIGHT);

        String vec[] = {"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
            "27", "28", "29", "30", "31", "32", "33", "34", "35",};
        label1.setPreferredSize(LABEL_TAMANHO2);
        JComboBox field1 = new JComboBox(vec);
        field1.setPreferredSize(CAMPO_TAMANHO);
        panel1.add(label1);
        panel1.add(field1);

        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Temperatura no exterior:", JLabel.RIGHT);

        String vec1[] = {"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
            "27", "28", "29", "30", "31", "32", "33", "34", "35",};
        label2.setPreferredSize(LABEL_TAMANHO2);
        JComboBox field2 = new JComboBox(vec1);
        field2.setPreferredSize(CAMPO_TAMANHO);
        panel2.add(label2);
        panel2.add(field2);

        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel("Temperatura interior:", JLabel.RIGHT);

        String vec2[] = {"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
            "27", "28", "29", "30", "31", "32", "33", "34", "35",};
        label3.setPreferredSize(LABEL_TAMANHO2);
        JComboBox field3 = new JComboBox(vec);
        field3.setPreferredSize(CAMPO_TAMANHO);
        panel3.add(label3);
        panel3.add(field3);

        JPanel panel4 = new JPanel();
        JButton btnAdicionar = new JButton("Confirmar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dc.setTemperaturaInt(Integer.valueOf((String) field1.getSelectedItem()));
                dc.setTemperaturaEx(Integer.valueOf((String) field2.getSelectedItem()));
                dc.setTemperaturaPre(Integer.valueOf((String) field3.getSelectedItem()));
            }
        }
        );
        btnAdicionar.setPreferredSize(CAMPO_TAMANHO);
        panel4.add(btnAdicionar);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setSelectedIndex(6);
            }
        }
        );
        btnMoveRight1.setPreferredSize(CAMPO_TAMANHO);
        btnMoveRight1.setAlignmentX(RIGHT_ALIGNMENT);
        panel5.add(btnMoveRight1);

        panel.add(panel0, BorderLayout.NORTH);
        grid.add(panel1);
        grid.add(panel2);
        grid.add(panel3);
        grid.add(btnAdicionar);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);
        return panel;
    }

    protected JPanel panel8() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel(new GridLayout(4, 1));
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JLabel label0 = new JLabel("Resultado ", JLabel.CENTER);
        label0.setPreferredSize(LABEL_TAMANHO2);
        panel0.add(label0);

        JPanel jp = new JPanel();

        JPanel panel5 = new JPanel();
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dc.criarFicheiroHTML();
                } catch (IOException ex) {
                    Logger.getLogger(JanelaSimu.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );
        panel5.add(btnCalcular);

        panel.add(panel0, BorderLayout.NORTH);
        grid.add(jp);
        grid.add(panel5);
        panel.add(grid, BorderLayout.CENTER);

        return panel;
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
