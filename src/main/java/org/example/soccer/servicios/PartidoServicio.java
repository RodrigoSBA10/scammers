package org.example.soccer.servicios;

import org.example.soccer.modelo.Partido;

import java.util.List;

public interface PartidoServicio {
    void agregarPartido(Partido partido);
    List<Partido> obtenerPartidos();
    void editarPartido(Partido partido);
    void eliminarPartido(Partido partido);
}
