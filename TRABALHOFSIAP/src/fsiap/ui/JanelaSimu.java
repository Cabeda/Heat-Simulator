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
import javax.swing.JTextField;
import trabalhofsiap.Abertu;
import trabalhofsiap.Limite;
import trabalhofsiap.SimController;

/**
 *
 * @author i130348
 */
public class JanelaSimu extends JDialog {

    private List<Limite> listaLim = new ArrayList<Limite>();
    private List<Abertu> listaAber = new ArrayList<Abertu>();
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
    private SimController dc;
    private JTextField field4;

    public JPanel jpanel2, jpanel3;

    private JTabbedPane jt = new JTabbedPane();

    public JanelaSimu(JFrame pai, SimController d) {

        super(pai, "Capacidade Térmica de uma Sala de Computadores/Heat Capacity of a Computer Room");
       
        dc = d;
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        getContentPane().add(jp);

        if (dc.getLinguagem() == 1) {
            jt.addTab("Dimensions", panel1());

            jt.addTab("Limits", panel5());

            jt.addTab("Openings", panel2());

            jt.addTab("Persons", panel3());

            jt.addTab("Devices", panel6());

            jt.addTab("Temperature", panel7());

            jt.addTab("Results", panel8());
        } else {
            jt.addTab("Dimensões", panel1());

            jt.addTab("Limites", panel5());

            jt.addTab("Aberturas", panel2());

            jt.addTab("Pessoas", panel3());

            jt.addTab("Aparelhos", panel6());

            jt.addTab("Temperatura", panel7());

            jt.addTab("Resultado", panel8());
        }
        if (dc.getAltura() == 0) {
            jt.setEnabledAt(1, false);
            jt.setEnabledAt(2, false);
            jt.setEnabledAt(3, false);
            jt.setEnabledAt(4, false);
            jt.setEnabledAt(5, false);
            jt.setEnabledAt(6, false);
        }
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
        JPanel panel1 = new JPanel();
        JLabel label1;
        JLabel l1;
        if (dc.getLinguagem() == 1) {
            JLabel label0 = new JLabel("Ambient Dimensions", JLabel.CENTER);
            label0.setPreferredSize(LABEL_TAMANHO2);
            panel0.add(label0);

            label1 = new JLabel("Length:", JLabel.RIGHT);
            l1 = new JLabel("m", JLabel.LEFT);
            label1.setPreferredSize(LABEL_TAMANHO2);
        } else {
            JLabel label0 = new JLabel("Dimensões do ambiente", JLabel.CENTER);
            label0.setPreferredSize(LABEL_TAMANHO2);
            panel0.add(label0);

            label1 = new JLabel("Comprimento:", JLabel.RIGHT);
            l1 = new JLabel("m", JLabel.LEFT);
            label1.setPreferredSize(LABEL_TAMANHO2);
        }
        field1 = new JTextField();
        field1.setPreferredSize(CAMPO_TAMANHO);
        if (dc.getComprimento() != 0) {
            field1.setText("" + dc.getComprimento());
        }
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
                try {
                    if (!field1.getText().equals("") && !field2.getText().equals("") && !field3.getText().equals("")) {
                        dc.setAltura((Float.parseFloat(field3.getText())));
                        dc.setComprimento((Float.parseFloat(field1.getText())));
                        dc.setLargura((Float.parseFloat(field2.getText())));
                        dc.setAreaTotal();
                        field4.setText(Float.toString(dc.getAreaTotal()));
                        revalidate();
                    }
                    revalidate();
                } catch (Exception ex) {
                    if (dc.getLinguagem() == 1) {
                        JOptionPane.showMessageDialog(rootPane, "Dados Inválidos", "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Invalid Data", "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        panel1.add(label1);
        panel1.add(field1);
        panel1.add(l1);

        JPanel panel2 = new JPanel();
        JLabel l2;
        JLabel label2;
        if (dc.getLinguagem() == 1) {
            label2 = new JLabel("Width:", JLabel.RIGHT);
            l2 = new JLabel("m", JLabel.LEFT);
            label2.setPreferredSize(LABEL_TAMANHO2);
        } else {
            label2 = new JLabel("Largura:", JLabel.RIGHT);
            l2 = new JLabel("m", JLabel.LEFT);
            label2.setPreferredSize(LABEL_TAMANHO2);
        }

        field2 = new JTextField();
        field2.setPreferredSize(CAMPO_TAMANHO);
        if (dc.getLargura() != 0) {
            field2.setText("" + dc.getLargura());
        }
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
                try {
                    if (!field1.getText().equals("") && !field2.getText().equals("") && !field3.getText().equals("")) {
                        dc.setAltura((Float.parseFloat(field3.getText())));
                        dc.setComprimento((Float.parseFloat(field1.getText())));
                        dc.setLargura((Float.parseFloat(field2.getText())));
                        dc.setAreaTotal();
                        field4.setText(Float.toString(dc.getAreaTotal()));
                        revalidate();
                    }
                    revalidate();
                } catch (Exception ex) {
                    if (dc.getLinguagem() == 1) {
                        JOptionPane.showMessageDialog(rootPane, "Dados Inválidos", "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Invalid Data", "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        panel2.add(label2);
        panel2.add(field2);
        panel2.add(l2);

        JPanel panel3 = new JPanel();
        JLabel l3;
        JLabel label3;
        if (dc.getLinguagem() == 1) {
            label3 = new JLabel("Height:", JLabel.RIGHT);
            l3 = new JLabel("m", JLabel.LEFT);
            label3.setPreferredSize(LABEL_TAMANHO2);
        } else {
            label3 = new JLabel("Altura:", JLabel.RIGHT);
            l3 = new JLabel("m", JLabel.LEFT);
            label3.setPreferredSize(LABEL_TAMANHO2);
        }

        field3 = new JTextField();
        field3.setPreferredSize(CAMPO_TAMANHO);
        if (dc.getAltura() != 0) {
            field3.setText("" + dc.getAltura());
        }
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
                try {
                    if (!field1.getText().equals("") && !field2.getText().equals("") && !field3.getText().equals("")) {
                        dc.setAltura((Float.parseFloat(field3.getText())));
                        dc.setComprimento((Float.parseFloat(field1.getText())));
                        dc.setLargura((Float.parseFloat(field2.getText())));
                        dc.setAreaTotal();
                        field4.setText(Float.toString(dc.getAreaTotal()));
                        revalidate();
                    }
                    revalidate();
                } catch (Exception ex) {
                    if (dc.getLinguagem() == 1) {
                        JOptionPane.showMessageDialog(rootPane, "Dados Inválidos", "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Invalid Data", "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        panel3.add(label3);
        panel3.add(field3);
        panel3.add(l3);

        JPanel panel4 = new JPanel();
        JLabel label4;
        JLabel l4;
        if (dc.getLinguagem() == 1) {
            label4 = new JLabel("Total Area:", JLabel.RIGHT);
            l4 = new JLabel("m²", JLabel.LEFT);
            label4.setPreferredSize(LABEL_TAMANHO2);
        } else {
            label4 = new JLabel("Área Total:", JLabel.RIGHT);
            l4 = new JLabel("m²", JLabel.LEFT);
            label4.setPreferredSize(LABEL_TAMANHO2);
        }
        field4 = new JTextField();
        field4.setPreferredSize(CAMPO_TAMANHO);
        if (dc.getAreaTotal() != 0) {
            field4.setText("" + dc.getAreaTotal());
        }
        field4.setEditable(false);

        panel4.add(label4);
        panel4.add(field4);
        panel4.add(l4);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (field1.getText().equals("") || field2.getText().equals("")) {
                    if (dc.getLinguagem() == 1) {

                        JOptionPane.showMessageDialog(rootPane, "Please Fill all fields", "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos", "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {
                    jt.setEnabledAt(1, true);
                    jt.setSelectedIndex(1);
                }
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
        if (dc.getLinguagem() == 1) {
            JLabel label1 = new JLabel("Openings ", JLabel.CENTER);
            label1.setPreferredSize(LABEL_TAMANHO2);
            panel1.add(label1, BorderLayout.NORTH);
        } else {
            JLabel label1 = new JLabel("Aberturas ", JLabel.CENTER);
            label1.setPreferredSize(LABEL_TAMANHO2);
            panel1.add(label1, BorderLayout.NORTH);
        }
        jpanel2 = new JPanel();
        if (dc.getListaAber() != null) {
            List<Abertu> d = dc.getListaAber();
            for (Abertu listaAber1 : d) {
                JPanel a = new JPanel(new FlowLayout());
                JLabel b = new JLabel(listaAber1.toString());
                JButton c = new JButton(this.icon);
                a.add(b);
                a.add(c);
                c.setPreferredSize(new Dimension(40, 40));
                jpanel2.add(a);
                jpanel2.revalidate();
                panel1.revalidate();
            }
        }
        jpanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        final JScrollPane scroll = new JScrollPane(jpanel2);
        scroll.setPreferredSize(SCROLL_TAMANHO);

        panel1.add(scroll, BorderLayout.SOUTH);

        JPanel panel3 = new JPanel();
        JButton btnAdicionar;

        if (dc.getLinguagem() == 1) {
            btnAdicionar = new JButton("Add on");
        } else {
            btnAdicionar = new JButton("Adicionar");
        }
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
                jt.setEnabledAt(3, true);
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
        JLabel label0;
        JPanel panel1;
        JLabel label1;
        if (dc.getLinguagem() == 1) {
            label0 = new JLabel("Persons ", JLabel.CENTER);
            label0.setPreferredSize(LABEL_TAMANHO2);
            panel0.add(label0);

            panel1 = new JPanel();
            label1 = new JLabel("Number of People:", JLabel.RIGHT);
        } else {
            label0 = new JLabel("Pessoas ", JLabel.CENTER);
            label0.setPreferredSize(LABEL_TAMANHO2);
            panel0.add(label0);

            panel1 = new JPanel();
            label1 = new JLabel("Nº de Pessoas:", JLabel.RIGHT);
        }
        String vec[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
            "13", "14", "15", "16", "17", "18", "19", "20", "21"};
        label1.setPreferredSize(LABEL_TAMANHO2);
        JComboBox field1 = new JComboBox(vec);
        if (dc.getNumPessoas() != 0) {
            field1.setSelectedIndex(dc.getNumPessoas());
        }
        field1.setPreferredSize(CAMPO_TAMANHO);
        panel1.add(label1);
        panel1.add(field1);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dc.setNumPessoas(Integer.valueOf((String) field1.getSelectedItem()));
                jt.setSelectedIndex(4);
                jt.setEnabledAt(4, true);
            }
        }
        );
        btnMoveRight1.setPreferredSize(CAMPO_TAMANHO);
        btnMoveRight1.setAlignmentX(RIGHT_ALIGNMENT);
        panel5.add(btnMoveRight1);

        panel.add(panel0, BorderLayout.NORTH);
        grid.add(panel1);
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
        JLabel label1;
        if (dc.getLinguagem() == 1) {
            label1 = new JLabel("Room Boundaries ", JLabel.CENTER);
            label1.setPreferredSize(LABEL_TAMANHO2);
            panel1.add(label1, BorderLayout.NORTH);
        } else {
            label1 = new JLabel("Limites da sala ", JLabel.CENTER);
            label1.setPreferredSize(LABEL_TAMANHO2);
            panel1.add(label1, BorderLayout.NORTH);
        }
        jpanel3 = new JPanel();
        if (dc.getListaLim() != null) {
            List<Limite> d = dc.getListaLim();
            for (Limite listaLim1 : dc.getListaLim()) {
                JPanel a = new JPanel(new FlowLayout());
                JLabel b = new JLabel(listaLim1.toString());
                JButton c = new JButton(this.icon);
                a.add(b);
                a.add(c);
                c.setPreferredSize(new Dimension(40, 40));
                jpanel3.add(a);
                jpanel3.revalidate();
                panel1.revalidate();
            }
        }
        jpanel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        final JScrollPane scroll = new JScrollPane(jpanel3);
        scroll.setPreferredSize(SCROLL_TAMANHO);

        panel1.add(scroll, BorderLayout.SOUTH);

        JPanel panel3 = new JPanel();
        JButton btnAdicionar;

        if (dc.getLinguagem() == 1) {
            btnAdicionar = new JButton("Add on");
        } else {
            btnAdicionar = new JButton("Adicionar");
        }
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
                jt.setEnabledAt(2, true);
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
        JPanel panel1;
        JLabel label1, l1, label0;

        if (dc.getLinguagem() == 1) {
            label0 = new JLabel("Room Devices ", JLabel.CENTER);
            label0.setPreferredSize(LABEL_TAMANHO2);
            panel0.add(label0);

            panel1 = new JPanel();
            label1 = new JLabel("Number of Devices:", JLabel.RIGHT);
            l1 = new JLabel("      ");
        } else {
            label0 = new JLabel("Aparelhos na sala ", JLabel.CENTER);
            label0.setPreferredSize(LABEL_TAMANHO2);
            panel0.add(label0);

            panel1 = new JPanel();
            label1 = new JLabel("Nº de aparelhos:", JLabel.RIGHT);
            l1 = new JLabel("      ");
        }
        JTextField field1 = new JTextField();
        field1.setPreferredSize(CAMPO_TAMANHO);
        if (dc.getNumAparelhos() != 0) {
            field1.setText("" + dc.getNumAparelhos());
        }
        label1.setPreferredSize(LABEL_TAMANHO2);
        panel1.add(label1);
        panel1.add(field1);
        panel1.add(l1);

        JPanel panel2 = new JPanel();
        JLabel label2, l2;

        if (dc.getLinguagem() == 1) {
            label2 = new JLabel("Average Power:", JLabel.RIGHT);
            l2 = new JLabel("Wh");
        } else {
            label2 = new JLabel("Potência média:", JLabel.RIGHT);
            l2 = new JLabel("Wh");
        }
        label2.setPreferredSize(LABEL_TAMANHO2);
        JTextField field2 = new JTextField();
        if (dc.getPotenciaMedia() != 0) {
            field2.setText("" + dc.getPotenciaMedia());
        }
        field2.setPreferredSize(CAMPO_TAMANHO);

        panel2.add(label2);
        panel2.add(field2);
        panel2.add(l2);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (field1.getText().equals("") || field2.getText().equals("")) {
                        if (dc.getLinguagem() == 1) {

                            JOptionPane.showMessageDialog(rootPane, "Please Fill all fields", "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos", "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } else {
                        dc.setNumAparelhos((Integer.parseInt(field1.getText())));
                        dc.setPotenciaMedia((Integer.parseInt(field2.getText())));
                        jt.setSelectedIndex(5);
                        jt.setEnabledAt(5, true);
                    }
                } catch (Exception ex) {
                    if (dc.getLinguagem() == 1) {
                        JOptionPane.showMessageDialog(rootPane, "Dados Inválidos", "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Invalid Data", "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
        );
        btnMoveRight1.setPreferredSize(CAMPO_TAMANHO);
        btnMoveRight1.setAlignmentX(RIGHT_ALIGNMENT);
        panel5.add(btnMoveRight1);

        panel.add(panel0, BorderLayout.NORTH);
        grid.add(panel1);
        grid.add(panel2);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);
        return panel;
    }

    protected JPanel panel7() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JLabel label0, label1;
        JPanel panel1;
        if (dc.getLinguagem() == 1) {
            label0 = new JLabel("Temperature ", JLabel.CENTER);
            label0.setPreferredSize(LABEL_TAMANHO2);
            panel0.add(label0);

            panel1 = new JPanel();
            label1 = new JLabel("Desired Temperature:", JLabel.RIGHT);
        } else {
            label0 = new JLabel("Temperatura ", JLabel.CENTER);
            label0.setPreferredSize(LABEL_TAMANHO2);
            panel0.add(label0);

            panel1 = new JPanel();
            label1 = new JLabel("Temperature pretendida:", JLabel.RIGHT);
        }
        String vec[] = {"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
            "27", "28", "29", "30", "31", "32", "33", "34", "35",};
        label1.setPreferredSize(LABEL_TAMANHO2);
        JComboBox field1 = new JComboBox(vec);
        if (dc.getTemperaturaPre() != 0) {
            field1.setSelectedIndex(dc.getTemperaturaPre() - 15);
        }
        field1.setPreferredSize(CAMPO_TAMANHO);
        panel1.add(label1);
        panel1.add(field1);

        JPanel panel2 = new JPanel();
        JLabel label2;
        if (dc.getLinguagem() == 1) {
            label2 = new JLabel("Outside Temperature :", JLabel.RIGHT);
        } else {
            label2 = new JLabel("Temperatura no exterior:", JLabel.RIGHT);
        }
        String vec1[] = {"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
            "27", "28", "29", "30", "31", "32", "33", "34", "35",};
        label2.setPreferredSize(LABEL_TAMANHO2);
        JComboBox field2 = new JComboBox(vec1);
        if (dc.getTemperaturaEx() != 0) {
            field2.setSelectedIndex(dc.getTemperaturaEx() - 15);
        }
        field2.setPreferredSize(CAMPO_TAMANHO);
        panel2.add(label2);
        panel2.add(field2);

        JLabel label3;

        JPanel panel3 = new JPanel();
        if (dc.getLinguagem() == 1) {
            label3 = new JLabel("Inside Temperature:", JLabel.RIGHT);
        } else {
            label3 = new JLabel("Temperatura Interior:", JLabel.RIGHT);
        }
        String vec2[] = {"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
            "27", "28", "29", "30", "31", "32", "33", "34", "35",};
        label3.setPreferredSize(LABEL_TAMANHO2);
        JComboBox field3 = new JComboBox(vec);
        if (dc.getTemperaturaInt() != 0) {
            field3.setSelectedIndex(dc.getTemperaturaInt() - 15);
        }
        field3.setPreferredSize(CAMPO_TAMANHO);
        panel3.add(label3);
        panel3.add(field3);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dc.setTemperaturaPre(Integer.valueOf((String) field1.getSelectedItem()));
                dc.setTemperaturaEx(Integer.valueOf((String) field2.getSelectedItem()));
                dc.setTemperaturaInt(Integer.valueOf((String) field3.getSelectedItem()));
                jt.setSelectedIndex(6);
                jt.setEnabledAt(6, true);
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
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);
        return panel;
    }

    protected JPanel panel8() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel(new GridLayout(4, 1));
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JLabel label0;
        if (dc.getLinguagem() == 1) {
            label0 = new JLabel("Results ", JLabel.CENTER);
            label0.setPreferredSize(LABEL_TAMANHO2);
            panel0.add(label0);
        } else {
            label0 = new JLabel("Resultado ", JLabel.CENTER);
            label0.setPreferredSize(LABEL_TAMANHO2);
            panel0.add(label0);
        }

        JPanel jp = new JPanel();

        JPanel panel5 = new JPanel();
        JButton btnCalcular;
        if (dc.getLinguagem() == 1) {
            btnCalcular = new JButton("Calculate");
            btnCalcular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        dc.criarFicheiroHTMLEn();
                        dc.guardarDados();
                    } catch (IOException ex) {
                        Logger.getLogger(JanelaSimu.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            );
        } else {
            btnCalcular = new JButton("Calcular");
            btnCalcular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        dc.criarFicheiroHTMLPt();
                        dc.guardarDados();
                    } catch (IOException ex) {
                        Logger.getLogger(JanelaSimu.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            );
        }

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
        int resposta;
        if (dc.getLinguagem() == 1) {
            String[] opSimNao = {"Yes", "No"};
            resposta = JOptionPane.showOptionDialog(this,
                    "Do you wish to close the program?",
                    "FSIAP",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opSimNao,
                    opSimNao[1]);
        } else {
            String[] opSimNao = {"Sim", "Não"};
            resposta = JOptionPane.showOptionDialog(this,
                    "Deseja fechar a aplicação?",
                    "FSIAP",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opSimNao,
                    opSimNao[1]);
        }
        final int SIM = 0;
        if (resposta == SIM) {
            dispose();
            
            
        }
        fechar = "sim";
    }

}
