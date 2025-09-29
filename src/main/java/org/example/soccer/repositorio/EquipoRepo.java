package org.example.soccer.repositorio;

import org.example.soccer.modelo.Equipo;

import java.util.List;

public interface EquipoRepo {

    public List<Equipo> obtenerEquipos();
    public void agregarEquipo(Equipo equipo);
    public void eliminarEquipo(Equipo equipo);
    public void editarEquipo(Equipo equipo);
    Equipo obtenerEquipo(String nombre);
}
