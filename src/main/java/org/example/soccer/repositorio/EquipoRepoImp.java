package org.example.soccer.repositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.soccer.modelo.Equipo;
import java.util.List;

public class EquipoRepoImp implements EquipoRepo {
    EntityManager emf;
    public EquipoRepoImp() {
        emf = EntityManagerSIngleton.getInstance();
    }

    @Override
    public List<Equipo> obtenerEquipos() {
        emf.getTransaction().begin();
        TypedQuery<Equipo> query = emf.createQuery("SELECT e FROM Equipo e", Equipo.class);
        List<Equipo> equipos = query.getResultList();
        emf.getTransaction().commit();
        return equipos;
    }

    @Override
    public void agregarEquipo(Equipo equipo) {
        emf.getTransaction().begin();
        emf.persist(equipo);
        emf.getTransaction().commit();
    }

    @Override
    public void eliminarEquipo(Equipo equipo) {
        emf.getTransaction().begin();
        emf.remove(equipo);
        emf.getTransaction().commit();
    }

    @Override
    public void editarEquipo(Equipo equipo) {
        emf.getTransaction().begin();
        emf.merge(equipo);
        emf.getTransaction().commit();
    }

}
