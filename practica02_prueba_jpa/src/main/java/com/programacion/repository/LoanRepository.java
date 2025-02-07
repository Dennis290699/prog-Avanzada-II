package com.programacion.repository;

import com.programacion.db.Loan;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface LoanRepository extends EntityRepository<Loan, Integer> {
}
