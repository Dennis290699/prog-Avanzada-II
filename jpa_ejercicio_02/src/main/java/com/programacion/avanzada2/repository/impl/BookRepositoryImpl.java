package com.programacion.avanzada2.repository.impl;

import com.programacion.avanzada2.db.Author;
import com.programacion.avanzada2.db.Book;
import com.programacion.avanzada2.repository.interfaces.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

    @Inject
    EntityManager em;

    @Override
    public Book findById(Integer id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> findAll() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    @Override
    public void save(Book obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Book obj) {
        try {
            em.getTransaction().begin();
            var tmp = em.find(Book.class, obj.getId());

            tmp.setIsbn(obj.getIsbn());
            tmp.setTitulo(obj.getTitulo());
            tmp.setPrecio(obj.getPrecio());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            em.getTransaction().begin();
            var tmp = em.getReference(Book.class, id);
            em.remove(tmp);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}
