package org.example.soccer.ui;

import org.example.soccer.enums.Pos;
import org.example.soccer.modelo.Equipo;
import org.example.soccer.modelo.Futbolista;
import org.example.soccer.modelo.Posicion;
import org.example.soccer.servicios.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class UIFutbolistas {
    private JTextField txtNombre;
    private JTextField txFecha;
    private JTable jtFutbolistas;
    private DefaultTableModel tableModel;
    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JComboBox <Enum> cbPosiciones;
    private JComboBox <Equipo> cbEquipos;
    private JPanel jPanel;
    private JButton volverButton;
    public Futbolista futbolista;
    private EquipoServicio equipoServicios = new EquipoServicioImp();
    private FutbolistaServicio futbolistaServicio = new FutbolistaServicioImp();
    private PosicionServicio posicionServicios = new PosicionServicioImp();
    private List<Equipo> listaEquipos;
    private List<Futbolista> listaFutbolistas = new ArrayList<>();
    private List<Posicion> listaPosiciones;
    private PosicionServicio posicionServicio = new PosicionServicioImp();


    public static void main(String[] args) {
        JFrame frame = new JFrame("UIFutbolistas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new UIFutbolistas().jPanel);
        frame.pack();
        frame.setSize(650,520);
        frame.setVisible(true);
    }

    public UIFutbolistas() {
       agregarPosicion();
        llenarTabla();
        //Cuando se haga clik en la tabla
        jtFutbolistas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int seleccion = jtFutbolistas.getSelectedRow();
                if (seleccion != -1) {
                    futbolista = listaFutbolistas.get(seleccion);
                    txtNombre.setText(jtFutbolistas.getValueAt(seleccion, 0).toString());
                    cbEquipos.setSelectedItem(jtFutbolistas.getValueAt(seleccion, 1).toString());
                    cbPosiciones.setSelectedItem(jtFutbolistas.getValueAt(seleccion, 2));
                    txFecha.setText(jtFutbolistas.getValueAt(seleccion, 3).toString());
                }
            }
        });

        // Lista donde se obtienen los equipos agregados
        listaEquipos = equipoServicios.obtenerEquipos();

       // Se crea un modelo vacio
        DefaultComboBoxModel<Equipo> modeloEquipos = new DefaultComboBoxModel<>();
        //Se recorre la lista agregando al modelo
        for (Equipo equipo : listaEquipos) {
            modeloEquipos.addElement(equipo);
        }
        // Se asigna  el modelo al JComboBox
        cbEquipos.setModel(modeloEquipos);


        // Lista de posiciones
        listaPosiciones = posicionServicios.listarPosiciones();

        // Se crea  un modelo vacío
        DefaultComboBoxModel<Enum> modeloPosiciones = new DefaultComboBoxModel<>();

       // Recorremos la lista y se agrega cada enum al modelo
        for (Posicion posicion : listaPosiciones) {
            modeloPosiciones.addElement(posicion.getPos());
        }
        // Se asigna el modelo al JComboBox
        cbPosiciones.setModel(modeloPosiciones);

        btnAgregar.addActionListener(e -> {
            agregar();
            llenarTabla();

        });
        btnModificar.addActionListener(e -> {
            modificar();
            llenarTabla();
        });
        btnEliminar.addActionListener(e -> {
            eliminar();
            llenarTabla();
        });
        volverButton.addActionListener(e ->  {
            SwingUtilities.getWindowAncestor(jPanel).dispose(); // cierra el JFrame actual
            inicio inicio = new inicio();
            JFrame frame = new JFrame("inicio");
            frame.setContentPane(inicio.getPanel1());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(650, 520);
            frame.setVisible(true);

        });
    }

    public void agregar(){
        String nombre = txtNombre.getText().trim();
        Equipo equipo = (Equipo) cbEquipos.getSelectedItem();
        Pos posicion = (Pos) cbPosiciones.getSelectedItem();
        String fechaTexto = txFecha.getText().trim();
        if (nombre.isEmpty()|| fechaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Pueden Estar Vacios Los Campos");
        } else {
            Date fecha = Date.valueOf(fechaTexto); //Busca al equipo
            Posicion p1 = posicionServicios.obtenerPosicion(posicion);  // Buscar la posicion seleccionada
            futbolista = new Futbolista(nombre,equipo,p1,fecha);
            futbolistaServicio.agregarFutbolista(futbolista);
            JOptionPane.showMessageDialog(null, "Futbolista agregado correctamente");
            limpiarCampos();
        }
    }

    public void agregarPosicion(){
        List<Posicion> pos = posicionServicios.listarPosiciones();
        if (pos != null) {
            Posicion p2 = new Posicion(Pos.MEDIO);
            Posicion p3 = new Posicion(Pos.PORTERO);
            Posicion p4 = new Posicion(Pos.DEFENSA);
            Posicion p1 = new Posicion(Pos.DELANTERO);
            posicionServicio .agregarPosicion(p1);
            posicionServicio .agregarPosicion(p2);
            posicionServicio .agregarPosicion(p3);
            posicionServicio .agregarPosicion(p4);
        }

    }

    public void modificar() {
        if (txtNombre.getText().isEmpty() || txFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes Selecionar Un Futbolista");
        } else {
            futbolista.setNombre(txtNombre.getText());
            futbolista.setEquipo(equipoServicios.obtenerEquipo(cbEquipos.getSelectedItem().toString()));
            futbolista.setPos(posicionServicios.obtenerPosicion((Pos) cbPosiciones.getSelectedItem()));
            futbolista.setFechaN(Date.valueOf(txFecha.getText()));
            futbolistaServicio.actualizarFutbolista(futbolista);
            JOptionPane.showMessageDialog(null, "Futbolista Modificado correctamente");
            limpiarCampos();
        }
    }

    public void eliminar(){
        if (txtNombre.getText().isEmpty() || txFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes Selecionar Un Futbolista");
        } else {
            futbolista.setNombre(txtNombre.getText());
            futbolista.setEquipo(equipoServicios.obtenerEquipo(cbEquipos.getSelectedItem().toString()));
            futbolista.setPos(posicionServicios.obtenerPosicion((Pos) cbPosiciones.getSelectedItem()));
            futbolista.setFechaN(Date.valueOf(txFecha.getText()));
            futbolistaServicio.eliminarFutbolista(futbolista);
            JOptionPane.showMessageDialog(null, "Futbolista Elimnado correctamente");
            limpiarCampos();
        }
    }
    public void llenarTabla (){
        tableModel = new  DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Equipo");
        tableModel.addColumn("Posicion");
        tableModel.addColumn("Fecha Nacimiento");
        listaFutbolistas = futbolistaServicio.obtenerFutbolistas();
        for (Futbolista futbolista : listaFutbolistas) {
            tableModel.addRow(new Object[]{futbolista.getNombre(),
                                           futbolista.getEquipo().getNombre(),
                                           futbolista.getPos().getPos(),
                                           futbolista.getFechaN()});
        }
        jtFutbolistas.setModel(tableModel);

    }
    private void limpiarCampos(){
        txtNombre.setText("");
        txFecha.setText("");
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }
}
