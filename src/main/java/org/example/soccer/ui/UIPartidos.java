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
    private JTable tablaEquipos;
    private JTextField txtLocal;
    private JTextField txtVisitante;
    private JTextField txtGolesL;
    private JTextField txtGolesV;
    private JButton btnEditar;
    private JButton btnAgregar;
    private JTable tablaPartidos;
    private JButton btnEliminar;
    private List<Equipo> equipos;
    private List<Partido> partidos;
    private DefaultTableModel model;
    private EquipoServicio equipoServicio = new EquipoServicioImp();
    private Equipo eqipoL;
    private Equipo eqipoV;
    private Partido partido;
    private int bandera = 0;
    private JButton btnElimar;

    public  UIPartidos() {
        configurarTablaEquipos();
        llenarTablaEquipos();
        llenarTablaPartidos();

        btnAgregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (eqipoL != null && eqipoV != null) {
                    if (eqipoV != eqipoL) {
                        if (validarCampos()){
                            if (validarGoles()){
                                partido = new Partido(eqipoL, eqipoV, golesLocal, golesVisitante);
                                partidoServicio.agregarPartido(partido);
                                JOptionPane.showMessageDialog(null, "Partido agregado");
                                txtLocal.setText("Equipo Local");
                                txtVisitante.setText("Equipo Visitante");
                                txtGolesL.setText("");
                                txtGolesV.setText("");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debes elegir dos equipos distintos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por selecciona equipos de la tabla");
                }
            }
        });

        tablaEquipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                bandera++;
                int row = tablaEquipos.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    tablaEquipos.setRowSelectionInterval(row, row);
                    if (equipos != null && row < equipos.size() ) {
                        if (bandera == 1){
                            eqipoL = equipos.get(row);
                            txtLocal.setText(eqipoL.getNombre());
                        }else if (bandera == 2){
                            eqipoV = equipos.get(row);
                            txtVisitante.setText(eqipoV.getNombre());
                        } else {
                            txtLocal.setText("Equipo Local");
                            txtVisitante.setText("Equipo Visitante");
                            bandera = 0;
                        }
                    }
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
                        txtLocal.setText(partido.getLocal().getNombre());
                        txtVisitante.setText(partido.getIdVIsita().getNombre());
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
                if (eqipoL != null && eqipoV != null) {
                    if (eqipoV != eqipoL) {
                        if (validarCampos()){
                            if (validarGoles()){
                                partido.setLocal(eqipoL);
                                partido.setIdVIsita(eqipoV);
                                partido.setgLocal(Integer.parseInt(txtGolesL.getText()));
                                partido.setgVisitante(Integer.parseInt(txtGolesV.getText()));
                                partidoServicio.editarPartido(partido);
                                JOptionPane.showMessageDialog(null, "Partido editado");
                                txtLocal.setText("Equipo Local");
                                txtVisitante.setText("Equipo Visitante");
                                txtGolesL.setText("");
                                txtGolesV.setText("");
                                llenarTablaPartidos();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debes elegir dos equipos distintos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por selecciona equipos de la tabla");
                }
            }
        });
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                partidoServicio.eliminarPartido(partido);
                JOptionPane.showMessageDialog(null, "Partido eliminado");
                llenarTablaPartidos();
            }
        });
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
    public void configurarTablaEquipos() {
        tablaEquipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaEquipos.setRowSelectionAllowed(true);
        tablaEquipos.setRowHeight(30);
        tablaPartidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaPartidos.setRowSelectionAllowed(true);
        tablaPartidos.setRowHeight(30);
    }
    public void llenarTablaEquipos() {
        model = new DefaultTableModel();
        model.addColumn("Equipos");
        equipos = equipoServicio.obtenerEquipos();
        if (equipos != null) {
            for(Equipo equipo : equipos){
                model.addRow(new Object[]{equipo.getNombre()});
            }
        }
        tablaEquipos.setModel(model);
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
}
