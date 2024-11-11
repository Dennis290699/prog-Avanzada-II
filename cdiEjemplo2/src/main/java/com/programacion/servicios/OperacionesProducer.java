package com.programacion.servicios;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class OperacionesProducer {
    @Produces
    @MiBean
    public Operaciones create() {
        return new OperacionesImpl();
    }
}//FINAL CLASS
