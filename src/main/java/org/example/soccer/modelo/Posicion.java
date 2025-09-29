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
    //En esta relacion se asigna ya que una posicion
    @OneToMany(mappedBy = "pos")
    private List<Futbolista> futbolistas;

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

    public List<Futbolista> getFutbolistas() {
        return futbolistas;
    }

    public void setFutbolistas(List<Futbolista> futbolistas) {
        this.futbolistas = futbolistas;
    }

    @Override
    public String toString() {
        return "Posicion{" +
                "id=" + id +
                '}';
    }
}
