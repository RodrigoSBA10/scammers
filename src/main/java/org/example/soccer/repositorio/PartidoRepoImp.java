package org.example.soccer.repositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.soccer.modelo.Partido;

import java.util.List;

public class PartidoRepoImp implements PartidoRepo {
    EntityManager em;
    public PartidoRepoImp() {
        this.em = Persistence.createEntityManagerFactory("BaseFutbol").createEntityManager();
    }
    @Override
    public void agregarPartido(Partido partido) {
        em.getTransaction().begin();
        em.persist(partido);
        em.getTransaction().commit();
    }

    @Override
    public List<Partido> obtenerPartidos() {
        em.getTransaction().begin();
        TypedQuery<Partido> query = em.createQuery("SELECT p FROM Partido p", Partido.class);
        List<Partido> partidos = query.getResultList();
        em.getTransaction().commit();
        return partidos;
    }

    @Override
    public void editarPartido(Partido partido) {
        em.getTransaction().begin();
        em.merge(partido);
        em.getTransaction().commit();
    }

    @Override
    public void eliminarPartido(Partido partido) {
        em.getTransaction().begin();
        em.remove(partido);
        em.getTransaction().commit();
    }
}
