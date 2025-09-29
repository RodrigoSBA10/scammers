package org.example.soccer.repositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.soccer.enums.Pos;
import org.example.soccer.modelo.Futbolista;
import org.example.soccer.modelo.Posicion;

import java.util.List;

public class PosicionRepoImp  implements PosicionRepo {
    EntityManager em;
    public PosicionRepoImp(){
        em = Persistence.createEntityManagerFactory("BaseFutbol").createEntityManager();
    }

    @Override
    public Posicion agregarPosicion(Posicion posicion) {
        em.getTransaction().begin();
        em.persist(posicion);
        em.getTransaction().commit();
        return posicion;
    }
    @Override
    public void actualizarPosicion(Posicion posicion) {
        em.getTransaction().begin();
        em.merge(posicion);
        em.getTransaction().commit();
    }

    @Override
    public List<Posicion> listarPosiciones() {
        em.getTransaction().begin();
        TypedQuery<Posicion> query= em.createQuery("SELECT p FROM Posicion p", Posicion.class);
        em.getTransaction().commit();
        List<Posicion> posiciones = query.getResultList();
        return posiciones;
    }

}
