package com.programacion.avanzada2.repository.impl;

import com.programacion.avanzada2.db.Author;
import com.programacion.avanzada2.repository.interfaces.AuthorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@ApplicationScoped
public class AuthorRepositoryImpl implements AuthorRepository {

    @Inject
    EntityManager em;

    @Override
    public Author findById(Integer id) {
        return em.find(Author.class, id);
    }

    @Override
    public List<Author> findAll() {
        return em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    @Override
    public void save(Author obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Author obj) {
        try {
            em.getTransaction().begin();
            var tmp = em.find(Author.class, obj.getId());

            tmp.setNombre(obj.getNombre());
            tmp.setApellido(obj.getApellido());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            em.getTransaction().begin();
            var tmp = em.getReference(Author.class, id);
            em.remove(tmp);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}
