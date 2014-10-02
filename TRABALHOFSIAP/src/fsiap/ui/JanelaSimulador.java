/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsiap.ui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

        GridLayout gl = new GridLayout(1, 1);
        setLayout(gl);

        JTabbedPane jt = new JTabbedPane();

//ImageIcon icon = createImageIcon("images/middle.gif");
        JComponent panel1 = new JComponent() {

            

            @Override
            public void setVisible(boolean aFlag) {
                super.setVisible(true); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Component add(Component comp) {
                return super.add(panel1()); //To change body of generated methods, choose Tools | Templates.
            }

            
};
        
        jt.addTab("Dimensões", panel1);

        JComponent panel2 = panel2();
        jt.addTab("Aberturas", panel2);

        JComponent panel3 = panel3();
        jt.addTab("Cobertura", panel3);

        JComponent panel4 = panel4();
        jt.addTab("Iluminação", panel4);

        JComponent panel5 = panel5();
        jt.addTab("Pessoas", panel5);

        JComponent panel6 = panel6();
        jt.addTab("Aparelhos", panel6);

        JComponent panel7 = panel7();
        jt.addTab("Temperatura", panel7);

        JComponent panel8 = panel8();
        jt.addTab("Resultado", panel8);

        add(jt);
        jt.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

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
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6, 1));

        JLabel lbl1 = new JLabel();
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.add(new JTextField("Dimensões do Ambiente"));

        JLabel lbl2 = new JLabel();
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.add(new JTextField("Comprimento"));

        p1.add(lbl1);
        p1.setVisible(true);
        return p1;
    }

    protected JPanel panel2() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6, 1));
        JLabel lbl1 = new JLabel();
        lbl1.add(new JTextField("Aberturas"));

        p1.add(lbl1);
        return p1;
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
