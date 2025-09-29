package org.example.soccer.servicios;

import org.example.soccer.enums.Pos;
import org.example.soccer.modelo.Posicion;

import java.util.List;

public interface PosicionServicio {
    Posicion agregarPosicion(Posicion posicion);
    List<Posicion> listarPosiciones();
    void actualizarPosicion(Posicion posicion);
}
