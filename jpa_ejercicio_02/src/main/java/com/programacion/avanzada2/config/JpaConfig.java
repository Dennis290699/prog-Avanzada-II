package com.programacion.avanzada2.config;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;

@ApplicationScoped
public class JpaConfig {

    private EntityManagerFactory emf;

    @PostConstruct
    void init() {
        emf = Persistence.createEntityManagerFactory( "books-db");
    }

    @Produces
    public EntityManager entityManager() {
        System.out.println("Creando EntityManager");
        return emf.createEntityManager();
    }
}
