package org.example.soccer.servicios;

import org.example.soccer.modelo.Gol;
import org.example.soccer.repositorio.GolRepo;
import org.example.soccer.repositorio.GolRepoImp;

import java.util.List;

public class GolServicioImp implements GolServicio {
    GolRepo golRepo;
    public GolServicioImp() {
        golRepo = new GolRepoImp();
    }

    @Override
    public void agregarGol(Gol gol) {
        golRepo.agregarGol(gol);
    }

    @Override
    public List<Gol> obtenerGoles() {
        return golRepo.obtenerGoles();
    }

    @Override
    public void editarGol(Gol gol) {
        golRepo.editarGol(gol);
    }

    @Override
    public void eliminarGol(Gol gol) {
        golRepo.eliminarGol(gol);
    }


}
