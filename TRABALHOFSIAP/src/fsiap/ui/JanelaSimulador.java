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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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

    public JanelaSimulador(JFrame pai) {

        super(pai, "Capacidade Térmica de uma Sala de Computadores");
        
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        getContentPane().add(jp);
        

        JTabbedPane jt = new JTabbedPane();

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

        jp.add(jt, BorderLayout.CENTER);
        jt.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        jt.repaint();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fechar();
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(670, 270);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    protected JPanel panel1() {
                JPanel panel1 = new JPanel();
		panel1.setLayout( new GridLayout(6,1) );

		JLabel label1 = new JLabel( "Comprimento:" );
		label1.setBounds( 10, 15, 150, 20 );
		panel1.add( label1 );

		JTextField field1 = new JTextField();
		field1.setBounds( 10, 35, 150, 20 );
		panel1.add( field1 );

		JLabel label2 = new JLabel( "Largura:" );
		label2.setBounds( 10, 60, 150, 20 );
		panel1.add( label2 );
                
                JTextField field2 = new JTextField();
		field2.setBounds( 10, 35, 150, 20 );
		panel1.add( field2 );
                
                JLabel label3 = new JLabel( "Altura:" );
		label2.setBounds( 10, 60, 150, 20 );
		panel1.add( label3 );
                
                JTextField field3 = new JTextField();
		field3.setBounds( 10, 35, 150, 20 );
		panel1.add( field3 );
                
                JLabel label4 = new JLabel( "Area:" );
		label2.setBounds( 10, 60, 150, 20 );
		panel1.add( label4 );
                
                JTextField field4 = new JTextField();
		field4.setBounds( 10, 35, 150, 20 );
		panel1.add( field4 );
                
                JButton btnMoveRight1 = new JButton(">>");
                        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //tabbedPane.setSelectedIndex(1);
                }
            }
        );
                        panel1.add(btnMoveRight1);
                        btnMoveRight1.setAlignmentX(CENTER_ALIGNMENT);
        return panel1;
    }

    protected JPanel panel2() {
        JPanel panel1 = new JPanel();
        panel1.setLayout( new GridLayout(4,0) );
        
        JLabel label1 = new JLabel( "Aberturas" );
		label1.setBounds( 10, 15, 150, 20 );
		panel1.add( label1 );
        
        JTextField field1 = new JTextField();
        field1.setBounds( 10, 35, 150, 20 );
        panel1.add( field1 );
        
                        JButton btnAdicionar= new JButton("Adicionar");
                        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                }
            }
        );
                        panel1.add(btnAdicionar);

        
                        JButton btnMoveRight1 = new JButton(">>");
                        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                }
            }
        );
                        panel1.add(btnMoveRight1);
                        btnMoveRight1.setAlignmentX(RIGHT_ALIGNMENT);
                        
        return panel1;
    }

    protected JPanel panel3() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6, 1));
        JLabel lbl1 = new JLabel();
        lbl1.add(new JTextField("Dimensiões do Ambiente"));

        p1.add(lbl1);
        return p1;
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
