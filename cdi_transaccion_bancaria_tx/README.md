# CDI - Transacción Bancaria con PostgreSQL

Este módulo implementa un sistema de gestión de transferencias bancarias utilizando **CDI (Contexts and Dependency Injection)** y la base de datos **PostgreSQL** proporcionada por la aplicación web **NeonTech**. Permite realizar transferencias entre cuentas mientras aprovecha las capacidades de inyección de dependencias y la conexión a bases de datos modernas.

## Objetivos del Proyecto

- Demostrar cómo utilizar CDI para la gestión de dependencias en aplicaciones Java.
- Integrar una base de datos PostgreSQL para el almacenamiento y consulta de datos relacionados con cuentas bancarias.
- Utilizar una arquitectura modular que separa la lógica empresarial, la persistencia y la configuración.
- Mostrar cómo realizar transacciones bancarias seguras, asegurando la consistencia de los datos.

## Estructura del Proyecto

```
📁 cdi_transaccion_bancaria_tx
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   ├── 📁 com.programacion.config
│   │   │   │   └── DbConfig.java         # Configuración de la conexión a PostgreSQL
│   │   │   ├── 📁 com.programacion.db
│   │   │   │   └── Cuenta.java           # Clase que representa una cuenta bancaria
│   │   │   ├── 📁 com.programacion.servicios.interfaces
│   │   │   │   ├── TransferenciaBancaria.java  # Interfaz para operaciones de transferencias
│   │   │   │   └── ManejadorPersistencia.java  # Interfaz para la gestión de la persistencia
│   │   │   ├── 📁 com.programacion.servicios.impl
│   │   │   │   ├── TransferenciaBancariaImpl.java # Implementación de transferencias
│   │   │   │   └── ManejadorPersistenciaImpl.java # Implementación de la persistencia
│   │   │   └── MainTransfereciasTx.java   # Clase principal para ejecutar el programa
│   │   └── 📁 resources
│   │       └── beans.xml                 # Archivo de configuración para CDI
├── 📄 build.gradle.kts                   # Archivo de configuración de Gradle
└── 📄 README.md                          # Documento de descripción del módulo
```

## Funcionalidades

1. **Transferencias bancarias:**
    - Permite transferir fondos entre cuentas bancarias.
    - Valida que las cuentas existan y que haya saldo suficiente en la cuenta de origen antes de realizar la transferencia.

2. **Gestión de cuentas:**
    - Representa cuentas bancarias con atributos como ID, número y saldo.

3. **Persistencia:**
    - Conexión a la base de datos PostgreSQL alojada en NeonTech.
    - Uso de consultas SQL para operaciones de lectura y escritura en la tabla `cuentas`.

4. **CDI:**
    - Uso de inyección de dependencias para manejar servicios de negocio y persistencia.
    - Modularidad que asegura una arquitectura flexible y escalable.

## Configuración de la Base de Datos

Este proyecto utiliza una base de datos PostgreSQL llamada `transferencias`, que debe configurarse en NeonTech.

### Crear la Tabla `cuentas`

Ejecuta el siguiente script SQL para configurar la tabla en PostgreSQL:

```sql
CREATE TABLE IF NOT EXISTS cuentas (
    id SERIAL PRIMARY KEY,
    numero VARCHAR(64),
    saldo REAL
);
```

### Insertar Datos Iniciales

Inserta datos de prueba para comenzar a utilizar el sistema:

```sql
INSERT INTO cuentas (numero, saldo)
VALUES
('001', 500),
('002', 300);
```

### Verificar los Datos

Puedes consultar los datos actuales con el siguiente comando SQL:

```sql
SELECT * FROM cuentas;
```

## Configuración y Ejecución

1. **Requisitos previos:**
    - Java 11 o superior.
    - Gradle instalado.
    - PostgreSQL configurado con acceso desde NeonTech.

2. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/Dennis290699/prog-Avanzada-II.git
   cd prog-Avanzada-II/cdi_transaccion_bancaria_tx
   ```

3. **Configurar la conexión a PostgreSQL:**
   Modifica `DbConfig.java` con las credenciales y detalles de conexión proporcionados por NeonTech.

4. **Construir el proyecto:**
   ```bash
   ./gradlew build
   ```

5. **Ejecutar el programa:**
   ```bash
   java -cp build/classes/java/main com.programacion.MainTransfereciasTx
   ```

## Ejemplo de Uso

- Ejecuta el programa y realiza transferencias entre cuentas existentes.
- En caso de errores como saldo insuficiente, el programa notificará y evitará operaciones inconsistentes.

