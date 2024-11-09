package com.programacion;

import com.programacion.servicios.Operaciones;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class CdiEjemplo01Main {
    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer
                .newInstance()
                .initialize()) {

            Instance<Operaciones> obj = container.select(Operaciones.class);

            Operaciones servicio = obj.get();

            int resultado = servicio.sumar(10, 9);

            System.out.println(servicio.getClass());
            System.out.println("*************************Respuesta: " + resultado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}//FINAL CLASS
