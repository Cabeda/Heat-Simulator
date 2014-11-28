/*
 TRABALHO DE FÍSICA
 António Pinheiro 1130339
 Cristina Lopes 1130371
 Egídio Santos 1130348
 José Cabeda 1130395
 */
package fsiap.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import trabalhofsiap.Abertu;
import trabalhofsiap.Camada;
import trabalhofsiap.Limite;
import trabalhofsiap.SimController;

/**
 *
 * Classe responsável por criar a Janela principal do Simulador
 *
 */
public class JanelaSimu extends JFrame {

    //Icone  para editar Camadas ou Aberturas
    public Icon icon = new ImageIcon("icon_device_settings.gif");
    //Icone para apagar Camadas ou Aberturas
    public Icon icon2 = new ImageIcon("delete.png");

    //Variável para guardar posição da ultima Camada adicionada ao jpainel3
    int posi = 0;

    //Caixa de texto para o comprimento
    private JTextField field1;

    //Caixa de texto para a largura
    private JTextField field2;

    //Caixa de texto para a altura
    private JTextField field3;

    //Caixa de texto para a área total
    private JTextField field4;

    //Tamanho máximo das Labels
    private Dimension LABEL_TAMANHO2 = new JLabel("Temperatura pretendida na sala ").getPreferredSize();

    //Tamanho das caixas de texto
    private Dimension CAMPO_TAMANHO = new Dimension(200, 30);

    //Tamanho das jscrollPane
    private Dimension SCROLL_TAMANHO = new Dimension(200, 100);

    //tAMANHO dos botões
    private Dimension BTN_TAMANHO = new Dimension(40, 40);

    //Inicialização do Controller do programa
    private SimController dc;

    //Inicialização do Resourcebundle para apresentar todas as mensagens
    ResourceBundle mensagens;

    //Inicialização dos limites da sala
    Limite tecto;
    Limite chao;
    Limite paredeNorte;
    Limite paredeOeste;
    Limite paredeSul;
    Limite paredeEste;

    //Paineis para apresentar as Aberturas e as Camadas respetivamente
    public JPanel jpanel2, jpanel3;

    //Criação do painel principal da interface gráfica da aplicação
    private JTabbedPane jt = new JTabbedPane();

