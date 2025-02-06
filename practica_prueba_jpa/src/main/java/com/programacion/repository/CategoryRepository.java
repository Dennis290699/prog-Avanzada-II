package com.programacion.repository;

import com.programacion.db.Category;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface CategoryRepository extends EntityRepository<Category, Integer> {
}
