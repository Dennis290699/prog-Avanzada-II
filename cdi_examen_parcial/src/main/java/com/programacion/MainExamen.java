package com.programacion;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class MainExamen {
    public static void main(String[] args) {
        //Inicializar el conteneredor de CDI
        SeContainer container = SeContainerInitializer.newInstance().initialize();
    }
}
