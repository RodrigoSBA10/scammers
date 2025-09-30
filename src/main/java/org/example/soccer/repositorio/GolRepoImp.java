package org.example.soccer.repositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.soccer.modelo.Gol;

import java.util.List;

public class GolRepoImp implements  GolRepo {
    EntityManager em;
    public GolRepoImp() {
        em = EntityManagerSIngleton.getInstance();
    }
    @Override
    public void agregarGol(Gol gol) {
        em.getTransaction().begin();
        em.persist(gol);
        em.getTransaction().commit();
    }

    @Override
    public List<Gol> obtenerGoles(){
        em.getTransaction().begin();
        TypedQuery<Gol> query = em.createQuery("SELECT g FROM Gol g", Gol.class);
        List<Gol> goles = query.getResultList();
        em.getTransaction().commit();
        return goles;
    }

    @Override
    public void editarGol(Gol gol) {
        em.getTransaction().begin();
        em.merge(gol);
        em.getTransaction().commit();
    }

    @Override
    public void eliminarGol(Gol gol) {
        em.getTransaction().begin();
        em.remove(gol);
        em.getTransaction().commit();
    }


}
