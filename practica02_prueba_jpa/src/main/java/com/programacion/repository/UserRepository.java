package com.programacion.repository;

import com.programacion.db.User;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface UserRepository extends EntityRepository<User, Integer> {
}
