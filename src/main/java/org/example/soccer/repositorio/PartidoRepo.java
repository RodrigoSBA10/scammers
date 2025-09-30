package org.example.soccer.repositorio;

import org.example.soccer.modelo.Partido;

import java.util.List;

public interface PartidoRepo {
    void agregarPartido(Partido partido);
    List<Partido> obtenerPartidos();
    void editarPartido(Partido partido);
    void eliminarPartido(Partido partido);
}
