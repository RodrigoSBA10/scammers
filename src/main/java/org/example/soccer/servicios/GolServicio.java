package org.example.soccer.servicios;

import org.example.soccer.modelo.Gol;

import java.util.List;

public interface GolServicio {
    void agregarGol(Gol gol);
    List<Gol> obtenerGoles();
    void editarGol(Gol gol);
    void eliminarGol(Gol gol);
}
