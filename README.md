# ZonaFit 🏋️‍♂️

ZonaFit es una aplicación de consola (CLI) desarrollada en Java para la gestión básica de clientes de un centro de entrenamiento o gimnasio. El sistema permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) conectándose a una base de datos relacional (MySql) mediante sentencias JDBC.

## 🚀 Tecnologías y Herramientas

* **Lenguaje:** Java 21
* **Gestor de dependencias:** Maven
* **Base de Datos:** MySQL
* **Driver JDBC:** `mysql-connector-j` (8.3.0)
* **Arquitectura:** Patrón DAO (Data Access Object) para la persistencia de datos y arquitectura en capas (Dominio, Controlador, Acceso a Datos).

## 📋 Funcionalidades

El menú interactivo permite al usuario realizar las siguientes acciones:
1. **Listar clientes:** Muestra todos los clientes registrados en la base de datos.
2. **Buscar cliente:** Busca a un cliente específico mediante su ID.
3. **Agregar cliente:** Registra un nuevo cliente con su nombre, apellido y número de membresía.
4. **Actualizar cliente:** Modifica la información de un cliente existente.
5. **Eliminar cliente:** Borra el registro de un cliente del sistema.

## ⚙️ Instalación y Configuración

Sigue estos pasos para ejecutar el proyecto en tu entorno local:

### 1. Preparar la Base de Datos
Asegúrate de tener un servidor MySQL en ejecución. Ejecuta el siguiente script SQL para crear la base de datos y la tabla necesaria:

```sql
CREATE DATABASE IF NOT EXISTS zona_fit_db;
USE zona_fit_db;

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    membresia INT NOT NULL
);
```

### 2. Configurar Credenciales Seguras (Variables de Entorno)
Por motivos de seguridad y buenas prácticas, las credenciales de conexión a la base de datos no están incluidas en el código fuente. 

Debes configurar las siguientes **Variables de Entorno** en tu sistema operativo o directamente en la configuración de ejecución de tu IDE (ej. IntelliJ IDEA):

* `DB_USER`: Tu usuario de MySQL (por ejemplo, `root`).
* `DB_PASSWORD`: Tu contraseña de MySQL.

*(Nota: Si usas IntelliJ IDEA, ve a `Run` -> `Edit Configurations...` y agrega estas variables en el campo `Environment variables`).*

### 3. Ejecutar la Aplicación
Una vez configurada la base de datos y las variables de entorno:
1. Sincroniza las dependencias de Maven.
2. Ejecuta el archivo `Main.java` ubicado en `src/main/java/zona_fit/Main.java`.
3. ¡Interactúa con el sistema a través de la consola!

## 🏗️ Estructura del Proyecto

* `domain/Cliente.java`: Entidad principal que representa a un cliente.
* `data/IClienteDAO.java` y `ClienteDAO.java`: Interfaz y clase que manejan toda la lógica de acceso a datos (consultas SQL).
* `database/Conexion.java`: Encargada de establecer la conexión con MySQL utilizando las variables de entorno.
* `controller/ZonaFitController.java`: Maneja la interacción con el usuario (menú de consola) y coordina las llamadas al DAO.
* `Main.java`: Punto de entrada de la aplicación.
