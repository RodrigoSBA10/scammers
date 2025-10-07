package org.example.soccer.repositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.soccer.modelo.Equipo;
import java.util.List;

public class EquipoRepoImp implements EquipoRepo {
    EntityManager em;
    public EquipoRepoImp() {
        em = EntityManagerSIngleton.getInstance();
    }

    @Override
    public List<Equipo> obtenerEquipos() {
        em.getTransaction().begin();
        TypedQuery<Equipo> query = em.createQuery("SELECT e FROM Equipo e", Equipo.class);
        List<Equipo> equipos = query.getResultList();
        em.getTransaction().commit();
        return equipos;
    }

    @Override
    public void agregarEquipo(Equipo equipo) {
        em.getTransaction().begin();
        em.persist(equipo);
        em.getTransaction().commit();
    }

    @Override
    public void eliminarEquipo(Equipo equipo) {
        // Managed
        // Detached
        em.getTransaction().begin();
        em.remove(equipo);
        em.getTransaction().commit();
    }

    @Override
    public void editarEquipo(Equipo equipo) {
        em.getTransaction().begin();
        em.merge(equipo);
        em.getTransaction().commit();
    }

}
