package org.example.soccer.repositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class GolRepoImp implements  GolRepo {
    EntityManager em;
    public GolRepoImp() {
        em = Persistence.createEntityManagerFactory("BaseFutbol").createEntityManager();
    }
}
