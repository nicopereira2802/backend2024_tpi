# Endpoints

### 1
POST /pruebas
BODY info de la prueba nueva

Respuesta puede ser:
* solo un codigo de estatus 201, indicando que se creo exitosamente
y 400 para cuando hubo algun error de validacion

* el id de la nueva prueba

### 2
GET /pruebas/in-course

* todas las pruebas que se encuentren en curso, es decir aquellas que no tieenne fechaHoraFin

Respuesta:
* 200 y listado, si no encontro ninguna prueba, listado vacio
/* diferencia entre put y pacht?*/

### 3
PATCH /pruebas/{id_prueba}/end
body {
    "comentario": " " // puede ser Nulo
}
* 200 si todo esta ok 
 
### 4
POST /vehiculo/{id_vehiculo}/posicion

Body info de la posicion
Respuesta
* 201 si se pudo crear,

### 5

POST /notificaciones/promos
Body Listado de telefonos a notificar


### 6

#### a 
GET /pruebas/incidentes

#### b 
GET /empleados/{id_empleados}/incidentes

#### c
GET /vehiculo/{id_vehiculo}/kilometros

parametros fecha_desde y fecha_hasta

#### d
GET /vehiculos/{id_vehiculo}/pruebas

IMPORTANTE LAS PETICIONES SE LAS DEBEN REALIZAR AL GATEWAY


