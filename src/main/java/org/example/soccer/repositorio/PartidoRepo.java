package org.example.soccer.repositorio;

import org.example.soccer.modelo.Partido;

import java.util.List;

public interface PartidoRepo {
    public void agregarPartido(Partido partido);
    public List<Partido> obtenerPartidos();
    public void editarPartido(Partido partido);
    public void eliminarPartido(Partido partido);
}
