package com.programacion.repository;

import com.programacion.db.Book;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface BookRepository extends EntityRepository<Book, Long> {
}
