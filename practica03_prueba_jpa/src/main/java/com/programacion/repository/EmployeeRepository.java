package com.programacion.repository;

import com.programacion.db.Employee;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface EmployeeRepository extends EntityRepository<Employee, Integer> {
}
