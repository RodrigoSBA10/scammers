package org.example.soccer.modelo;

import jakarta.persistence.*;
import org.example.soccer.enums.Pos;

import java.util.List;

@Entity
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "Posiciones")
    private Pos pos; // Nombre de la posicion

    public Posicion() {

    }

    public Posicion(Pos pos) {
        this.pos = pos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pos getPos() {
        return pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return getPos().toString();
    }
}
