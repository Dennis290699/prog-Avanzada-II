package com.programacion.db;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Productos {
    private Integer id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
}
