package org.example.soccer.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre; // Nombre de la posicion
    //En esta relacion se asigna ya que una posicion
    @OneToMany(mappedBy = "pos")
    private List<Futbolista> futbolistas;

    public Posicion() {

    }
    public Posicion(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Futbolista> getFutbolistas() {
        return futbolistas;
    }

    public void setFutbolistas(List<Futbolista> futbolistas) {
        this.futbolistas = futbolistas;
    }
}
