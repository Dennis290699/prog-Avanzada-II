package com.programacion.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@ToString(exclude = "libros")
public class Author {
    @Id
    private Integer id;
    private String nombre;

    @Basic(fetch = FetchType.LAZY)
    private String apellido;

    @OneToMany(mappedBy = "author")
    private List<Book> libros;

    @Transient
    private String nombreCompleto;

    public String getNombreCompleto() {
        return String.format("%s %s", this.nombre, this.apellido);
    }
}//FINAL CLASS
