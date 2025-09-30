package org.example.soccer.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "goles")
public class Gol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Gol")
    private int id;
    @ManyToOne
    private Partido partido;
    @ManyToOne
    private Futbolista futbolista;
    @Column (name = "minuto")
    private int min;

    public Gol() {
    }

    public Gol(Partido partido, Futbolista futbolista, int min) {
        this.partido = partido;
        this.futbolista = futbolista;
        this.min = min;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Futbolista getFutbolista() {
        return futbolista;
    }

    public void setFutbolista(Futbolista futbolista) {
        this.futbolista = futbolista;
    }

    public int getMin() {
        return min;
    }

    public void setMIn(int hora) {
        this.min = hora;
    }

    @Override
    public String toString() {
        return partido + " " + futbolista.getNombre() + " " + min;
    }
}
