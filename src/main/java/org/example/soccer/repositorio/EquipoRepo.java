package org.example.soccer.repositorio;

import org.example.soccer.modelo.Equipo;

import java.util.List;

public interface EquipoRepo {

    List<Equipo> obtenerEquipos();
    void agregarEquipo(Equipo equipo);
    void eliminarEquipo(Equipo equipo);
    void editarEquipo(Equipo equipo);
}
