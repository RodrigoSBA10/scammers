package org.example.soccer.ui;
import javax.swing.*;

public class inicio {
    private JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Inicio");
        frame.setContentPane(new inicio().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,500);
        frame.setTitle("Inicio");
        frame.setVisible(true);
    }
}
