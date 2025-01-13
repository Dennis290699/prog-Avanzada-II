package com.programacion.avanzada2.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;

@ApplicationScoped
public class JpaConfig {
    //---VERSION INICIAL---
//    private EntityManagerFactory emf;
//
//    @PostConstruct
//    void init() {
//        emf = Persistence.createEntityManagerFactory( "books-db");
//    }
//
//    @Produces
//    public EntityManager entityManager() {
//        System.out.println("Creando EntityManager");
//        return emf.createEntityManager();
//    }

    //---VERSION 2---
    @PersistenceUnitName("books-db")
    @Inject
    EntityManagerFactory emf;

    @Produces
    public EntityManager entityManager() {
        System.out.println("Creando EntityManager...");
        return emf.createEntityManager();
    }

    protected void closeEntityManager(@Disposes EntityManager entityManager) {
        System.out.println("Cerrando EntityManager...");
        entityManager.close();
    }
}//FINAL CLASS
