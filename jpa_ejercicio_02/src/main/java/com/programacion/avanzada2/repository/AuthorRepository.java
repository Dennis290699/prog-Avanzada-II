package com.programacion.avanzada2.repository;

import com.programacion.avanzada2.db.Author;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface AuthorRepository extends EntityRepository<Author, Integer> {

}
