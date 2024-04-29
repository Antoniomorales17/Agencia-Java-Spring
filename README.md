# Prueba técnica4 || Agencia & Sistema de reservas de vuelo y hoteles ✈🏖🏝

![landing](https://i.imgur.com/XzxWyMo.png)

El propósito de este desafío consiste en poner en práctica los conocimientos adquiridos hasta ahora durante el BOOTCAMP (Git, Java, Spring Boot, Testing, JPA + Hibernate, Spring Security y JWT) para desarrollar una API REST.

## Características 🎯

🔵 Simulación de aplicación de reservas de habitiaciones de hotel y vuelos.

🔵 Operaciones CRUD para cada servicio y modelos.

🔵 Validación de datos, manejo de errores y excepciones.

🔵 Documentación con Swagger.

🔵 Test unitarios con Spring Security.

## Requisitos 🧾

🔴 Java 17 o superior

🔴 IDE compatible con Java 17 o superior

🔴 Un gestor de bases de datos compatible con MySQL

🔴 Un contenedor de servlet como Apache Tomcat para desplegar el proyecto web

⚠ La base de datos se encuentras en sources con el nombre : agencia

#### Seguridad 🔒

⚫ La seguridad está habilitada mediante Spring Security.

⚫ Credenciales para endpoints con restricciones:

 ◼ Usuario Administrador:
 
          ◻ Usuario: admin
          ◻ Contraseña: admin

#### Documentación de la API

La documentación de la API se ha realizado utilizando Swagger, lo que permite una fácil comprensión de los endpoints disponibles y cómo interactuar con ellos. Puedes acceder a la documentación y probar los endpoints utilizando el siguiente enlace:

http://localhost:8080/doc/swagger-ui.html

#### Colección de Postman

Para facilitar la comprensión y prueba de los endpoints de la API, se proporciona una colección de Postman en formato JSON. Esta colección contiene ejemplos predefinidos de solicitudes para ayudarte a comenzar a trabajar con la API

          

## Estructura 💾

El proyecto está organizado de la siguiente manera:

✅ src/main/java: Contiene el código fuente de la aplicación.

✅ src/test/java: Contiene las pruebas unitarias. 

✅ src/main/resources: Contiene archivos de configuración y recursos entre los cuales se incluyen la base de datos en formato .sql y la Postman Collection.

#### Organización de carpetas

La estructura de este proyecto sigue un modelo de capas:

◼ Model: Contiene las entidades de las clases entidades.

◼ Controller: Maneja las peticiones de los usuarios en cada endpoint.

◼ Dto: Contiene clases DTO

◼ Repository: Contiene interfaces con métodos que trabajan con la base de datos

◼ Service: Alberga las clases que se encargan de la mayor parte lógica del programa así cómo de comunicarse con las capas repository y controller.

◼ Config: Paquete de configuración que en este caso contiene la clase SecurityConfig encargada de la seguridad.

## Funcionalidades Principales: ⭐

✅ El objetivo es realizar un CRUD  de todos los modelos que posee la aplicacion para conseguir un sistema integral de una agencia de vuelos/hoteles con sus correspondientes reservas

✅ Gestión de Hoteles: Permite la creación, actualización y eliminación de registros de hoteles, así como la búsqueda de hoteles por ID y obtener todos los hoteles registrados.

✅ Gestión de Vuelos: Ofrece operaciones para la creación, modificación y eliminación de registros de vuelos. También facilita la búsqueda de vuelos por ID y obtener todos los vuelos registrados.

✅ Gestión de habitaciones: Permite la creación de habitaciones para ser asignadas a los hoteles correspondientes.

✅ Gestion reservas de Hoteles y Vuelos: Permite realizar la creacion y borrado de reservas tanto de hoteles como de vuelos, especificando detalles como fechas, cantidad de personas, tipo de habitación o asiento, y devuelve el costo total de la reserva.

✅ Gestión de personas: Permite la creación de usuarios para que se encarguen de realizar las reservas correspondientes tanto en vuelos como en habitaciones.




## Supuestos

🔵 Asignación de habitaciones: Las habitaciones deben asignarse a un hotel existente en el momento de su creación. Esto implica que para crear una habitación, se requiere que el hotel correspondiente ya esté registrado en el sistema.

🔵 Dependencias para las reservas: Para realizar una reserva, es necesario que tanto los vuelos como los hoteles estén creados previamente en el sistema. La reserva se vincula con estos elementos existentes.

🔵 No se permite eliminar usuarios que tienen una reserva ya realizada.Es necesario cancelar/borrar la reserva y posteriormente realizar las operaciones sobre la persona.


