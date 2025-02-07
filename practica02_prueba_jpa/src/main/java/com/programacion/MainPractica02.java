package com.programacion;

import com.programacion.repository.BookRepository;
import com.programacion.repository.LoanRepository;
import com.programacion.repository.UserRepository;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class MainPractica02 {
    public static void main(String[] args) {
        // Inicializar el contenedor CDI
        SeContainer container = SeContainerInitializer.newInstance().initialize();

        // Obtener los repositorios
        var repoUser = container.select(UserRepository.class).get();
        var repoBook = container.select(BookRepository.class).get();
        var repoLoan = container.select(LoanRepository.class).get();

        // Ejecutar las pruebas
        repoUser.findAll();
        System.out.println( "El número de libros es: " + repoBook.findAll().size() );
        System.out.println( "El número de préstamos es: " + repoLoan.findAll().size() );
    }
}
