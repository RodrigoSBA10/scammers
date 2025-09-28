package org.example.soccer.servicios;

import org.example.soccer.modelo.Equipo;
import org.example.soccer.repositorio.EquipoRepo;
import org.example.soccer.repositorio.EquipoRepoImp;

import java.util.List;

public class EquipoServicioImp implements EquipoServicio{
    EquipoRepo equipoRepo;

    public EquipoServicioImp() {
        equipoRepo = new EquipoRepoImp();
    }

    @Override
    public List<Equipo> obtenerEquipos() {
        return equipoRepo.obtenerEquipos();
    }

    @Override
    public void agregarEquipo(Equipo equipo) {
        equipoRepo.agregarEquipo(equipo);
    }

    @Override
    public void eliminarEquipo(Equipo equipo) {
        equipoRepo.eliminarEquipo(equipo);
    }

    @Override
    public void editarEquipo(Equipo equipo) {
        equipoRepo.editarEquipo(equipo);
    }
}