    /**
     *
     * Método responsável por criar e apresentar a janela principal
     *
     * @param titulo
     * @param d
     */
    public JanelaSimu(String titulo, SimController d) {

        super(titulo);

        mensagens = d.getMensagens();

        tecto = new Limite("tecto", mensagens);
        chao = new Limite("chao", mensagens);
        paredeNorte = new Limite("paredeNorte", mensagens);
        paredeOeste = new Limite("paredeOeste", mensagens);
        paredeSul = new Limite("paredeSul", mensagens);
        paredeEste = new Limite("paredeEste", mensagens);

        dc = d;
        if (dc.getListaLim().isEmpty()) {
            dc.addLim(tecto);
            dc.addLim(paredeNorte);
            dc.addLim(paredeOeste);
            dc.addLim(paredeEste);
            dc.addLim(paredeSul);
            dc.addLim(chao);
        }

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        getContentPane().add(jp);
        jt.addTab(mensagens.getString("dimTitulo"), panel1());

        jt.addTab(mensagens.getString("camadasTitulo"), panel5());

        jt.addTab(mensagens.getString("aberturasTitulo"), panel2());

        jt.addTab(mensagens.getString("pessoasTitulo"), panel3());

        jt.addTab(mensagens.getString("aparelhos"), panel6());

        jt.addTab(mensagens.getString("temperatura"), panel7());

        jt.addTab(mensagens.getString("resultado"), panel8());
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

    protected void jfield1() {

        try {
            if (!field1.getText().equals("") && !field2.getText().equals("") && !field3.getText().equals("")) {

                if (Float.parseFloat(field1.getText()) > 0 && Float.parseFloat(field2.getText()) > 0 && Float.parseFloat(field3.getText()) > 0) {

                    tecto.setAltura((Double.parseDouble(field1.getText())));
                    tecto.setLargura((Double.parseDouble(field2.getText())));
                    tecto.setArea(tecto.getAltura() * tecto.getLargura());

                    paredeNorte.setAltura((Double.parseDouble(field3.getText())));
                    paredeNorte.setLargura((Double.parseDouble(field2.getText())));
                    paredeNorte.setArea(paredeNorte.getAltura() * paredeNorte.getLargura());

                    paredeOeste.setAltura((Double.parseDouble(field3.getText())));
                    paredeOeste.setLargura((Double.parseDouble(field1.getText())));
                    paredeOeste.setArea(paredeOeste.getAltura() * paredeOeste.getLargura());

                    paredeSul.setAltura((Double.parseDouble(field3.getText())));
                    paredeSul.setLargura((Double.parseDouble(field2.getText())));
                    paredeSul.setArea(paredeSul.getAltura() * paredeSul.getLargura());

                    paredeEste.setAltura((Double.parseDouble(field3.getText())));
                    paredeEste.setLargura((Double.parseDouble(field1.getText())));
                    paredeEste.setArea(paredeEste.getAltura() * paredeEste.getLargura());

                    chao.setAltura((Double.parseDouble(field1.getText())));
                    chao.setLargura((Double.parseDouble(field2.getText())));
                    chao.setArea(chao.getAltura() * chao.getLargura());

                    dc.setAltura((Double.parseDouble(field3.getText())));
                    dc.setComprimento((Double.parseDouble(field1.getText())));
                    dc.setLargura((Double.parseDouble(field2.getText())));
                    dc.setAreaTotal();
                    field4.setText(Double.toString(dc.getAreaTotal()));
                    revalidate();
                    jpanel3.removeAll();

                    for (Limite lim : dc.getListaLim()) {
                        double areaTmp = lim.getArea();
                        for (Abertu aber : lim.getListaAberturas()) {
                            areaTmp -= aber.getArea();
                            if (dc.getNumPessoas() == 0) {
                                if (areaTmp < 0) {
                                    jpanel2.removeAll();
                                    lim.getListaAberturas().clear();
                                    JOptionPane.showMessageDialog(rootPane, mensagens.getString("dimReduzidas"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }
                            }
                        }
                        for (Camada cam : lim.getListaCamadas()) {
                            JPanel a = new JPanel(new FlowLayout());
                            JLabel b = new JLabel(cam.toString());
                            JButton c = new JButton(icon);
                            c.setPreferredSize(BTN_TAMANHO);
                            c.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    JanelaCamada jan = new JanelaCamada(dc.getMensagens().getString("dadosCamad"), dc, JanelaSimu.this, false, posi);

                                    jan.field1.setSelectedItem(lim);
                                    jan.field1.setEnabled(false);
                                    jan.field2.setSelectedItem(cam.getMaterial().getNome());
                                    jan.field3.setText(Double.toString(lim.getAltura()));
                                    jan.field4.setText(Double.toString(lim.getLargura()));
                                    jan.field6.setText("" + cam.getEspessura());

                                }
                            });

                            a.add(b);
                            a.add(c);

                            jpanel3.add(a, posi);
                            jpanel3.revalidate();
                            posi++;
                        }
                    }
                    posi = 0;
                } else {
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");
                    field4.setText("");
                    JOptionPane.showMessageDialog(rootPane, mensagens.getString("parametrosPositivos"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);

                }
            }
            revalidate();
        } catch (NumberFormatException | HeadlessException ex) {

            JOptionPane.showMessageDialog(rootPane, mensagens.getString("dadosInv"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);

        }
    }

    /**
     *
     * Método para criar a primeira tabbePane (Dimensões do ambiente)
     *
     * @return
     */
    protected JPanel panel1() {

        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JPanel panel1 = new JPanel();
        JLabel label1;
        JLabel l1;
        JLabel label0 = new JLabel(mensagens.getString("dimAmbiente"), JLabel.CENTER);
        label0.setPreferredSize(LABEL_TAMANHO2);
        panel0.add(label0);

        label1 = new JLabel(mensagens.getString("comprimento"), JLabel.RIGHT);
        l1 = new JLabel("m", JLabel.LEFT);
        label1.setPreferredSize(LABEL_TAMANHO2);
        field1 = new JTextField();
        field1.setToolTipText(mensagens.getString("comprimentoTip"));
        field1.setPreferredSize(CAMPO_TAMANHO);
        if (dc.getComprimento() != 0) {
            field1.setText("" + dc.getComprimento());
        }

        field1.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {

                jfield1();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jfield1();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                jfield1();
            }
        });

        panel1.add(label1);
        panel1.add(field1);
        panel1.add(l1);

        JPanel panel2 = new JPanel();
        JLabel l2;
        JLabel label2;
        label2 = new JLabel(mensagens.getString("largura"), JLabel.RIGHT);
        l2 = new JLabel("m", JLabel.LEFT);
        label2.setPreferredSize(LABEL_TAMANHO2);

        field2 = new JTextField();
        field2.setToolTipText(mensagens.getString("larguraTip"));
        field2.setPreferredSize(CAMPO_TAMANHO);
        if (dc.getLargura() != 0) {
            field2.setText("" + dc.getLargura());
        }

        field2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //nothing
            }
        });

        field2.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {

                jfield1();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                jfield1();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                jfield1();

            }
        });

        panel2.add(label2);
        panel2.add(field2);
        panel2.add(l2);

        JPanel panel3 = new JPanel();
        JLabel l3;
        JLabel label3;
        label3 = new JLabel(mensagens.getString("altura"), JLabel.RIGHT);
        l3 = new JLabel("m", JLabel.LEFT);
        label3.setPreferredSize(LABEL_TAMANHO2);

        field3 = new JTextField();
        field3.setToolTipText(mensagens.getString("alturaTip"));
        field3.setPreferredSize(CAMPO_TAMANHO);
        if (dc.getAltura() != 0) {
            field3.setText("" + dc.getAltura());
        }

        field3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //nothing
            }
        });

        field3.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {

                jfield1();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                jfield1();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                jfield1();

            }
        });

        panel3.add(label3);
        panel3.add(field3);
        panel3.add(l3);

        JPanel panel4 = new JPanel();
        JLabel label4;
        JLabel l4;
        label4 = new JLabel(mensagens.getString("areaTotal"), JLabel.RIGHT);
        l4 = new JLabel("m²", JLabel.LEFT);
        label4.setPreferredSize(LABEL_TAMANHO2);
        field4 = new JTextField();
        field4.setPreferredSize(CAMPO_TAMANHO);

        field4.setEditable(false);
        if (dc.getAreaTotal() != 0) {
            field4.setText(dc.getAreaTotal() + "");
        }
        panel4.add(label4);
        panel4.add(field4);
        panel4.add(l4);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");

        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (field1.getText().equals("") || field2.getText().equals("") || field3.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, mensagens.getString("preenchaTudo"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);

                    } else if (Float.parseFloat(field1.getText()) <= 0 || Float.parseFloat(field2.getText()) <= 0 || Float.parseFloat(field3.getText()) <= 0) {
                        JOptionPane.showMessageDialog(rootPane, mensagens.getString("parametrosPositivos"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);
                        field1.setText("");
                        field2.setText("");
                        field3.setText("");

                    } else {
                        jt.setEnabledAt(1, true);
                        jt.setSelectedIndex(1);
                    }
                } catch (NumberFormatException erro) {
                    JOptionPane.showMessageDialog(rootPane, mensagens.getString("dadosInv"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");
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

    /**
     *
     * Método responsável por criar a 3ªTabbedPane (Aberturas da sala)
     *
     * @return
     */
    protected JPanel panel2() {

        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        JPanel center = new JPanel(new BorderLayout());
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel1 = new JPanel(new BorderLayout());
        JLabel label1 = new JLabel(mensagens.getString("aberturas"), JLabel.CENTER);
        label1.setPreferredSize(LABEL_TAMANHO2);
        panel1.add(label1, BorderLayout.NORTH);
        jpanel2 = new JPanel();
        if (dc.getListaAberturas() != null) {
            List<Abertu> d = dc.getListaAberturas();
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

        btnAdicionar = new JButton(mensagens.getString("adicionar"));
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JanelaAber ja = new JanelaAber(mensagens.getString("dadosaber"), dc, JanelaSimu.this, true, 0);
                revalidate();
                jpanel2.revalidate();
                scroll.revalidate();
                panel1.revalidate();
            }
        });

        btnAdicionar.setPreferredSize(CAMPO_TAMANHO);
        panel3.add(btnAdicionar);

        JButton btnRemover;
        btnRemover = new JButton(icon2);
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Limite l : dc.getListaLim()) {
                    l.getListaAberturas().clear();
                }
                jpanel2.removeAll();
                jpanel2.revalidate();
                jpanel2.repaint();
            }

        });
        btnRemover.setPreferredSize(CAMPO_TAMANHO);
        panel3.add(btnRemover);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dc.getListaAberturas().isEmpty()) {
                    JOptionPane.showMessageDialog(null, mensagens.getString("peloMenos1Abert"), mensagens.getString("dadosInv"), JOptionPane.INFORMATION_MESSAGE);
                } else {
                    jt.setEnabledAt(3, true);
                    jt.setSelectedIndex(3);
                }
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

    /**
     *
     * Método responsável por criar a 4ª tabbedPane (Pessoas na sala)
     *
     * @return
     */
    protected JPanel panel3() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JLabel label0;
        JPanel panel1;
        JLabel label1;
        label0 = new JLabel(mensagens.getString("pessoas"), JLabel.CENTER);
        label0.setPreferredSize(LABEL_TAMANHO2);
        panel0.add(label0);

        panel1 = new JPanel();
        label1 = new JLabel(mensagens.getString("numPessoas"), JLabel.RIGHT);
        label1.setPreferredSize(LABEL_TAMANHO2);
        JTextField field1 = new JTextField();
        field1.setPreferredSize(CAMPO_TAMANHO);
        if (dc.getNumPessoas() != 0) {
            field1.setText("" + dc.getNumPessoas());
        }
        field1.setPreferredSize(CAMPO_TAMANHO);
        panel1.add(label1);
        panel1.add(field1);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dc.setNumPessoas(Integer.valueOf((String) field1.getText()));
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

    /**
     *
     * Método responsável por criar a 2ª tabbedPane (Camadas da 2ª sala)
     *
     * @return
     */
    protected JPanel panel5() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        JPanel center = new JPanel(new BorderLayout());
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel1 = new JPanel(new BorderLayout());
        JLabel label1;
        label1 = new JLabel(mensagens.getString("camadasSala"), JLabel.CENTER);
        label1.setPreferredSize(LABEL_TAMANHO2);
        panel1.add(label1, BorderLayout.NORTH);
        jpanel3 = new JPanel();
        if (dc.getListaCamadas() != null) {
            List<Camada> d = dc.getListaCamadas();
            for (Camada listaCam1 : dc.getListaCamadas()) {
                JPanel a = new JPanel(new FlowLayout());
                JLabel b = new JLabel(listaCam1.toString());
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

        JPanel panel3 = new JPanel(new FlowLayout());
        JButton btnAdicionar;

        btnAdicionar = new JButton(mensagens.getString("adicionar"));
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JanelaCamada ja = new JanelaCamada(dc.getMensagens().getString("dadosCamad"), dc, JanelaSimu.this, true, 0);
                revalidate();
                jpanel3.revalidate();
                scroll.revalidate();
                panel1.revalidate();
            }
        });

        btnAdicionar.setPreferredSize(CAMPO_TAMANHO);
        panel3.add(btnAdicionar);

        JButton btnRemover;

        btnRemover = new JButton(icon2);
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Limite l : dc.getListaLim()) {
                    l.getListaCamadas().clear();
                }
                jpanel3.removeAll();
                jpanel3.revalidate();
                jpanel3.repaint();
            }

        });

        btnRemover.setPreferredSize(CAMPO_TAMANHO);
        panel3.add(btnRemover);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = true;
                for(Limite lim:dc.getListaLim()){
                    if( lim.getListaCamadas().isEmpty()){
                        flag=false;
                        
                        JOptionPane.showMessageDialog(rootPane, mensagens.getString("inserCam"));
                        break;
                    }
                    
                    }
                
                
                if(flag){
                jt.setEnabledAt(2, true);
                jt.setSelectedIndex(2);
                }
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

    /**
     *
     * Método para criar a 6ª tabbedPane (Número de aparelhos na sala)
     *
     * @return
     */
    protected JPanel panel6() {

        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JPanel panel1;
        JLabel label1, l1, label0;
        label0 = new JLabel(mensagens.getString("aparelhosSala"), JLabel.CENTER);
        label0.setPreferredSize(LABEL_TAMANHO2);
        panel0.add(label0);

        panel1 = new JPanel();
        label1 = new JLabel(mensagens.getString("numAparelhos"), JLabel.RIGHT);
        l1 = new JLabel("      ");
        JTextField field1 = new JTextField();
        field1.setPreferredSize(CAMPO_TAMANHO);
        if (dc.getNumAparelhos() != 0) {
            field1.setText("" + dc.getNumAparelhos());
        }
        label1.setPreferredSize(LABEL_TAMANHO2);
        panel1.add(label1);
        panel1.add(field1);
        panel1.add(l1);

        JPanel panel5 = new JPanel();
        JButton btnMoveRight1 = new JButton(">>");
        btnMoveRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (field1.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, mensagens.getString("preenchaTudo"), "FSIAP", JOptionPane.INFORMATION_MESSAGE);

                    } else if (Float.parseFloat(field1.getText()) < 0) {
                        field1.setText("");
                        JOptionPane.showMessageDialog(rootPane, mensagens.getString("parametrosPositivos"), "FSIAP", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        dc.setNumAparelhos((Integer.parseInt(field1.getText())));
                        jt.setSelectedIndex(5);
                        jt.setEnabledAt(5, true);
                    }
                } catch (HeadlessException b) {
                    System.out.println(b.getLocalizedMessage());
                } catch (NumberFormatException m) {
                    JOptionPane.showMessageDialog(rootPane, mensagens.getString("dadosInv"), "FSIAP", JOptionPane.INFORMATION_MESSAGE);
                }
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

    /**
     *
     * Método para criar a 6ª tabbedPane (Temperatura fora da sala e a
     * pretendida )
     *
     * @return
     */
    protected JPanel panel7() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JLabel label0, label1;
        JPanel panel1;
        label0 = new JLabel(mensagens.getString("temperatura") + ": ", JLabel.CENTER);
        label0.setPreferredSize(LABEL_TAMANHO2);
        panel0.add(label0);

        panel1 = new JPanel();
        label1 = new JLabel(mensagens.getString("temperaturadesej"), JLabel.RIGHT);
        JLabel l1 = new JLabel("ºC", JLabel.LEFT);

        label1.setPreferredSize(LABEL_TAMANHO2);
        JTextField field1 = new JTextField();
        if (dc.getTemperaturaPre() != 0) {
            field1.setText("" + dc.getTemperaturaPre());
        }
        field1.setPreferredSize(CAMPO_TAMANHO);
        panel1.add(label1);
        panel1.add(field1);
        panel1.add(l1);

        JPanel panel2 = new JPanel();
        JLabel label2;
        label2 = new JLabel(mensagens.getString("temperaturaExt"), JLabel.RIGHT);
        JLabel l2 = new JLabel("ºC", JLabel.LEFT);

        label2.setPreferredSize(LABEL_TAMANHO2);
        JTextField field2 = new JTextField();
        if (dc.getTemperaturaEx() != 0) {
            field2.setText("" + dc.getTemperaturaEx());
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

                    if (!field1.getText().equals("") && !field2.getText().equals("")) {
                        dc.setTemperaturaPre(Float.valueOf(field1.getText()));
                        dc.setTemperaturaEx(Float.valueOf(field2.getText()));
                        jt.setSelectedIndex(6);
                        jt.setEnabledAt(6, true);
                    } else {
                        JOptionPane.showMessageDialog(null, mensagens.getString("preenchaTudo"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException erro) {

                    JOptionPane.showMessageDialog(null, mensagens.getString("dadosInv"), mensagens.getString("erro"), JOptionPane.INFORMATION_MESSAGE);

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

    /**
     *
     * Método para criar a 8ª tabbedPane (calcular o resultado)
     *
     * @return
     */
    protected JPanel panel8() {
        JPanel panel = new JPanel();
        JPanel grid = new JPanel(new GridLayout(4, 1));
        panel.setLayout(new BorderLayout(10, 10));

        JPanel panel0 = new JPanel();
        JLabel label0;
        label0 = new JLabel(mensagens.getString("resultado"), JLabel.CENTER);
        label0.setPreferredSize(LABEL_TAMANHO2);
        panel0.add(label0);

        JPanel jp = new JPanel();

        JPanel panel5 = new JPanel();

        JButton btnCalcular;

        btnCalcular = new JButton(mensagens.getString("calcular"));
        btnCalcular.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int n = 1;
                String s;

                do {

                    s = JOptionPane.showInputDialog(null, mensagens.getString("inserNomePasta"), mensagens.getString("guardarResult"), JOptionPane.PLAIN_MESSAGE);
                    if (s != null) {
                        if (s.equals("")) {

                            s = "sala" + n;
                            while (new File(s).exists()) {
                                n++;
                                s = "sala" + n;
                            }
                        }
                        if (!new File(s).exists()) {
                            File f = new File(s);

                            f.mkdir();

                            try {
                                dc.criarFicheiroHTML(f.getPath());
                                dc.guardarDados(f.getPath());
                                fechar();
                            } catch (IOException ex) {
                                System.out.println(mensagens.getString("ficheiroNCriado"));
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, mensagens.getString("pastaJaExiste"), mensagens.getString("guardarResult"), WIDTH);
                        }
                    } else {
                        break;
                    }
                } while (!new File(s).exists());
            }
        });

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
        String[] opSimNao = {mensagens.getString("sim"), mensagens.getString("nao")};
        resposta = JOptionPane.showOptionDialog(this,
                mensagens.getString("fecharPrograma"),
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
    }

}
