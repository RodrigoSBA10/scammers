package org.example.soccer.ui;

import org.example.soccer.servicios.GolServicio;
import org.example.soccer.servicios.GolServicioImp;

import javax.swing.*;

public class UIGOles {
    private JPanel panel;
    private GolServicio golServicio = new GolServicioImp();

    public static void main(String[] args) {
        JFrame frame = new JFrame("UIGOles");
        frame.setContentPane(new UIGOles().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
