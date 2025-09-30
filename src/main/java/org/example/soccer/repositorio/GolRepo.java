package org.example.soccer.repositorio;

import org.example.soccer.modelo.Gol;

import java.util.List;

public interface GolRepo {
    void agregarGol(Gol gol);
    List<Gol> obtenerGoles();
    void editarGol(Gol gol);
    void eliminarGol(Gol gol);
}
