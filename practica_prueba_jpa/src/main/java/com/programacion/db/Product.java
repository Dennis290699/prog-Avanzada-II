package com.programacion.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "producto") // Nombre en minúsculas para evitar problemas en SQLite
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IMPORTANTE: Usar IDENTITY en SQLite
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Category categoria;
}
