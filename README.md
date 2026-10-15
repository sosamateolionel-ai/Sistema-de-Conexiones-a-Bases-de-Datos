# Sistema de Conexiones a Bases de Datos

## Descripción

Este proyecto consiste en un sistema de simulación de conexiones a bases de datos desarrollado en Java. Permite trabajar con tres motores diferentes: MySQL, PostgreSQL y MongoDB.

El objetivo principal es aplicar interfaces, clases abstractas, herencia y polimorfismo para compartir la lógica de conexión y desconexión, manteniendo comportamientos específicos para cada motor de base de datos.

## Funcionamiento

### Interfaz `ConexionBD`

Define el contrato que deben cumplir todas las conexiones a bases de datos mediante tres métodos:

* `conectar()`: establece una conexión y devuelve `true` si se realiza correctamente.
* `ejecutarConsulta(String sql)`: procesa una consulta y devuelve un resultado como texto.
* `desconectar()`: cierra la conexión activa.

### Clase abstracta `ConexionBase`

Implementa la interfaz `ConexionBD` y contiene la lógica compartida por los distintos motores.

Sus responsabilidades son:

* Mantener el nombre del motor y el estado de la conexión.
* Evitar establecer una segunda conexión cuando ya existe una activa.
* Impedir la ejecución de consultas sin conexión.
* Validar que las consultas no sean nulas ni estén vacías.
* Controlar la desconexión.
* Definir los métodos abstractos `detalleConexion()` y `procesar()`, que cada motor debe implementar.

### Clase `ConexionMySQL`

Representa una conexión simulada a MySQL.

* Recibe el puerto mediante su constructor.
* Muestra información sobre el puerto y el tipo de motor.
* Simula la ejecución de una consulta SQL.
* Devuelve un resultado de ejemplo de tres filas.

### Clase `ConexionPostgreSQL`

Representa una conexión simulada a PostgreSQL.

* Recibe el nombre del esquema mediante su constructor.
* Muestra información sobre el esquema utilizado.
* Simula la ejecución de consultas SQL.
* Devuelve un resultado de ejemplo de cinco filas.

### Clase `ConexionMongoDB`

Representa una conexión simulada a MongoDB.

* Recibe el nombre de una colección mediante su constructor.
* Indica que se trata de una base de datos NoSQL orientada a documentos.
* Simula la traducción de una consulta a una operación de búsqueda sobre documentos.
* Devuelve un resultado de ejemplo de dos documentos.

### Clase `Main`

Contiene el método principal del programa y demuestra cómo utilizar los tres motores mediante una variable del tipo de la interfaz `ConexionBD`.

El programa realiza las siguientes pruebas:

1. Conecta con MySQL, ejecuta una consulta y cierra la conexión.
2. Conecta con PostgreSQL, intenta conectarse nuevamente para comprobar la validación, ejecuta una consulta y se desconecta.
3. Intenta consultar MongoDB sin conexión, establece la conexión, ejecuta la consulta y prueba desconectarse dos veces.

## Ejemplo de funcionamiento

Durante la ejecución, la consola muestra los mensajes de conexión, las consultas procesadas, los resultados simulados y los errores de validación.

Entre las situaciones comprobadas se encuentran:

* Intentar conectarse cuando ya existe una conexión activa.
* Ejecutar una consulta sin haberse conectado.
* Cerrar una conexión que ya está cerrada.
* Ejecutar consultas válidas en distintos motores.

**Importante:** el programa es una simulación educativa. No establece conexiones reales ni consulta bases de datos instaladas; los resultados de filas y documentos están definidos en el código.

## Conceptos de programación utilizados

* **Interfaces:** definen un contrato común para los diferentes motores.
* **Clases abstractas:** permiten compartir atributos y lógica entre las conexiones.
* **Herencia:** las clases concretas heredan de `ConexionBase`.
* **Polimorfismo:** una variable de tipo `ConexionBD` puede referenciar distintos tipos de conexión.
* **Abstracción:** el programa utiliza los métodos definidos por la interfaz sin depender de una implementación concreta.
* **Encapsulamiento:** los atributos específicos de cada motor son privados, mientras que los atributos compartidos se declaran `protected`.
* **Sobrescritura de métodos:** se utiliza `@Override` para implementar o redefinir comportamientos.
* **Validación de estados:** se controla si existe una conexión activa antes de ejecutar operaciones.
* **Métodos abstractos:** `detalleConexion()` y `procesar()` obligan a cada motor a definir su comportamiento específico.

## Tecnologías utilizadas

* Java.
* Programación Orientada a Objetos (POO).
* IntelliJ IDEA como entorno de desarrollo.

## Ejecución

<img width="911" height="592" alt="image" src="https://github.com/user-attachments/assets/337b7bf7-9c72-4ebd-84cd-132c8905f34a" />

## Conclusión

Este ejercicio demuestra cómo combinar interfaces y clases abstractas para diseñar un sistema extensible. La interfaz define las operaciones comunes, la clase abstracta centraliza las validaciones y cada motor implementa su comportamiento particular. De esta manera, es posible agregar nuevos tipos de conexión sin modificar la lógica principal del programa.
