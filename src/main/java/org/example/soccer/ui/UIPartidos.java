package org.example.soccer.ui;

import org.example.soccer.modelo.Equipo;
import org.example.soccer.modelo.Partido;
import org.example.soccer.servicios.EquipoServicio;
import org.example.soccer.servicios.EquipoServicioImp;
import org.example.soccer.servicios.PartidoServicio;
import org.example.soccer.servicios.PartidoServicioImp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UIPartidos {
    private int golesLocal, golesVisitante;
    private PartidoServicio  partidoServicio =  new PartidoServicioImp();
    private JPanel panel1;
    private JTextField txtGolesL;
    private JTextField txtGolesV;
    private JButton btnEditar;
    private JButton btnAgregar;
    private JTable tablaPartidos;
    private JButton btnEliminar;
    private JComboBox<Equipo> cbxLocal;
    private JComboBox<Equipo> cbxVisitante;
    private JButton btnVolver;
    private List<Equipo> equipos;
    private List<Partido> partidos;
    private DefaultTableModel model;
    private EquipoServicio equipoServicio = new EquipoServicioImp();
    private Equipo eqipoL;
    private Equipo eqipoV;
    private Partido partido;
    private JScrollPane scrollPane;

    public  UIPartidos() {
        configurarTabla();
        llenarComboBox();
        llenarTablaPartidos();
        btnAgregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                eqipoL = (Equipo) cbxLocal.getSelectedItem();
                eqipoV = (Equipo) cbxVisitante.getSelectedItem();
                    if (eqipoV != eqipoL) {
                        if (validarCampos()){
                            if (validarGoles()){
                                partido = new Partido(eqipoL, eqipoV, golesLocal, golesVisitante);
                                partidoServicio.agregarPartido(partido);
                                JOptionPane.showMessageDialog(null, "Partido agregado");
                                txtGolesL.setText("");
                                txtGolesV.setText("");
                                llenarTablaPartidos();
                                eqipoL = null;
                                eqipoV = null;
                                partido = null;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debes elegir dos equipos distintos");
                    }
            }
        });
        tablaPartidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = tablaPartidos.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    if (partidos != null && row < partidos.size() ) {
                        partido =  partidos.get(row);
                        eqipoL = partido.getLocal();
                        eqipoV = partido.getIdVIsita();
                        encontrarEquipo(cbxLocal, eqipoL);
                        encontrarEquipo(cbxVisitante, eqipoV);
                        txtGolesL.setText(String.valueOf(partido.getgLocal()));
                        txtGolesV.setText(String.valueOf(partido.getgVisitante()));
                    }
                }
            }
        });
        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                    if (partido != null) {
                        eqipoL = (Equipo) cbxLocal.getSelectedItem();
                        eqipoV = (Equipo) cbxVisitante.getSelectedItem();
                        if (eqipoV != eqipoL) {
                            if (validarCampos()){
                                if (validarGoles()){
                                    partido.setLocal(eqipoL);
                                    partido.setIdVIsita(eqipoV);
                                    partido.setgLocal(Integer.parseInt(txtGolesL.getText()));
                                    partido.setgVisitante(Integer.parseInt(txtGolesV.getText()));
                                    partidoServicio.editarPartido(partido);
                                    JOptionPane.showMessageDialog(null, "Partido editado");
                                    txtGolesL.setText("");
                                    txtGolesV.setText("");
                                    llenarTablaPartidos();
                                    partido = null;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Debes elegir dos equipos distintos");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por seleccionar un partido de la tabla para editar");
                    }

            }
        });
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (partido != null) {
                    partidoServicio.eliminarPartido(partido);
                    JOptionPane.showMessageDialog(null, "Partido eliminado");
                    txtGolesL.setText("");
                    txtGolesV.setText("");
                    llenarTablaPartidos();
                    partido = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Debes elegir un partido de la tabla para eliminar");
                }
            }
        });
        btnVolver.addMouseListener(new MouseAdapter() {
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
                SwingUtilities.getWindowAncestor(panel1).dispose();
            }
        });
    }
    public void encontrarEquipo(JComboBox<Equipo> cbxEquipo, Equipo equipo) {
        for (int i = 0; i<cbxEquipo.getItemCount();i++) {
            Equipo item = cbxEquipo.getItemAt(i);
            if(item.getId() == equipo.getId()){
                cbxEquipo.setSelectedIndex(i);
                return;
            }
        }
    }

    public boolean validarGoles() {
        try {
            golesLocal = Integer.parseInt(txtGolesL.getText().trim());
            golesVisitante = Integer.parseInt(txtGolesV.getText().trim());

            if (golesLocal < 0 || golesVisitante < 0) {
                JOptionPane.showMessageDialog(null, "Los goles deben ser números positivos.");
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
            return false;
        }
    }

    public boolean validarCampos(){
        if (txtGolesL.getText().isEmpty() || txtGolesV.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Llena todos los campos");
            return false;
        }
        return true;
    }
    public void configurarTabla() {
        tablaPartidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaPartidos.setRowSelectionAllowed(true);
        tablaPartidos.setRowHeight(30);
    }
    public void llenarComboBox() {
        equipos = equipoServicio.obtenerEquipos();
        if (equipos != null) {
            for(Equipo equipo : equipos){
                cbxLocal.addItem(equipo);
                cbxVisitante.addItem(equipo);
            }
        }
    }

    public void llenarTablaPartidos() {
        model = new DefaultTableModel();
        model.addColumn("Local");
        model.addColumn("Goles Local");
        model.addColumn("Visitante");
        model.addColumn("Goles Visitante");
        model.addColumn("Fecha");
        partidos = partidoServicio.obtenerPartidos();
        if (partidos != null) {
            for(Partido partido : partidos){
                model.addRow(new Object[]{partido.getLocal().getNombre(),
                    partido.getgLocal(), partido.getIdVIsita().getNombre()
                    , partido.getgVisitante(), partido.getFecha()});
            }
        }
        tablaPartidos.setModel(model);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("UIPartidos");
        frame.setContentPane(new UIPartidos().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

}
