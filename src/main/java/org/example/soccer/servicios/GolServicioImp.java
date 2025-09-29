package org.example.soccer.servicios;

import org.example.soccer.repositorio.GolRepo;
import org.example.soccer.repositorio.GolRepoImp;

public class GolServicioImp implements GolServicio {
    GolRepo golRepo;
    public GolServicioImp() {
        golRepo = new GolRepoImp();
    }
}
