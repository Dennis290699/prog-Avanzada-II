package com.programacion.avanzada2.repository.interfaces;

import com.programacion.avanzada2.db.Author;
import com.programacion.avanzada2.db.Book;
import com.programacion.avanzada2.repository.impl.BookRepositoryImpl;

import java.util.List;

public interface BookRepository {
    Book findById(Integer id);

    List<Book> findAll();

    void save(Book obj);

    void update(Book obj);

    void delete(Integer id);
}
