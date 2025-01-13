package com.programacion.avanzada2.repository.interfaces;

import com.programacion.avanzada2.db.Author;

import java.util.List;

public interface AuthorRepository {
    Author findById(Integer id);

    List<Author> findAll();

    void save(Author author);

    void update(Author author);

    void delete(Integer id);
}
