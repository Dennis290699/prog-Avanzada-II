package com.programacion.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@ToString

public class Book {
    @Id
    private Integer id;
    private String isbn;
    private String titulo;
    private BigDecimal precio;

    // La columna 'authors' en la base de datos no debe ser insertable ni actualizable desde el atributo 'authorId'.
    @Column(name = "authors", insertable = false, updatable = false)
    private Integer authorId;

    @ManyToOne
    @JoinColumn(name = "authors")  // Relaciona la columna 'authors' con la entidad 'Author'.
    private Author author;
} //FINAL CLASS
