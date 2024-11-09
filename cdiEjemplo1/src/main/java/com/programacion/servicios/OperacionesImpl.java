package com.programacion.servicios;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OperacionesImpl implements Operaciones {
    public int sumar(int a, int b) {
        return a + b;
    }
}//FINAL CLASS
