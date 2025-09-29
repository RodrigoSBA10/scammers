package org.example.soccer.ui;

import org.example.soccer.modelo.Equipo;
import org.example.soccer.servicios.EquipoServicio;
import org.example.soccer.servicios.EquipoServicioImp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class UIEquipos {
    private JPanel panel1;
    private JLabel equiposLabel;
    private JTextField txtNombre;
    private JButton btnAgregar;
    private JTable tableEquipos;
    private JTextField txtEdit;
    private JButton btnEditar;
    private JButton eliminarButton;
    private EquipoServicio equipoServicios = new EquipoServicioImp();
    private Equipo equipo;
    private DefaultTableModel model;
    private List<Equipo> listaEquipos = new ArrayList<>();

    public UIEquipos() {
        configurarTabla();
        llenarTabla();
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEquipo();
            }
        });
        tableEquipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila =  tableEquipos.rowAtPoint(e.getPoint());
                if (fila >= 0) {
                    tableEquipos.setRowSelectionInterval(fila, fila);
                    if (listaEquipos != null && fila < listaEquipos.size()) {
                        equipo =  listaEquipos.get(fila);
                        txtEdit.setText(equipo.getNombre());
                        txtEdit.setEditable(true);

                    }
                }
            }
        });
        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(!txtEdit.getText().isEmpty()){
                    equipo.setNombre(txtEdit.getText());
                    equipoServicios.editarEquipo(equipo);
                    txtEdit.setText("");
                    txtEdit.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Equipo editado");
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un equipo de la tabla para editar");
                }

            }
        });
        eliminarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!txtEdit.getText().isEmpty()){
                    equipoServicios.eliminarEquipo(equipo);
                    txtEdit.setText("");
                    txtEdit.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Equipo eliminado");
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un equipo de la tabla para eliminar");
                }
            }
        });
    }

    public void configurarTabla() {
        txtEdit.setEditable(false);
        tableEquipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableEquipos.setRowSelectionAllowed(true);
        tableEquipos.setRowHeight(30);
    }

    public void llenarTabla() {
        model = new DefaultTableModel();
        model.addColumn("Nombre");
        listaEquipos = equipoServicios.obtenerEquipos();
        if (listaEquipos != null){
            for(Equipo equipo : listaEquipos){
                model.addRow(new Object[]{equipo.getNombre()});
            }
        }
        tableEquipos.setModel(model);
    }

    private void agregarEquipo() {
        if (!txtNombre.getText().isEmpty()) {
            Equipo nuevo  = new Equipo(txtNombre.getText());
            equipoServicios.agregarEquipo(nuevo);
            JOptionPane.showMessageDialog(null, "Equipo " + nuevo + " agregado" );
            txtNombre.setText("");
            llenarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre" +
                    " para agregar");
        }
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("UIEquipos");
                frame.setContentPane(new UIEquipos().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
