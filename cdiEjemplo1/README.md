# CDI - Ejemplo 1: **Managed Beans**

Este ejemplo está diseñado para enseñar los conceptos básicos del uso de *Managed Beans* en **CDI (Contexts and Dependency Injection)**, permitiendo a los desarrolladores gestionar de forma eficiente las dependencias y el ciclo de vida de los objetos en sus aplicaciones.

## Objetivos del Ejemplo
- Introducir la configuración básica para el uso de CDI utilizando Weld como contenedor.
- Explicar cómo utilizar anotaciones como `@ApplicationScoped` y `@Named` para controlar el ciclo de vida y la identificación de los *Managed Beans*.
- Demostrar cómo instanciar el contenedor CDI, realizar una búsqueda de dependencias (*lookup*) y utilizar un *Managed Bean* para realizar operaciones básicas.

## Funcionalidades
1. **Implementación de una interfaz (`Operaciones`)** para realizar operaciones matemáticas básicas.
2. **Gestión de beans mediante CDI**, utilizando:
    - *Lookup* por tipo: encontrar un bean según su clase.
    - *Lookup* por nombre: usar un nombre asignado para buscar un bean específico.
3. **Ejecución de un ejemplo práctico:** invocación de un método para sumar números y mostrar el resultado.

## Archivos principales
- **`Operaciones.java`**: Interfaz que define el contrato para las operaciones.
- **`OperacionesImpl.java`**: Implementación de las operaciones utilizando `@ApplicationScoped`.
- **`Main.java`**: Ejemplo práctico de uso del contenedor CDI para obtener un bean y ejecutar un método.
