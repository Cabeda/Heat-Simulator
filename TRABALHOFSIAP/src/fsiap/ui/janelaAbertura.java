package fsiap.ui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabalhofsiap.abertura;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jecabeda
 */
public class janelaAbertura extends JFrame {

   /**
     * Fechar (S/N)
     */
    private String fechar = "nao";
    
    private Dimension LABEL_TAMANHO2 = new JLabel("Dimensóes do ambiente ").getPreferredSize();
    private Dimension Campo2_TAMANHO = new Dimension(250, 20);
    private Dimension Campo3_TAMANHO = new Dimension(250, 40);
    private Dimension Scroll_TAMANHO = new Dimension(250, 90);
    private Dimension BTN_TAMANHO = new Dimension(200, 40);
    private abertura aber;
    private JTextField field4,field3;
    private JComboBox field1, field2;
    private List<abertura> lista  = new ArrayList();
    
    public janelaAbertura(){

        super("Dados Abertura");

       

        //ImageIcon i = new ImageIcon("xxxxxxx.jpg");
        //add(new JLabel(i));
        BorderLayout gl = new BorderLayout();
        setLayout(gl);

        add(new JLabel(" "), BorderLayout.NORTH);
        add(panel1());
       

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(670, 270);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    
    protected JPanel panel1() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Tipo de abertura:", JLabel.RIGHT);
        label1.setPreferredSize(LABEL_TAMANHO2);
        String opcoes[]={"Porta","Janela"};
        field1 = new JComboBox(opcoes);
        field1.setPreferredSize(Campo2_TAMANHO);
        field1.setSelectedIndex(-1);
        
        panel1.add(label1);
        panel1.add(field1);

        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Material:", JLabel.RIGHT);
        label2.setPreferredSize(LABEL_TAMANHO2);
        String opcoes2[]={"Madeira","Vidro","Plastico","Aluminio"};
        field2 = new JComboBox(opcoes2);
        field2.setPreferredSize(Campo2_TAMANHO);
        field2.setSelectedIndex(-1);
        panel2.add(label2);
        panel2.add(field2);

        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel("Altura:", JLabel.RIGHT);
        label3.setPreferredSize(LABEL_TAMANHO2);
        field3 = new JTextField();
        field3.setPreferredSize(Campo2_TAMANHO);
        panel3.add(label3);
        panel3.add(field3);

        JPanel panel4 = new JPanel();
        JLabel label4 = new JLabel("Largura:", JLabel.RIGHT);
        label4.setPreferredSize(LABEL_TAMANHO2);
        field4 = new JTextField();
        field4.setPreferredSize(Campo2_TAMANHO);
        field4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                    field4.setText("ANTONIO");
                
                revalidate();

            }
        }
        );

        panel4.add(label4);
        panel4.add(field4);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton("Confirmar");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aber = new abertura();
                
                aber.setAltura(Integer.parseInt(field3.getText()));
                aber.setLargura(Integer.parseInt(field4.getText()));
                aber.setMaterial((String)field1.getSelectedItem());
                aber.setTipo((String) field2.getSelectedItem());
                lista.add(aber);
                dispose();
            }
        }
        );
        btnMoveRight1.setPreferredSize(Campo2_TAMANHO);
        panel5.add(btnMoveRight1);

        grid.add(panel1);
        grid.add(panel2);
        grid.add(panel3);
        grid.add(panel4);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);
        return panel;
    }
   
    
    public List<abertura> getLista(){
        lista.add(aber);
   
        return lista;
    }
    
    

}
