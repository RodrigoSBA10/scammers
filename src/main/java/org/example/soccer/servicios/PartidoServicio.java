package org.example.soccer.servicios;

import org.example.soccer.modelo.Partido;

import java.util.List;

public interface PartidoServicio {
    public void agregarPartido(Partido partido);
    public List<Partido> obtenerPartidos();
    public void editarPartido(Partido partido);
    public void eliminarPartido(Partido partido);
}
