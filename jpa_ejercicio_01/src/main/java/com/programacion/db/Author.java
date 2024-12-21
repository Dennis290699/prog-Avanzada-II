package com.programacion.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "authors")
@Data
public class Author {
    @Id
    private Integer id;
    private String nombre;
    private String apellido;
}//FINAL CLASS
