/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsiap.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Tab;
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

    private List<Limite> listaLim  = new ArrayList();
    private List<Abertu> listaAber  = new ArrayList();
    /**
     * Fechar (S/N)
     */
    public Icon icon = new ImageIcon("icon_device_settings.gif");
    private String fechar = "nao";
    private String resultado="";
    private Dimension LABEL_TAMANHO2 = new JLabel("Temperatura pretendida na sala ").getPreferredSize();
    private Dimension CAMPO_TAMANHO = new Dimension(200, 20);
    private Dimension SCROLL_TAMANHO = new Dimension(200, 100);
    private Dimension RESULTADO_TAMANHO = new Dimension(300,50);

    private JTextField field4;
    private SimController dc = new SimController();

    public JScrollPane pdadosLim;
    public JPanel jpanel2;

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
        JLabel l1 =  new JLabel("m",JLabel.LEFT);
        label1.setPreferredSize(LABEL_TAMANHO2);
        JTextField field1 = new JTextField();
        field1.setPreferredSize(CAMPO_TAMANHO);
        panel1.add(label1);
        panel1.add(field1);
        panel1.add(l1);
        
        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Largura:", JLabel.RIGHT);
        JLabel l2 =  new JLabel("m",JLabel.LEFT);
        label2.setPreferredSize(LABEL_TAMANHO2);
        JTextField field2 = new JTextField();
        field2.setPreferredSize(CAMPO_TAMANHO);
        
        panel2.add(label2);
        panel2.add(field2);
        panel2.add(l2);
        
        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel("Altura:", JLabel.RIGHT);
        JLabel l3 =  new JLabel("m",JLabel.LEFT);
        label3.setPreferredSize(LABEL_TAMANHO2);
        JTextField field3 = new JTextField();
        field3.setPreferredSize(CAMPO_TAMANHO);
       
        panel3.add(label3);
        panel3.add(field3);
        panel3.add(l3);

        JPanel panel4 = new JPanel();
        JLabel label4 = new JLabel("Volume:", JLabel.RIGHT);
        JLabel l4 =  new JLabel("m³",JLabel.LEFT);
        label4.setPreferredSize(LABEL_TAMANHO2);
        field4 = new JTextField();
        field4.setPreferredSize(CAMPO_TAMANHO);
        field4.setEditable(false);
        
        panel4.add(label4);
        panel4.add(field4);
        panel4.add(l4);
        
        JPanel panelConf = new JPanel();
        JButton btnAdicionar = new JButton("Confirmar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float a=Float.parseFloat(field1.getText())* Float.parseFloat(field2.getText()) * Float.parseFloat(field3.getText());
                field4.setText(Float.toString(a));
                dc.setAltura((Float.parseFloat(field3.getText())));
                dc.setComprimento((Float.parseFloat(field1.getText())));
                dc.setLargura((Float.parseFloat(field2.getText())));
                dc.setVolume((Float.parseFloat(field4.getText())));

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
        grid.add(panelConf);
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

        jpanel2 = new JPanel();
        
        
     

       

        JPanel panel3 = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JanelaAber ja = new JanelaAber(dc, JanelaSimu.this);
                revalidate();
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
        center.add(jpanel2, BorderLayout.CENTER);
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
       
         String vec[] = {"1","2","3","4","5","6","7","8","9","10","11","12",
        "13","14","15","16","17","18","19","20","21",};
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
                dc.setNumPessoas(Integer.valueOf((String)field1.getSelectedItem()));
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

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Limites da sala ", JLabel.CENTER);
        label1.setPreferredSize(LABEL_TAMANHO2);
        panel1.add(label1);

        JPanel panel2 = new JPanel();
        pdadosLim = new JScrollPane();
        pdadosLim.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        pdadosLim.setPreferredSize(SCROLL_TAMANHO);

        panel2.add(pdadosLim);

        JPanel panel3 = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JanelaLim lim = new JanelaLim(dc, JanelaSimu.this);                
                
                
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
        center.add(panel2, BorderLayout.CENTER);
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
        JTextField field1 = new JTextField();
        field1.setPreferredSize(CAMPO_TAMANHO);
        panel1.add(label1);
        panel1.add(field1);
        
        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Potência média:", JLabel.RIGHT);
        JLabel l2 =  new JLabel("Wh",JLabel.LEFT);
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
        JLabel label0 = new JLabel("Temperatura pretendida na sala ", JLabel.CENTER);
        label0.setPreferredSize(LABEL_TAMANHO2);
        panel0.add(label0);

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Temperatura:", JLabel.RIGHT);
       
        String vec[] = {"15","16","17","18","19","20","21","22","23","24","25","26",
        "27","28","29","30","31","32","33","34","35",};
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
                dc.setNumPessoas(Integer.valueOf((String)field1.getSelectedItem()));
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
        grid.add(btnAdicionar);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);
        return panel;
    }

    protected JPanel panel8() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JLabel label0 = new JLabel("Resultado ", JLabel.CENTER);
        label0.setPreferredSize(LABEL_TAMANHO2);
        panel0.add(label0);

        JPanel jp = new JPanel();
        

        JTextArea jt = new JTextArea(resultado);
        jt.setEditable(false);
        jt.setLineWrap(true);
        jt.setPreferredSize(RESULTADO_TAMANHO);
        
        jp.add(jt);
    
     
        
        JPanel panel4 = new JPanel();
        JButton btnAdicionar = new JButton("Confirmar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setText(null);
                jt.append(dc.toString());
            }
        }
        );
        btnAdicionar.setPreferredSize(CAMPO_TAMANHO);
        panel4.add(btnAdicionar);

        JPanel jp1 = new JPanel();
        

        JTextArea jt1 = new JTextArea(resultado);
        jt1.setEditable(false);
        jt1.setLineWrap(true);
        jt1.setPreferredSize(RESULTADO_TAMANHO);
        
        jp1.add(jt1);
    
     
        
        JPanel panel5 = new JPanel();
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt1.setText(null);
                jt1.append(dc.calcular());
                
            }
        }
        );
        btnAdicionar.setPreferredSize(CAMPO_TAMANHO);
        panel5.add(btnAdicionar);
        
        

        panel.add(panel0, BorderLayout.NORTH);
        grid.add(jp);
        grid.add(btnAdicionar);
        grid.add(jp1);
        grid.add(btnCalcular);
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
