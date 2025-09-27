package org.example.soccer.repositorio;

import org.example.soccer.entidades.Futbolista;

import java.util.List;

public interface FutbolistaRepo {
    Futbolista agregarFutbolista(Futbolista f);
    void actualizarFutbolista(Futbolista f);
    boolean eliminarFutbolista(Futbolista f);
    List<Futbolista> obtenerFutbolistas();
}
