package org.example.soccer.servicios;

import org.example.soccer.modelo.Futbolista;

import java.util.List;

public interface FutbolistaServicio {
    void agregarFutbolista(Futbolista f);
    void actualizarFutbolista(Futbolista f);
    void eliminarFutbolista(Futbolista f);
    List<Futbolista> obtenerFutbolistas();


}
