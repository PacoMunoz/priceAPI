# API REST de Búsqueda de Precios de Productos

Este proyecto Java implementa una API REST para buscar precios de productos. La API expone un solo método de búsqueda accesible a través de la siguiente URL: `http://localhost:8080/v1/productprices/search`.

## Requisitos

- Java 17 o superior
- Maven

## Configuración

### Parámetros Obligatorios

El método de búsqueda requiere los siguientes parámetros:

- `applicationDate`: Fecha y hora de la aplicación en formato ISO 8601.
- `productId`: ID del producto a buscar.
- `brandId`: ID de la marca del producto a buscar.

## Ejecución

### Paso 1: Clonar el Repositorio

```bash
git clone <url_del_repositorio>
cd nombre_del_repositorio
```

### Paso 2: Compilar el Proyecto

Utiliza Maven para compilar el proyecto:

```bash
mvn clean package
``` 

### Paso 3: Ejecutar la Aplicación

Una vez compilado, puedes ejecutar la aplicación utilizando el archivo JAR generado:

```bash
java -jar price-0.0.1-SNAPSHOT.jar
``` 

## Uso de la API

### Método de Búsqueda

#### URL
```bash
GET /productprices/search
```
#### Parámetros de Consulta

- `applicationDate` (obligatorio): Fecha y hora de la aplicación en formato ISO 8601.
- `productId` (obligatorio): ID del producto a buscar.
- `brandId` (obligatorio): ID de la marca del producto a buscar.

#### Ejemplo de Uso

```bash
GET /productprices/search?applicationDate=2024-05-07T12:00:00&productId=12345&brandId=6789
```


