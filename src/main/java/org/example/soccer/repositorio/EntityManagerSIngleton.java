package org.example.soccer.repositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerSIngleton {
    private static EntityManager instance;
    private static EntityManagerFactory  emf;
    private EntityManagerSIngleton() {

    }

    public static EntityManager getInstance() {
        if (instance == null) {
            emf = Persistence.createEntityManagerFactory("BaseFutbol");
            instance = emf.createEntityManager();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                close();
            }));
        }
        return instance;
    }

    public static void close() {
        if (instance != null && instance.isOpen()) {
            instance.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
