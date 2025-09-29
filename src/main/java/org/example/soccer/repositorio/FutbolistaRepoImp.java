package org.example.soccer.repositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.soccer.modelo.Futbolista;

import java.util.List;

public class FutbolistaRepoImp implements FutbolistaRepo {
    EntityManager em;
    public FutbolistaRepoImp() {
        //Lo inicializa el constructor
        em = Persistence.createEntityManagerFactory("BaseFutbol").createEntityManager();
    }

    @Override
    public Futbolista agregarFutbolista(Futbolista f) {
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        return f;
    }

    @Override
    public void actualizarFutbolista(Futbolista f) {
        //Preparo la transicion
        em.getTransaction().begin();
        em.merge(f); // Marge es como hacer update solo actualizo datos del jugador
        em.getTransaction().commit(); //Finalizo la transicion con un futbolita modificado
    }

    @Override
    public void eliminarFutbolista(Futbolista f) {
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();

    }

    @Override
    public List<Futbolista> obtenerFutbolistas() {
        em.getTransaction().begin();
        TypedQuery<Futbolista> query = em.createQuery("SELECT f FROM Futbolista f", Futbolista.class);
        em.getTransaction().commit();
        List<Futbolista> futbolistas = query.getResultList();
        return futbolistas;
    }

}
