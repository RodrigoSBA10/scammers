package org.example.soccer.modelo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Equipo")
    private int id;
    private String nombre;
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.REMOVE)
    private List<Futbolista> futbolistas;


    public Equipo() {
    }

    public Equipo(String nombre) {
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

    @Override
    public String toString() {
        return nombre;
    }
}
