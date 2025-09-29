package org.example.soccer.servicios;

import org.example.soccer.modelo.Futbolista;
import org.example.soccer.repositorio.FutbolistaRepo;
import org.example.soccer.repositorio.FutbolistaRepoImp;

import java.util.List;

public class FutbolistaServicioImp implements FutbolistaServicio {
    FutbolistaRepo futbolista;
    public FutbolistaServicioImp() {
        futbolista = new FutbolistaRepoImp();
    }

    @Override
    public Futbolista agregarFutbolista(Futbolista f) {
        return futbolista.agregarFutbolista(f);

    }

    @Override
    public void actualizarFutbolista(Futbolista f) {
        futbolista.actualizarFutbolista(f);
    }

    @Override
    public void eliminarFutbolista(Futbolista f) {
        futbolista.eliminarFutbolista(f);

    }

    @Override
    public List<Futbolista> obtenerFutbolistas() {
        return futbolista.obtenerFutbolistas();
    }
}
