package org.example.soccer.modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

@Entity
@Table(name = "partidos")
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPartido")
    private Long id;
    @ManyToOne
    private Equipo local;
    @ManyToOne
    @JoinColumn(name = "visitante")
    private Equipo idVIsita;
    @Column(name = "Goles Equipo Local")
    private int gLocal;
    @Column (name = "Goles Equipo Visitante")
    private int gVisitante;
    private Date fecha;

    public Partido() {

    }

    public Partido(Equipo local, Equipo idVIsita, int gL, int gV) {
        this.local = local;
        this.idVIsita = idVIsita;
        this.gLocal = gL;
        this.gVisitante = gV;
        this.fecha = new Date(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getIdVIsita() {
        return idVIsita;
    }

    public void setIdVIsita(Equipo idVIsita) {
        this.idVIsita = idVIsita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getgLocal() {
        return gLocal;
    }

    public void setgLocal(int gLocal) {
        this.gLocal = gLocal;
    }

    public int getgVisitante() {
        return gVisitante;
    }

    public void setgVisitante(int gVisitante) {
        this.gVisitante = gVisitante;
    }

    @Override
    public String toString() {
        return "Partido =" +
                "Local =" + local +
                ", VIsitante =" + idVIsita +
                ", fecha=" + fecha;
    }
}
