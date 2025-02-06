package com.programacion.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;

@ApplicationScoped
public class JpaConfig {
    @PersistenceUnitName("pruebas-db")
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
}
