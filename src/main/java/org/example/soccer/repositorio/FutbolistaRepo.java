package org.example.soccer.repositorio;

import org.example.soccer.modelo.Equipo;
import org.example.soccer.modelo.Futbolista;

import java.util.List;

public interface FutbolistaRepo {
    Futbolista agregarFutbolista(Futbolista f);
    void actualizarFutbolista(Futbolista f);
    void eliminarFutbolista(Futbolista f);
    List<Futbolista> obtenerFutbolistas();
    }
