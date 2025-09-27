package org.example.soccer.entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//Solo es de pruba para la asignacion
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEquipo;
    /*Sigue la relacion de equipo con jugadores
      -Donde un equipo contiene muchos futbolistas
      -Un Futbolista Solo Tiene Asignado Un Solo Equipo
     */
    @OneToMany(mappedBy = "equipo")
    private List<Futbolista> futbolistas;

    public Equipo() {

    }
    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    public List<Futbolista> getFutbolistas() {
        return futbolistas;
    }
    public void setFutbolistas(List<Futbolista> futbolistas) {
        this.futbolistas = futbolistas;
    }


}
