package com.programacion.repository;

import com.programacion.db.Department;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface DepartmentRepository extends EntityRepository<Department, Integer> {
}
