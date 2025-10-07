package org.example.soccer.ui;

import org.example.soccer.modelo.Futbolista;
import org.example.soccer.modelo.Gol;
import org.example.soccer.modelo.Partido;
import org.example.soccer.servicios.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UIGoles {
    private JPanel panel;
    private JComboBox cbxPartido;
    private JComboBox cbxJugador;
    private JButton btnAgregar;
    private Gol gol;
    private List<Gol> goles;
    private DefaultTableModel model;
    private JButton editarButton;
    private JButton eliminarButton;
    private JTable tableGoles;
    private JButton volverButton;
    private JTextField txtMInuto;
    private PartidoServicio partidoServicio = new PartidoServicioImp();
    private GolServicio golServicio = new GolServicioImp();
    private FutbolistaServicio futbolistaServicio = new FutbolistaServicioImp();

    public UIGoles() {
        configurarTabla();
        llenarComboboxs();
        llenarTabla();
        btnAgregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Partido p = (Partido) cbxPartido.getSelectedItem();
                Futbolista f = (Futbolista) cbxJugador.getSelectedItem();
                if (!txtMInuto.getText().isEmpty()){
                    try {
                        int minuto = Integer.parseInt(txtMInuto.getText());
                        gol = new Gol(p, f, minuto);
                        golServicio.agregarGol(gol);
                        JOptionPane.showMessageDialog(null, "Gol agregado");
                        llenarTabla();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un numero de minutos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor llena todos los campos");
                }

            }
        });
        volverButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                inicio inicio = new inicio();
                JFrame frame = new JFrame("inicio");
                frame.setContentPane(inicio.getPanel1());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(650, 520);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(panel).dispose();
            }
        });

        tableGoles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = tableGoles.getSelectedRow();
                if (row >= 0) {
                    if (row < goles.size()){
                        gol = goles.get(row);
                        cbxPartido.setSelectedItem(gol.getPartido());
                        cbxJugador.setSelectedItem(gol.getFutbolista());
                        txtMInuto.setText(String.valueOf(gol.getMin()));
                    }
                }
            }
        });
        editarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (gol != null) {
                    if (!txtMInuto.getText().isEmpty()){
                        gol.setPartido((Partido) cbxPartido.getSelectedItem());
                        gol.setFutbolista((Futbolista) cbxJugador.getSelectedItem());
                        try {
                            gol.setMIn(Integer.parseInt(txtMInuto.getText()));
                            golServicio.editarGol(gol);
                            JOptionPane.showMessageDialog(null, "Gol editado");
                            llenarTabla();
                            txtMInuto.setText("");
                            gol = null;
                        }catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Por favor ingrese un numero de minutos");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor seleccione un gol de la tabla");
                }
            }
        });
        eliminarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (gol != null) {
                    golServicio.eliminarGol(gol);
                    txtMInuto.setText("");
                    gol = null;
                    JOptionPane.showMessageDialog(null, "Gol eliminado");
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor seleccione un gol de la tabla para eliminar");
                }
            }
        });
    }
    public void configurarTabla() {
        tableGoles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableGoles.setRowSelectionAllowed(true);
        tableGoles.setRowHeight(30);
    }
    public void llenarTabla(){
        model = new DefaultTableModel();
        model.addColumn("Partido");
        model.addColumn("Jugador");
        model.addColumn("Minuto");
        goles = golServicio.obtenerGoles();
        if (goles != null) {
            for(Gol g : goles){
                model.addRow(new Object[]{g.getPartido(), g.getFutbolista().getNombre(), g.getMin()});
            }
        }
        tableGoles.setModel(model);
    }
    public void llenarComboboxs() {
        List<Partido> partidos;
        List<Futbolista> futbolistas;
        futbolistas = futbolistaServicio.obtenerFutbolistas();
        partidos = partidoServicio.obtenerPartidos();
        if (partidos != null && futbolistas != null) {
            for (Futbolista futbolista : futbolistas) {
                cbxJugador.addItem(futbolista);
            }
            for (Partido partido : partidos) {
                cbxPartido.addItem(partido);
            }
        }
    }


    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

}
