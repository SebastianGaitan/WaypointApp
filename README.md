# WaypointMap Backend

Este proyecto es la parte del backend de la aplicación WaypointMap, desarrollada con Spring Boot. La aplicación permite a los usuarios crear, leer, actualizar y eliminar waypoints en un mapa, almacenándolos en una base de datos MySQL alojada en AWS RDS.

## Requisitos

- JDK 21 o superior
- Maven
- MySQL Database en AWS RDS
- Postman (para pruebas)

## Configuración del Proyecto

### 1. Clonar el Repositorio

```bash
git clone https://github.com/SebastianGaitan/WaypointApp.git
cd waypointmap-backend
```


### 2. WayPointMap - Documentación de la Aplicación

## Configuración de la Base de Datos

    1. Crea una base de datos MySQL en AWS RDS.
    2. Anota el endpoint, el nombre de la base de datos, el usuario y la contraseña.

## Configuración de las Propiedades de la Aplicación

    Edita el archivo `src/main/resources/application.properties` con las siguientes
    credenciales de tu base de datos:

```properties
spring.datasource.url=jdbc:mysql://<TU_RDS_ENDPOINT>:3306/waypointdb
spring.datasource.username=<TU_USUARIO>
spring.datasource.password=<TU_CONTRASEÑA>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### End Points de la API usando " http://localhost:8080"
    Crear un Waypoint
    Método: POST
    URL: /api/waypoints
    Body: JSON
  ```bash
    {
        "name": "Nombre del Waypoint",
        "description": "Descripción del Waypoint",
        "latitude": 40.73061,
        "longitude": -73.935242
    } 
  ```   

    Obtener Todos los Waypoints
    Método: GET
    URL: /api/waypoints
    
    Obtener un Waypoint por ID
    Método: GET
    URL: /api/waypoints/{id}

    Actualizar un Waypoint
    Método: PUT
    URL: /api/waypoints/{id}
    Body: JSON

```bash
    {
        "name": "Nombre Actualizado",
        "description": "Descripción Actualizada",
        "latitude": 40.73061,
        "longitude": -73.935242
    }
```

    ###Obtener Todos los Waypoints
    Método: GET
    URL: /api/waypoints

    Obtener un Waypoint por ID
    Método: GET
    URL: /api/waypoints/{id}

    Actualizar un Waypoint
    Método: PUT
    URL: /api/waypoints/{id}
    Body: JSON

```bash
    {
    "name": "Nombre Actualizado",
    "description": "Descripción Actualizada",
    "latitude": 40.73061,
    "longitude": -73.935242
    }
```

    Actualizar Solo Nombre y Descripción de un Waypoint
    Método: PATCH
    URL: /api/waypoints/{id}
    Body: JSON

```bash
    {
    "name": "Nombre Actualizado",
    "description": "Descripción Actualizada"
    }
```
### Estructura del proyecto
    src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── waypointmap
    │   │               ├── WaypointmapApplication.java
    │   │               ├── controller
    │   │               │   └── WaypointController.java
    │   │               ├── model
    │   │               │   └── Waypoint.java
    │   │               ├── repository
    │   │               │   └── WaypointRepository.java
    │   │               └── service
    │   │                   ├── WaypointService.java
    │   │                   └── impl
    │   │                       └── WaypointServiceImpl.java
    │   └── resources
    │       ├── application.properties
    └── test
    └── java
            └── com
                └── example
                    └── waypointmap


