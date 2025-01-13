package com.programacion.avanzada2.repository;

import com.programacion.avanzada2.db.Book;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BookRepository extends EntityRepository<Book, Integer> {
    Book findByIsbn(String isbn);

    List<Book> findByPrecioGreaterThan(BigDecimal price);
}
