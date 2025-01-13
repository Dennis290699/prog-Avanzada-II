package com.programacion;

import com.programacion.db.Author;
import com.programacion.db.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class JpaEjercicio01Principal {
    public static void main(String[] args) {

        // Creamos el EntityManagerFactory y el EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("books-db");
        EntityManager em = emf.createEntityManager();
//
//        // Buscamos un Author por su Id
//        System.out.println();
//        System.out.println("Buscando autor por su Id...");
//        Author author1 = em.find(Author.class, 1);
//        System.out.println(author1);
//
//        // Buscamos todos los autores y los mostramos
//        System.out.println();
//        System.out.println("Buscando todos los autores...");
//        TypedQuery<Author> query = em.createQuery("select o from Author o order by o.nombre asc", Author.class);
//        query.getResultList().forEach(System.out::println);
//
//        // Buscamos un Libro por su Id
//        System.out.println();
//        System.out.println("Buscando Libro por su Id...");
//        Book book1 = em.find(Book.class, 1);
//        System.out.println(book1);
//
//        // Bucamos todos los libros y los mostramos
//        System.out.println();
//        System.out.println("Buscando todos los libros...");
//        TypedQuery<Book> query2 = em.createQuery("select o from Book o order by o.id asc", Book.class);
//        query2.getResultList().forEach(System.out::println);
//
//        // Buscamos el libro con autor 1 y su nombre del author
//        System.out.println();
//        System.out.println("Buscando Libro con autor 1 y su nombre del author...");
//        TypedQuery<Book> query3 = em.createQuery("select o from Book o where o.authorId = 1", Book.class);
//        query3.getResultList().forEach(System.out::println);
//
//        // Buscamos todos los libros con sus nombres de autor
//        System.out.println();
//        System.out.println("Buscando todos los libros con sus nombres de autor...");
//        TypedQuery<Book> query4 = em.createQuery("select o from Book o order by o.id asc", Book.class);
//        query4.getResultList().forEach(System.out::println);
//
//        //Buscamos el isbn de un libro su titulo y el apellido del autor
//        System.out.println();
//        System.out.println("Buscando el isbn de un libro su titulo y el apellido del autor...");
//        TypedQuery<Book> query5 = em.createQuery("select o from Book o where o.id = 1", Book.class);
//        query5.getResultList().forEach(System.out::println);
//
//        //Buscamos el isbn de todos los libros  y solo su titulo y solo el apellido del autor
//        System.out.println();
//        System.out.println("Buscando el isbn de todos los libros  y solo su titulo y solo el apellido del autor...");
//        TypedQuery<Book> query6 = em.createQuery("select o from Book o order by o.id asc", Book.class);
//        query6.getResultList().forEach(System.out::println);


        var autor = em.find(Author.class, 1);
        var libros = autor.getLibros();
        System.out.println("--Autor--");
        System.out.println(autor.getNombreCompleto());

        System.out.println();
        System.out.println("Libros author: " + autor.getApellido());
                autor.getLibros().forEach(System.out::println);
    }
}//FINAL CLASS