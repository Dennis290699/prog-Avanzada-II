-- INSERTS DE LA TABLA USUARIO
INSERT INTO usuario (nombre, email) VALUES ('Juan Perez', 'juan.perez@example.com');
INSERT INTO usuario (nombre, email) VALUES ('Maria Lopez', 'maria.lopez@example.com');
INSERT INTO usuario (nombre, email) VALUES ('Carlos Ramirez', 'carlos.ramirez@example.com');
INSERT INTO usuario (nombre, email) VALUES ('Ana Torres', 'ana.torres@example.com');
INSERT INTO usuario (nombre, email) VALUES ('Luis Gonzalez', 'luis.gonzalez@example.com');

-- INSERTS DE LA TABLA LIBROS
INSERT INTO libro (title, author, yearPublication) VALUES ('Cien anos de soledad', 'Gabriel Garcia Marquez', 1967);
INSERT INTO libro (title, author, yearPublication) VALUES ('1984', 'George Orwell', 1949);
INSERT INTO libro (title, author, yearPublication) VALUES ('El principito', 'Antoine de Saint-Exupery', 1943);
INSERT INTO libro (title, author, yearPublication) VALUES ('Orgullo y prejuicio', 'Jane Austen', 1813);
INSERT INTO libro (title, author, yearPublication) VALUES ('Don Quijote de la Mancha', 'Miguel de Cervantes', 1605);

-- INSERTS DE LA TABLA PRESTAMOS
INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, usuario_id, libro_id) VALUES ('2025-02-01', NULL, 1, 2);  -- Juan Perez tomo "1984" y aun no lo devolvio
INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, usuario_id, libro_id) VALUES ('2025-01-20', '2025-01-30', 2, 3);  -- Maria Lopez tomo y devolvio "El principito"
INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, usuario_id, libro_id) VALUES ('2025-02-05', NULL, 3, 1);  -- Carlos Ramirez tomo "Cien anos de soledad"
INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, usuario_id, libro_id) VALUES ('2025-01-15', '2025-01-28', 4, 5);  -- Ana Torres tomo y devolvio "Don Quijote de la Mancha"
INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, usuario_id, libro_id) VALUES ('2025-02-03', NULL, 5, 4);  -- Luis Gonzalez tomo "Orgullo y prejuicio"
