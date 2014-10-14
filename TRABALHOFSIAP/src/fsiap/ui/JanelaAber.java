package fsiap.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabalhofsiap.Abertu;
import trabalhofsiap.Aluminio;
import trabalhofsiap.Ar;
import trabalhofsiap.Betao;
import trabalhofsiap.Madeira;
import trabalhofsiap.SimController;
import trabalhofsiap.Vidro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jecabeda
 */
public class JanelaAber extends JFrame {

    /**
     * Fechar (S/N)
     */
    private String fechar = "nao";

    private Dimension LABEL_TAMANHO2 = new JLabel("Dimensóes do ambiente ").getPreferredSize();
    private Dimension Campo2_TAMANHO = new Dimension(250, 20);
    private Dimension Campo3_TAMANHO = new Dimension(250, 40);
    private Dimension Scroll_TAMANHO = new Dimension(250, 90);
    private Dimension BTN_TAMANHO = new Dimension(40, 40);
    public JTextField field4, field3;
    private boolean flag;
    public JComboBox field1, field2;
    private List<Abertu> lista = new ArrayList();
    private SimController dc;
    private JanelaSimu js;
    private int posi;

    private Aluminio al = new Aluminio();
    private Madeira ma = new Madeira();
    private Betao be = new Betao();
    private Vidro vi = new Vidro();
    private Ar a = new Ar();
    private Abertu alt;

    public JanelaAber(SimController dc, JanelaSimu js, boolean f, int po) {

        super("Dados Abertura");

        this.dc = dc;
        this.js = js;
        this.flag = f;
        this.posi = po;
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
        String opcoes[] = {"Porta", "Janela"};
        field1 = new JComboBox(opcoes);
        field1.setPreferredSize(Campo2_TAMANHO);
        field1.setSelectedIndex(-1);

        panel1.add(label1);
        panel1.add(field1);

        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Material:", JLabel.RIGHT);
        label2.setPreferredSize(LABEL_TAMANHO2);
        String opcoes2[] = {ma.getNome(), vi.getNome(), al.getNome()};
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
        field3.setText("Insira Altura...");
        field3.setForeground(Color.GRAY);
        field3.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (field3.getText().equals("Insira Altura...")) {
                    field3.setText("");
                    field3.setForeground(Color.BLACK);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                /*if (field3.getText().equals("Insira Altura...")) {
                    field3.setText("");
                    field3.setForeground(Color.BLACK);
                }*/
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                /*if (field3.getText().equals("")) {
                    field3.setText("Insira Altura...");
                    field3.setForeground(Color.GRAY);
                }*/
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                /* if (field3.getText().equals("Insira Altura...")) {
                 field3.setText("");
                 field3.setForeground(Color.BLACK);
                 }*/
            }

            @Override
            public void mouseExited(MouseEvent e) {
                /*if (field3.getText().equals("")) {
                    field3.setText("Insira Altura...");
                    field3.setForeground(Color.GRAY);
                }*/
            }
        });
        panel3.add(label3);
        panel3.add(field3);

        JPanel panel4 = new JPanel();
        JLabel label4 = new JLabel("Largura:", JLabel.RIGHT);
        label4.setPreferredSize(LABEL_TAMANHO2);
        field4 = new JTextField();
        field4.setPreferredSize(Campo2_TAMANHO);
        field4.setText("Insira Largura...");
        field4.setForeground(Color.GRAY);
        field4.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (field4.getText().equals("Insira Largura...")) {
                    field4.setText("");
                    field4.setForeground(Color.BLACK);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                /*if (field4.getText().equals("Insira Largura...")) {
                    field4.setText("");
                    field4.setForeground(Color.BLACK);
                }*/
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                /*if (field4.getText().equals("")) {
                    field4.setText("Insira Largura...");
                    field4.setForeground(Color.GRAY);
                }*/
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                /* if (field3.getText().equals("Insira Altura...")) {
                 field3.setText("");
                 field3.setForeground(Color.BLACK);
                 }*/
            }

            @Override
            public void mouseExited(MouseEvent e) {
                /*if (field4.getText().equals("")) {
                    field4.setText("Insira Largura...");
                    field4.setForeground(Color.GRAY);
                }*/
            }
        });

        panel4.add(label4);
        panel4.add(field4);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton("Confirmar");

        if (flag == true) {

            flag = false;

            btnMoveRight1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Abertu aber = new Abertu();
                    aber.setAltura(Double.parseDouble(field3.getText()));
                    aber.setLargura(Double.parseDouble(field4.getText()));
                    aber.setTipo(field1.getSelectedItem().toString());
                    aber.setMaterialPeloNome(field2.getSelectedItem().toString());
                    dc.addAber(aber);
                    posi = dc.getListaAber().size() - 1;
                    dispose();
                    JPanel a = new JPanel(new FlowLayout());
                    JLabel b = new JLabel(aber.toString());
                    JButton c = new JButton(js.icon);
                    c.setPreferredSize(BTN_TAMANHO);
                    a.add(b);
                    a.add(c);
                    js.jpanel2.add(a);
                    js.jpanel2.revalidate();

                    c.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            JanelaAber jan = new JanelaAber(dc, js, false, posi);
                            Abertu aber = dc.getListaAber().get(posi);
                            jan.field3.setForeground(Color.BLACK);
                            jan.field4.setForeground(Color.BLACK);
                            jan.field1.setSelectedItem(aber.getMaterial());
                            jan.field2.setSelectedItem(aber.getTipo());
                            jan.field3.setText("" + aber.getAltura());
                            jan.field4.setText("" + aber.getLargura());

                        }
                    });

                }
            });
        } else {
            System.out.println(flag);
            flag = false;
            btnMoveRight1 = new JButton("Confirmar");
            btnMoveRight1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Abertu aber = dc.getListaAber().get(posi);

                    aber.setAltura(Double.parseDouble(field3.getText()));
                    aber.setLargura(Double.parseDouble(field4.getText()));
                    aber.setTipo(field1.getSelectedItem().toString());
                    aber.setMaterialPeloNome(field2.getSelectedItem().toString());
                    js.revalidate();
                    js.repaint();
                    dispose();

                    JPanel a = new JPanel(new FlowLayout());
                    JLabel b = new JLabel(aber.toString());
                    JButton c = new JButton(js.icon);
                    c.setPreferredSize(BTN_TAMANHO);
                    c.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            JanelaAber jan = new JanelaAber(dc, js, false, posi);
                            Abertu aber = dc.getListaAber().get(posi);
                            jan.field3.setForeground(Color.BLACK);
                            jan.field4.setForeground(Color.BLACK);
                            jan.field1.setSelectedItem(aber.getMaterial());
                            jan.field2.setSelectedItem(aber.getTipo());
                            jan.field3.setText("" + aber.getAltura());
                            jan.field4.setText("" + aber.getLargura());

                        }
                    });
                    a.add(b);
                    a.add(c);
                    System.out.println(posi);
                    js.jpanel2.remove(posi);
                    js.jpanel2.add(a, posi);
                    js.jpanel2.revalidate();

                }
            });
        }

        panel5.add(btnMoveRight1);
        grid.add(panel1);
        grid.add(panel2);
        grid.add(panel3);
        grid.add(panel4);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);

        return panel;
    }

    public List<Abertu> getLista() {

        return lista;
    }

}
