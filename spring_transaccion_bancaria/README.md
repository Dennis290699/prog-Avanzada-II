# Spring - Transacción Bancaria

Este proyecto implementa un sistema básico para gestionar transferencias bancarias utilizando **Spring Framework**. Aprovecha las capacidades de inyección de dependencias, configuración modular y acceso a bases de datos proporcionadas por Spring. La aplicación interactúa con una base de datos SQLite para manejar cuentas de usuarios y realizar transferencias.

## Objetivos del Proyecto

- Implementar un sistema de transferencias bancarias utilizando Spring para la gestión de dependencias y el control de la lógica empresarial.
- Mostrar cómo configurar el contenedor de Spring y definir beans a través de configuración XML.
- Integrar Spring con una base de datos SQLite para almacenar y recuperar información de cuentas.
- Comparar este enfoque con la implementación similar en CDI.

## Estructura del Proyecto

```
📁 spring_transaccion_bancaria
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
│   │   │   └── MainTransfereciasSpring.java   # Clase principal para ejecutar la aplicación
│   │   └── 📁 resources
│   │       └── app.xml                # Configuración de beans de Spring
├── 📄 build.gradle.kts                   # Archivo de configuración de Gradle
└── 📄 transferencias.db                  # Base de datos SQLite para las cuentas
```

## Funcionalidades

1. **Transferencias bancarias:**
    - Permite transferir dinero entre cuentas bancarias.
    - Valida que las cuentas existan y que la cuenta origen tenga saldo suficiente.

2. **Gestión de cuentas:**
    - Representación de cuentas bancarias con atributos como ID, saldo y propietario.

3. **Persistencia:**
    - Configuración de conexión a SQLite utilizando `HikariCP` como pool de conexiones.
    - Integración con la base de datos mediante consultas SQL simples.

4. **Spring Framework:**
    - Configuración de beans en un archivo XML (`app.xml`).
    - Gestión de dependencias a través del contenedor de Spring.

## Configuración de la Base de Datos

Este proyecto utiliza una base de datos SQLite con una tabla para las cuentas bancarias. A continuación, se detallan las instrucciones para inicializar la base de datos.

### Crear la Tabla `cuentas`

Ejecuta el siguiente script SQL para crear la tabla de cuentas:

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

Puedes verificar que los datos se insertaron correctamente utilizando:

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
   cd prog-Avanzada-II/spring_transaccion_bancaria
   ```

3. **Construir el proyecto:**
   ```bash
   ./gradlew build
   ```

4. **Ejecutar el programa:**
   ```bash
   java -cp build/classes/java/main com.programacion.MainTransfereciasSpring
   ```

## Ejemplo de Uso

- Inicia el programa para realizar transferencias entre cuentas.
- Los cambios se reflejan automáticamente en la base de datos `transferencias.db`.
