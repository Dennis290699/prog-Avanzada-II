# Módulo JPA - Ejercicio 01

Este módulo es un ejemplo práctico que utiliza **JPA** (Java Persistence API) para interactuar con una base de datos SQLite. El proyecto demuestra cómo realizar operaciones básicas como buscar un registro específico por su ID y listar todos los registros de una tabla, utilizando consultas JPQL (Java Persistence Query Language).

## Estructura del Proyecto

El proyecto consta de las siguientes entidades y tablas en la base de datos:

### Tablas de la Base de Datos
- **authors**: Contiene información sobre los autores.
    - Campos: `id`, `nombre`, `apellido`.
- **books**: Contiene información sobre los libros, incluyendo un enlace a su autor.
    - Campos: `id`, `isbn`, `titulo`, `precio`, `authors` (clave foránea que referencia a `authors.id`).

#### Datos iniciales
Al inicializar la base de datos, se crean tres autores y tres libros relacionados, como se detalla en el script SQL.

### Clases principales
- **`Author`**: Representa la entidad `authors` en la base de datos.
- **`JpaEjercicio01Principal`**: Clase principal que ejecuta consultas JPQL para interactuar con la base de datos.

## Requisitos Previos

Antes de ejecutar este módulo, asegúrate de tener instalado lo siguiente:

- **Java JDK** (versión 8 o superior).
- **Gradle** (para gestionar las dependencias del proyecto).
- **SQLite** (base de datos utilizada en este ejemplo).
- Una herramienta para ejecutar consultas SQL (opcional, para verificar la base de datos).

## Configuración del Proyecto

1. **Configuración de la Base de Datos**
   Utiliza el siguiente script SQL para inicializar la base de datos:

   ```sql
   -- Tabla de autores
   CREATE TABLE authors (
       id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
       nombre TEXT NOT NULL,
       apellido TEXT NOT NULL
   );

   -- Tabla de libros
   CREATE TABLE books (
       id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
       isbn TEXT NOT NULL,
       titulo TEXT NOT NULL,
       precio REAL NOT NULL,
       authors INTEGER NOT NULL,
       CONSTRAINT books_authors_id_fk FOREIGN KEY (authors) REFERENCES authors (id)
   );

   -- Insertar autores
   INSERT INTO authors (nombre, apellido) VALUES ('Gabriel', 'García Márquez');
   INSERT INTO authors (nombre, apellido) VALUES ('Isabel', 'Allende');
   INSERT INTO authors (nombre, apellido) VALUES ('Julio', 'Cortázar');

   -- Insertar libros
   INSERT INTO books (isbn, titulo, precio, authors) VALUES ('978-3-16-148410-0', 'Cien años de soledad', 29.99, 1);
   INSERT INTO books (isbn, titulo, precio, authors) VALUES ('978-0-06-231500-7', 'La casa de los espíritus', 19.99, 2);
   INSERT INTO books (isbn, titulo, precio, authors) VALUES ('978-0-394-73260-1', 'Rayuela', 24.99, 3);
   ```

2. **Configuración del archivo `persistence.xml`**
   Define las propiedades necesarias para conectar con SQLite en el archivo `src/main/resources/META-INF/persistence.xml`.

## Ejecución del Proyecto

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/Dennis290699/prog-Avanzada-II.git
   cd prog-Avanzada-II/jpa_ejercicio_01
   ```

2. Compila y ejecuta el proyecto:
   ```bash
   ./gradlew build
   java -cp build/classes/java/main com.programacion.JpaEjercicio01Principal
   ```

3. Observa los resultados en la consola:
    - **Buscar un autor por ID**: Se muestra información del autor con ID `1`.
    - **Listar todos los autores**: Se listan todos los autores en orden alfabético.

## Funcionalidades Implementadas

- **Búsqueda por ID**: Utiliza `EntityManager.find()` para buscar un autor por su ID.
- **Listar registros**: Realiza una consulta JPQL (`SELECT o FROM Author o ORDER BY o.nombre ASC`) para listar todos los autores.

## Dependencias

Este proyecto utiliza las siguientes dependencias:

- **Jakarta Persistence**: Para la gestión de entidades y consultas JPQL.
- **SQLite JDBC**: Controlador JDBC para conectarse a la base de datos SQLite.
- **Gradle**: Herramienta de construcción para gestionar las dependencias.
