package org.example.soccer.repositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerSIngleton {
    private static EntityManager instance;
    private EntityManagerSIngleton() {

    }

    public static EntityManager getInstance() {
        if (instance == null) {
            instance = Persistence.createEntityManagerFactory("BaseFutbol").createEntityManager();
        }
        return instance;
    }

    public static void close() {
        if (instance != null && instance.isOpen()) {
            instance.close();
        }
    }
}
