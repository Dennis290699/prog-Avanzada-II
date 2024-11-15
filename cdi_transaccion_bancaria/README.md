# CDI Transaccion Bancaria

## Configuracion SQLite

```
CREATE TABLE "cuentas" (
"id"	INTEGER PRIMARY KEY AUTOINCREMENT,
"numero" TEXT UNIQUE,
"saldo"	REAL DEFAULT 0
);

INSERT INTO cuentas (numero, saldo)
VALUES
('001', 500),
('002', 300);


SELECT * FROM cuentas;
```