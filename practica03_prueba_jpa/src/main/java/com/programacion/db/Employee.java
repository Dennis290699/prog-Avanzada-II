package com.programacion.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "empleado")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre" ,nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private BigDecimal salary;

    @Column(name = "fecha_ingreso", nullable = false)
    private String dateEntry;

    // Relación Muchos a Uno con Departamento
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // Relación Muchos a Muchos con Rol
    @ManyToMany
    @JoinTable(
            name = "empleado_rol",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
