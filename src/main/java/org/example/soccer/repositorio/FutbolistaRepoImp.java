package org.example.soccer.repositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class FutbolistaRepoImp implements FutbolistaRepo {
    EntityManager em;
    public FutbolistaRepoImp() {
        em = Persistence.createEntityManagerFactory("BaseFutbol").createEntityManager();
    }
}
