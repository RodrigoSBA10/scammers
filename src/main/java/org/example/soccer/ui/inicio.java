package org.example.soccer.ui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class inicio {
    private JPanel panel1;
    private JButton btnSalir;
    private JButton btnAgregarFutb;
    private JButton btnEquipo;
    private JButton btnPartidos;
    private JButton btnGoles;
    private JLabel image;

    public static void main(String[] args) {

        JFrame frame = new JFrame("inicio");
        frame.setContentPane(new inicio().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Inicio");
        frame.setVisible(true);
    }
    public inicio() {
        btnSalir.addActionListener(e->{
          System.exit(0);
        });
        btnAgregarFutb.addActionListener(e->{ // cierra el JFrame actual
            UIFutbolistas futbolistas = new UIFutbolistas();
            JFrame frame = new JFrame("UIFutbolistas");
            frame.setContentPane(futbolistas.getjPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            SwingUtilities.getWindowAncestor(panel1).dispose();
        });
        btnEquipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFrame frame = new JFrame("UIFutbolistas");
                UIEquipos equipos = new UIEquipos();
                frame.setContentPane(equipos.getPanel1());
                frame.pack();
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(panel1).dispose();
            }
        });
        btnPartidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFrame frame = new JFrame("UIPartidos");
                UIPartidos partidos = new UIPartidos();
                frame.setContentPane(partidos.getPanel1());
                frame.pack();
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(panel1).dispose();
            }
        });
        btnGoles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFrame frame = new JFrame("UIGoles");
                UIGoles goles = new UIGoles();
                frame.setContentPane(goles.getPanel());
                frame.pack();
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(panel1).dispose();
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}
