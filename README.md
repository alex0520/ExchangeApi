# ExchangeApi
Proyecto con api rest para cambio de divisas

## Proceso de compilación

Este proyecto es un proyecto maven, por lo cual para realizar la compilación y descarga de dependencias es necesario ejecutar `mvn clean install`
si todo sale correctamente, verá un archivo `exchange-0.0.1-SNAPSHOT.jar` en la carpeta target del proyecto.

## Proceso de despliegue

Este proyecto realiza la creación de las tablas de la base de datos en MySQL usando `liquibase`, para ejecutar la aplicación se ejecuta
`java -jar target/exchange-0.0.1-SNAPSHOT.jar` al iniciarse por primera vez, intentará crear la respectiva base de datos,
conectandose a `localhost:3306` con usuario `root` y clave `123456`