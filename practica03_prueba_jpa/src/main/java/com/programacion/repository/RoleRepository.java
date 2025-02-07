package com.programacion.repository;

import com.programacion.db.Role;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface RoleRepository extends EntityRepository<Role, Integer> {
}
