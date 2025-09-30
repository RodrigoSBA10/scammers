package org.example.soccer.repositorio;

import org.example.soccer.modelo.Posicion;

import java.util.List;

public interface PosicionRepo {
    Posicion agregarPosicion(Posicion posicion);
    List<Posicion> listarPosiciones();
    void actualizarPosicion(Posicion posicion);

}
