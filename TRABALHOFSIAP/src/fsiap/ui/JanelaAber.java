 
/*
TRABALHO DE FÍSICA
António Pinheiro 1130339
Cristina Lopes 1130371
Egídio Santos 1130348
José Cabeda 1130395
 */

package fsiap.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabalhofsiap.Abertu;
import trabalhofsiap.Aluminio;
import trabalhofsiap.Ar;
import trabalhofsiap.Betao;
import trabalhofsiap.Cimento;
import trabalhofsiap.Limite;
import trabalhofsiap.Madeira;
import trabalhofsiap.SimController;
import trabalhofsiap.Tijolo;
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
    public JTextField field4, field3, field6;
    private boolean flag;
    public JComboBox field1, field2;
    private SimController dc;
    private JanelaSimu js;
    private int posi;

    private Aluminio al;
    private Madeira ma;
    private Betao be;
    private Vidro vi;
    private Ar a;
    private Tijolo ti;
    private Cimento ci;
    private Abertu alt;
    ResourceBundle mensagens;

    public JanelaAber(String titulo, SimController d, JanelaSimu js, boolean f, int po) {
        super(titulo);
        mensagens = d.getMensagens();
        this.dc = d;
        this.js = js;
        this.flag = f;
        this.posi = po;

        al = (Aluminio) d.getMaterialpeloNome(mensagens.getString("aluminio"));
        ma = (Madeira) d.getMaterialpeloNome(mensagens.getString("madeira"));
        vi = (Vidro) d.getMaterialpeloNome(mensagens.getString("vidro"));
        a = (Ar) d.getMaterialpeloNome(mensagens.getString("ar"));
        be = (Betao) d.getMaterialpeloNome(mensagens.getString("betao"));
        ti  = (Tijolo) d.getMaterialpeloNome(mensagens.getString("tijolo"));
        ci  = (Cimento)d.getMaterialpeloNome(mensagens.getString("cimento"));

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
        String opcoes[] = new String[2];
        JLabel label1;
        JPanel panel1 = new JPanel();
        label1 = new JLabel(mensagens.getString("limite")+":", JLabel.RIGHT);
        label1.setPreferredSize(LABEL_TAMANHO2);
        field1 = new JComboBox(dc.getListaLim().toArray());
        field1.setPreferredSize(Campo2_TAMANHO);
        field1.setSelectedIndex(-1);
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
                    if (-1 != field1.getSelectedIndex()) {
                        Limite lim = (Limite) field1.getSelectedItem();
                        field3.setText(Double.toString(lim.getAltura()));
                        field4.setText(Double.toString(lim.getLargura()));

                    }
                    revalidate();
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane,mensagens.getString("dadosInv"), "FSIAP", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });

        panel1.add(label1);
        panel1.add(field1);

        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel(mensagens.getString("material")+":", JLabel.RIGHT);
        label2.setPreferredSize(LABEL_TAMANHO2);

        String opcoes2[] = {ma.getNome(), vi.getNome(), al.getNome(), be.getNome(),ci.getNome(),ti.getNome(),a.getNome()};
        field2 = new JComboBox(opcoes2);
        field2.setPreferredSize(Campo2_TAMANHO);
        field2.setSelectedIndex(-1);
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
                    if (-1 != field1.getSelectedIndex()) {
                        Limite lim = (Limite) field1.getSelectedItem();
                        field3.setText(Double.toString(lim.getAltura()));
                        field4.setText(Double.toString(lim.getLargura()));

                    }
                    revalidate();
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane,mensagens.getString("dadosInv"), "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        panel2.add(label2);
        panel2.add(field2);

        JPanel panel3 = new JPanel();
        JLabel label3;
        label3 = new JLabel(mensagens.getString("altura")+":", JLabel.RIGHT);
        JLabel l1 = new JLabel("m", JLabel.LEFT);        
        label3.setPreferredSize(LABEL_TAMANHO2);
        field3 = new JTextField();
        field3.setPreferredSize(Campo2_TAMANHO);
        field3.setEditable(false);

        panel3.add(label3);
        panel3.add(field3);
        panel3.add(l1);

        JPanel panel4 = new JPanel();
        JLabel label4;
        label4 = new JLabel(mensagens.getString("largura")+":", JLabel.RIGHT);
        JLabel l2 = new JLabel("m", JLabel.LEFT);
        label4.setPreferredSize(LABEL_TAMANHO2);
        field4 = new JTextField();
        field4.setPreferredSize(Campo2_TAMANHO);
        field4.setEditable(false);

        panel4.add(label4);
        panel4.add(field4);
        panel4.add(l2);

        JPanel panel6 = new JPanel();
        JLabel label6;
        label6 = new JLabel(mensagens.getString("espessura")+":", JLabel.RIGHT);
        JLabel l3 = new JLabel("m", JLabel.LEFT);
        label6.setPreferredSize(LABEL_TAMANHO2);
        field6 = new JTextField();
        field6.setPreferredSize(Campo2_TAMANHO);

        panel6.add(label6);
        panel6.add(field6);
        panel6.add(l3);

        JButton btnMoveRight1;
        JPanel panel5 = new JPanel();
        btnMoveRight1 = new JButton(mensagens.getString("confirmar"));
        if (flag == true) {

            flag = false;

            btnMoveRight1 = new JButton(mensagens.getString("confirmar"));
            btnMoveRight1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                                        try {

                        if (field1.getSelectedIndex() != -1 && field2.getSelectedIndex() != -1 && !field6.getText().equals("")) {
                            if (Integer.parseInt(field6.getText()) <= 0) {
                                field6.setText("");
                                JOptionPane.showMessageDialog(rootPane, mensagens.getString("dadosInv"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);
                            } else {
                    Abertu aber = new Abertu(dc);
                    aber.setAltura(Double.parseDouble(field3.getText()));
                    aber.setLargura(Double.parseDouble(field4.getText()));
                    aber.setMaterialPeloNome(field2.getSelectedItem().toString());

                    Limite lim = (Limite) field1.getSelectedItem();
                    aber.setEspessura(lim.getEspessura());
                    lim.addAbertura(aber);
                    aber.setLimite(lim);

                    posi = lim.getListaAberturas().size() - 1;
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

                            JanelaAber jan = new JanelaAber(mensagens.getString("dadosaber"),dc, js, false, posi);
                            Abertu aber = lim.getListaAberturas().get(posi);

                            jan.field1.setSelectedItem(field1.getSelectedItem());
                            jan.field1.setEnabled(false);
                            jan.field2.setSelectedItem(aber.getMaterial().getNome());
                            jan.field3.setText(Double.toString(lim.getAltura()));
                            jan.field4.setText(Double.toString(lim.getLargura()));
                            jan.field6.setText("" + aber.getEspessura());
                         }
                                });
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, mensagens.getString("preenchaTudo"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(rootPane, mensagens.getString("dadosInv"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            });
        } else {
            btnMoveRight1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                     try {

                        if (field1.getSelectedIndex() != -1 && field2.getSelectedIndex() != -1 && !field6.getText().equals("")) {
                            if (Integer.parseInt(field6.getText()) <= 0) {
                                field6.setText("");
                                JOptionPane.showMessageDialog(rootPane, mensagens.getString("dadosInv"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);
                            } else {
                    Limite lim = (Limite) field1.getSelectedItem();
                    Abertu aber = lim.getListaAberturas().get(posi);

                    aber.setAltura(Double.parseDouble(field3.getText()));
                    aber.setLargura(Double.parseDouble(field4.getText()));
                    aber.setEspessura(Double.parseDouble(field6.getText()));
                    aber.setMaterialPeloNome(field2.getSelectedItem().toString());

                    lim.getListaAberturas().set(posi, aber);

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

                            JanelaAber jan = new JanelaAber(mensagens.getString("dadosaber"),dc, js, false, posi);
                            Abertu aber = lim.getListaAberturas().get(posi);

                            jan.field1.setSelectedItem(field1.getSelectedItem());
                            jan.field1.setEnabled(false);
                            jan.field2.setSelectedItem(aber.getMaterial().getNome());
                            jan.field3.setText(Double.toString(lim.getAltura()));
                            jan.field4.setText(Double.toString(lim.getLargura()));
                            jan.field6.setText("" + aber.getEspessura());

                        }
                    });
                    a.add(b);
                    a.add(c);

                    js.jpanel2.remove(posi);
                    js.jpanel2.add(a, posi);
                    js.jpanel2.revalidate();
 }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, mensagens.getString("preenchaTudo"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (Exception erro) {
                        JOptionPane.showMessageDialog(rootPane, mensagens.getString("dadosInv"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            });
        }

        panel5.add(btnMoveRight1);
        grid.add(panel1);
        grid.add(panel2);
        grid.add(panel3);
        grid.add(panel4);
        grid.add(panel6);
        panel.add(grid, BorderLayout.CENTER);
        panel.add(panel5, BorderLayout.SOUTH);

        getRootPane().setDefaultButton(btnMoveRight1);
        return panel;
    }

}
