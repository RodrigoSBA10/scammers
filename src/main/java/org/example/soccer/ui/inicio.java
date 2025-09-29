package org.example.soccer.ui;
import javax.swing.*;

public class inicio {
    private JPanel panel1;
    private JButton btnSalir;
    private JButton btnAgregarFutb;
    private JButton bntAgregarPar;
    private JButton bntAgregarEqu;

    public static void main(String[] args) {

        JFrame frame = new JFrame("inicio");
        frame.setContentPane(new inicio().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(650,520);
        frame.setTitle("Inicio");
        frame.setVisible(true);
    }
    public inicio() {
        btnSalir.addActionListener(e->{
          System.exit(0);
        });
        btnAgregarFutb.addActionListener(e->{
            SwingUtilities.getWindowAncestor(panel1).dispose(); // cierra el JFrame actual
            UIFutbolistas futbolistas = new UIFutbolistas();
            JFrame frame = new JFrame("UIFutbolistas");
            frame.setContentPane(futbolistas.getjPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(650, 520);
            frame.setVisible(true);
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}
