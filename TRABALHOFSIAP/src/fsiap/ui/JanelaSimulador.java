/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsiap.ui;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author i130348
 */
public class JanelaSimulador extends JDialog {

    /**
     * A Posição da janela.
     */
    private static final int JANELA_POSICAO_X = 700, JANELA_POSICAO_Y = 200;

    public JanelaSimulador(JFrame pai) {

        super(pai, "Capacidade Térmica de uma Sala de Computadores");

        JTabbedPane jt = new JTabbedPane();

        GridLayout gl = new GridLayout(2, 1);
        setLayout(gl);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(450, 230);
        setResizable(false);
        setLocation(JANELA_POSICAO_X, JANELA_POSICAO_Y);
        setVisible(true);

    }

}
