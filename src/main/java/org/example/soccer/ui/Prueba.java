package org.example.soccer.ui;

import javax.swing.*;

public class Prueba {
    private JButton btnPrueba;
    private JPanel panel1;


    public Prueba() {
        btnPrueba.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,"Iniciar Prueba Base");
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Prueba");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Prueba().panel1);
        frame.pack();
        frame.setSize(500,500);
        frame.setVisible(true);



    }




}
