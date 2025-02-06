
    create table categoria (
        id integer,
        nombre varchar(255) not null unique,
        primary key (id)
    );

    create table producto (
        categoria_id integer not null,
        id integer,
        precio numeric(38,2) not null,
        stock integer not null,
        descripcion varchar(255) not null,
        nombre varchar(255) not null,
        primary key (id)
    );
INSERT INTO categoria (nombre) VALUES ('Categoria 1');
INSERT INTO producto (nombre, descripcion, precio, stock, categoria_id) VALUES ( 'Producto 1', 'Descripción del producto 1', 19.99, 10, 1);
