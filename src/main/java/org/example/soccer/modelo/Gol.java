package org.example.soccer.modelo;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "goles")
public class Gol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Gol")
    private int id;
    @OneToOne
    private Partido partido;
    @Column (name = "tiempo")
    private LocalTime hora;
}
