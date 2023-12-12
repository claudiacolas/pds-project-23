# Usa la imagen de OpenJDK 11 como base
FROM openjdk:11-jre-slim

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR de la carpeta target al contenedor en la carpeta /app
COPY target/todo-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080 en el contenedor
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicia el contenedor
CMD ["java", "-jar", "app.jar"]