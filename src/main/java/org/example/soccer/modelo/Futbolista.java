package org.example.soccer.modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Futbolista {
    @Id //Identificador unico (PK)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    //Relacion de Equipo
    @ManyToOne
    //Es La CLave Foranea De Equipo
    @JoinColumn(name = "ID_Equipo")
    private Equipo equipo;
    //Relacion de posiciones
    @ManyToOne
    //CLave Forane de Posicion
    @JoinColumn(name = "ID_Pos")
    private Posicion pos;
    //Fecha de nacimiento
    private Date fechaN;

    public Futbolista() {

    }
    //No recibe el ID ya que es un secuenciador
    public Futbolista(String nombre, Equipo equipo, Posicion pos, Date fechaN) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.pos = pos;
        this.fechaN = fechaN;
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

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Posicion getPos() {
        return pos;
    }

    public void setPos(Posicion pos) {
        this.pos = pos;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", equipo=" + equipo.getNombre() +
                ", pos=" + pos.getPos() +
                ", fechaN=" + fechaN +
                '}';
    }
}
