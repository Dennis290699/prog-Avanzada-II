package com.programacion;

import com.programacion.db.Category;
import com.programacion.db.Product;
import com.programacion.repository.CategoryRepository;
import com.programacion.repository.ProductRepository;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

import java.math.BigDecimal;
import java.util.List;

public class MainPracticaPrueba {

    public static void main(String[] args) {
        // Inicializar el contenedor CDI
        SeContainer container = SeContainerInitializer.newInstance().initialize();

        // Obtener los repositorios
        var repoProduct = container.select(ProductRepository.class).get();
        var repoCategory = container.select(CategoryRepository.class).get();

        // 1️⃣ Insertar categorías
        Category cat1 = new Category();
        cat1.setNombre("Electrónica");

        Category cat2 = new Category();
        cat2.setNombre("Hogar");

        repoCategory.save(cat1);
        repoCategory.save(cat2);

        System.out.println("✅ Categorías insertadas");

        // 2️⃣ Insertar productos
        Product p1 = new Product();
        p1.setNombre("Laptop");
        p1.setDescripcion("Laptop de última generación con procesador potente.");
        p1.setPrecio(BigDecimal.valueOf(1000.0));
        p1.setStock(10);
        p1.setCategoria(cat1);

        Product p2 = new Product();
        p2.setNombre("Refrigerador");
        p2.setDescripcion("Refrigerador de alta eficiencia energética.");
        p2.setPrecio(BigDecimal.valueOf(500.0));
        p2.setStock(5);
        p2.setCategoria(cat2);

        Product p3 = new Product();
        p3.setNombre("Smartphone");
        p3.setDescripcion("Teléfono inteligente con cámara de 108MP.");
        p3.setPrecio(BigDecimal.valueOf(900.0));
        p3.setStock(3);
        p3.setCategoria(cat1);

        repoProduct.save(p1);
        repoProduct.save(p2);
        repoProduct.save(p3);

        System.out.println("✅ Productos insertados");

        // 3️⃣ Consultar y mostrar productos con su categoría
        System.out.println("\n📌 Lista de productos:");
        List<Product> productos = repoProduct.findAll();
        productos.forEach(prod -> System.out.println(prod.getNombre() + " - " + prod.getCategoria().getNombre()));

        // 4️⃣ Actualizar el precio de un producto
        System.out.println("\n✏️ Actualizando precio de la Laptop...");
        p1.setPrecio(BigDecimal.valueOf(1100.0));
        repoProduct.save(p1);

        System.out.println("✅ Precio actualizado: " + p1.getNombre() + " ahora cuesta $" + p1.getPrecio());



        BigDecimal minPrice = repoProduct.findMinPrice();
        BigDecimal maxPrice = repoProduct.findMaxPrice();
        Integer minStock = repoProduct.findMinStock();
        Integer maxStock = repoProduct.findMaxStock();

        System.out.println("Precio más bajo: $" + minPrice);
        System.out.println("Precio más alto: $" + maxPrice);
        System.out.println("Stock más bajo: " + minStock);
        System.out.println("Stock más alto: " + maxStock);
        // Cerrar el contenedor CDI
        container.close();
    }
}
