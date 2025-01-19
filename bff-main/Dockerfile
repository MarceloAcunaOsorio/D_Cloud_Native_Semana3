
# Dockerfile
FROM openjdk:21-jdk-slim

#directorio de trabajo
WORKDIR /app

# Aqui debemos asegurarnos del nombre de nuestro jar coincida
COPY target/bff-0.0.1-SNAPSHOT.jar app.jar

# Ubicacion y nombre del wallet descomprimido
COPY ./Wallet_QMX8X1I4LTY0NIR1 /app/Wallet_tienda

#PUERTO
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]




