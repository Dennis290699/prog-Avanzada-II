# CDI - Transacción Bancaria

Este proyecto implementa un sistema básico para gestionar transferencias bancarias utilizando **CDI (Contexts and Dependency Injection)** en Java. Se conecta con una base de datos para manejar cuentas de usuarios, realizar transferencias y garantizar que las transacciones se ejecuten de manera segura y eficiente.

## Objetivos del Proyecto

- Aplicar los conceptos de CDI para la inyección de dependencias y la modularidad en el código.
- Implementar un sistema de transferencias bancarias funcional, con interacción directa con una base de datos.
- Mostrar el uso de patrones de diseño como la separación de capas (servicios, persistencia, configuración).
- Ofrecer un ejemplo práctico de cómo integrar CDI con una base de datos.

## Estructura del Proyecto

```
📁 cdi_transaccion_bancaria
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   ├── 📁 com.programacion.config
│   │   │   │   └── DbConfig.java         # Configuración de la conexión a la base de datos
│   │   │   ├── 📁 com.programacion.db
│   │   │   │   └── Cuenta.java           # Clase que representa una cuenta bancaria
│   │   │   ├── 📁 com.programacion.servicios.interfaces
│   │   │   │   ├── TransferenciaBancaria.java  # Interfaz para operaciones de transferencias
│   │   │   │   └── ManejadorPersistencia.java  # Interfaz para manejar la persistencia
│   │   │   ├── 📁 com.programacion.servicios.impl
│   │   │   │   ├── TransferenciaBancariaImpl.java # Implementación de las transferencias
│   │   │   │   └── ManejadorPersistenciaImpl.java # Implementación de la persistencia
│   │   │   └── MainTransferencias.java   # Clase principal para ejecutar la aplicación
│   │   └── 📁 resources
│   │       └── beans.xml                 # Archivo de configuración para CDI
├── 📄 build.gradle.kts                   # Archivo de configuración de Gradle
└── 📄 transferencias.db                  # Base de datos SQLite para las cuentas
```

## Funcionalidades

1. **Transferencias bancarias:**
    - Permite transferir dinero entre cuentas bancarias.
    - Valida que las cuentas existan y tengan saldo suficiente antes de realizar la operación.

2. **Gestión de cuentas:**
    - Representación de cuentas bancarias con atributos como ID, saldo y propietario.

3. **Persistencia:**
    - Conexión a una base de datos SQLite para almacenar y consultar cuentas.
    - Configuración modular mediante la clase `DbConfig`.

4. **CDI:**
    - Uso de CDI para inyectar dependencias en los servicios de transferencia y persistencia.
    - Modularidad y separación de responsabilidades en la aplicación.

## Configuración de la Base de Datos

Este proyecto utiliza una base de datos SQLite con una tabla para las cuentas bancarias. A continuación, se muestran las instrucciones para inicializar la base de datos y los datos de ejemplo.

### Crear la Tabla `cuentas`

Ejecuta el siguiente script SQL para crear la tabla de cuentas en SQLite:

```sql
CREATE TABLE "cuentas" (
    "id" INTEGER PRIMARY KEY AUTOINCREMENT,
    "numero" TEXT UNIQUE,
    "saldo" REAL DEFAULT 0
);
```

### Insertar Datos Iniciales

Inserta los datos iniciales en la tabla `cuentas`:

```sql
INSERT INTO cuentas (numero, saldo)
VALUES
('001', 500),
('002', 300);
```

### Verificar los Datos

Puedes verificar que los datos se insertaron correctamente utilizando el siguiente comando:

```sql
SELECT * FROM cuentas;
```

## Configuración y Ejecución

1. **Requisitos previos:**
    - Java 11 o superior.
    - Gradle instalado.
    - SQLite (incluido como parte del proyecto).

2. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/Dennis290699/prog-Avanzada-II.git
   cd prog-Avanzada-II/cdi_transaccion_bancaria
   ```

3. **Construir el proyecto:**
   ```bash
   ./gradlew build
   ```

4. **Ejecutar el programa:**
   ```bash
   java -cp build/classes/java/main com.programacion.MainTransferencias
   ```

## Ejemplo de Uso

- Inicia el programa y realiza una transferencia entre dos cuentas.
- Todos los cambios se reflejan en la base de datos SQLite `transferencias.db`.
