package org.example.soccer.servicios;

import org.example.soccer.repositorio.FutbolistaRepo;
import org.example.soccer.repositorio.FutbolistaRepoImp;

public class FutbolistaServicioImp implements FutbolistaServicio {
    FutbolistaRepo futbolista;
    public FutbolistaServicioImp() {
        futbolista = new FutbolistaRepoImp();
    }
}
