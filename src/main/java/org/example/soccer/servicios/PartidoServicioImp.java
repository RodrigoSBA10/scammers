package org.example.soccer.servicios;

import org.example.soccer.modelo.Partido;
import org.example.soccer.repositorio.PartidoRepo;
import org.example.soccer.repositorio.PartidoRepoImp;

import java.util.List;

public class PartidoServicioImp implements  PartidoServicio {
    PartidoRepo partidoRepo;
    public PartidoServicioImp(){
        partidoRepo = new PartidoRepoImp();
    }

    @Override
    public void agregarPartido(Partido partido) {
        partidoRepo.agregarPartido(partido);
    }

    @Override
    public List<Partido> obtenerPartidos() {
        return partidoRepo.obtenerPartidos();
    }

    @Override
    public void editarPartido(Partido partido) {
        partidoRepo.editarPartido(partido);
    }

    @Override
    public void eliminarPartido(Partido partido) {
        partidoRepo.eliminarPartido(partido);
    }
}
