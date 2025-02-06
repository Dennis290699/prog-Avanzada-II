package com.programacion.repository;

import com.programacion.db.Product;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends EntityRepository<Product, Integer> {
    @Query("SELECT MIN(p.precio) FROM Product p")
    BigDecimal findMinPrice();

    @Query("SELECT MAX(p.precio) FROM Product p")
    BigDecimal findMaxPrice();

    @Query("SELECT MIN(p.stock) FROM Product p")
    Integer findMinStock();

    @Query("SELECT MAX(p.stock) FROM Product p")
    Integer findMaxStock();
}
