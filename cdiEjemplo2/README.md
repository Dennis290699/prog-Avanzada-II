# CDI - Ejemplo 2: **Producers**

Este ejemplo explora el uso del patrón *Producer* en CDI, proporcionando una forma flexible y personalizable de gestionar la creación de objetos y dependencias mediante calificadores personalizados.

## Objetivos del Ejemplo
- Enseñar cómo usar un *Producer* para crear instancias personalizadas de objetos.
- Introducir la creación de calificadores personalizados (`@Qualifier`) para diferenciar entre múltiples implementaciones de un mismo tipo.
- Mostrar cómo inicializar el contenedor CDI utilizando **OpenWebBeans**.

## Funcionalidades
1. **Definición de un *Qualifier personalizado (`@MiBean`)** para diferenciar instancias producidas.
2. **Creación de un productor (`OperacionesProducer`)**, encargado de proporcionar instancias personalizadas de la implementación de la interfaz `Operaciones`.
3. **Uso del contenedor CDI con OpenWebBeans** para obtener una referencia al bean producido e invocar sus métodos.

## Archivos principales
- **`Operaciones.java`**: Interfaz que define las operaciones matemáticas.
- **`OperacionesImpl.java`**: Implementación básica de las operaciones.
- **`OperacionesProducer.java`**: Clase que define un productor para instancias de `Operaciones`.
- **`Main.java`**: Ejemplo práctico de inicialización de OpenWebBeans, obtención de un bean y ejecución de métodos.