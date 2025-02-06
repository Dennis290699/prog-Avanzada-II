package com.programacion.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "categoria") // Nombre en minúsculas
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IMPORTANTE: Usar IDENTITY en SQLite
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nombre;
}
