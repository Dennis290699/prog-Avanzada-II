package com.programacion.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "rol")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre" ,nullable = false)
    private String name;

    // Relación Muchos a Muchos con Empleado
    @ManyToMany(mappedBy = "roles")
    private List<Employee> employees;
}
