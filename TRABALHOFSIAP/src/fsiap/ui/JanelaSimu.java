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
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import trabalhofsiap.Abertu;
import trabalhofsiap.DimController;

/**
 *
 * @author i130348
 */
public class JanelaSimu extends JDialog {

    /**
     * Fechar (S/N)
     */
    private String fechar = "nao";
    private Dimension LABEL_TAMANHO2 = new JLabel("Dimensóes do ambiente ").getPreferredSize();
    private Dimension CAMPO_TAMANHO = new Dimension(200, 20);

    private JTextField field4;
    private DimController dc;

    private JScrollPane pdados;
    private JLabel wer;

    private JTabbedPane jt = new JTabbedPane();

    public JanelaSimu(JFrame pai,DimController dc) {

        super(pai, "Capacidade Térmica de uma Sala de Computadores");

        this.dc=dc;
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
        field1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dc.setComprimento(Float.parseFloat(field1.getText()));
                revalidate();
                
            }
        }
        );
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

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Aberturas ", JLabel.CENTER);
        label1.setPreferredSize(LABEL_TAMANHO2);
        panel1.add(label1);

        JPanel panel2 = new JPanel();
        pdados = new JScrollPane();
        pdados.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        pdados.setPreferredSize(CAMPO_TAMANHO);
        JPanel jdados = new JPanel(new FlowLayout());
        wer = new JLabel("olá");
        jdados.add(wer);
        pdados.add(jdados);
        panel2.add(pdados);

        JPanel panel3 = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JanelaAber ja = new JanelaAber();
                
                while(ja.getLista().isEmpty()){
                if (ja.getLista()!=null) {
                    List<Abertu> ls = ja.getLista();

                    for (Abertu s : ls) {
                        wer.setText(s.toString() + "\n");
                        System.out.println(s.toString() + "\n");

                    }
                }
                }

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

    protected JPanel panel3() {
        
        JPanel panel = new JPanel();
        
        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Pessoas ", JLabel.CENTER);
        label1.setPreferredSize(LABEL_TAMANHO2);
        panel1.add(label1);
        
        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel("NºPessoas :", JLabel.RIGHT);
       
        label3.setPreferredSize(LABEL_TAMANHO2);
        JTextField field3 = new JTextField();
        field3.setPreferredSize(CAMPO_TAMANHO);
       
        panel3.add(label3);
        panel3.add(field3);
  

    
        JButton btnAdicionar = new JButton("Confirmar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a=field3.getText();
                field3.setText(a+"Nova Pessoa\n");
            }
        }
        );
        btnAdicionar.setPreferredSize(CAMPO_TAMANHO);
        panel3.add(btnAdicionar);

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
        panel5.add(btnMoveRight1, BorderLayout.EAST);

        panel.add(panel1);
        panel.add(panel3);
        panel.add(panel5);
        
        return panel;
    }

    protected JPanel panel5() {
         JPanel panel = new JPanel();
        
        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Aparelhos ", JLabel.CENTER);
        label1.setPreferredSize(LABEL_TAMANHO2);
        panel1.add(label1);
        
        JPanel as = new JPanel(new GridLayout(2,0));
        
        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel("Nº de Aparelhos :", JLabel.RIGHT);
       
        label3.setPreferredSize(LABEL_TAMANHO2);
        JTextField field3 = new JTextField();
        field3.setPreferredSize(CAMPO_TAMANHO);
       
        panel3.add(label3);
        panel3.add(field3);
        
        JPanel panel4= new JPanel();
        JLabel label4 = new JLabel("Potência Média :", JLabel.RIGHT);
        JLabel la= new JLabel("Wh",JLabel.LEFT);
        label4.setPreferredSize(LABEL_TAMANHO2);
        JTextField field4 = new JTextField();
        field4.setPreferredSize(CAMPO_TAMANHO);
       
        panel4.add(label4);
        panel4.add(field4);
        panel4.add(la);
        
        
        
  

    
        JButton btnAdicionar = new JButton("Confirmar");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a=field3.getText();
                field3.setText(a+"Novo Aparelho\n");
            }
        }
        );
        btnAdicionar.setPreferredSize(CAMPO_TAMANHO);
        panel3.add(btnAdicionar);

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
        panel5.add(btnMoveRight1, BorderLayout.EAST);

        as.add(panel3);
        as.add(panel4,JPanel.LEFT_ALIGNMENT);
        
        panel.add(panel1,BorderLayout.NORTH);
        panel.add(as,BorderLayout.CENTER);
        panel.add(panel5,BorderLayout.SOUTH);
        
        return panel;
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
