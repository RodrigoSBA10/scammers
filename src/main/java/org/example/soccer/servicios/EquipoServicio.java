package org.example.soccer.servicios;

import org.example.soccer.modelo.Equipo;

import java.util.List;

public interface EquipoServicio {
    List<Equipo> obtenerEquipos();
    void agregarEquipo(Equipo equipo);
    void eliminarEquipo(Equipo equipo);
    void editarEquipo(Equipo equipo);
}
