#Usar imagem para subir pro docker 
FROM docker:latest

# Use a imagem base do Java
FROM openjdk:11-jre-slim

# Defina o diretório de trabalho
WORKDIR /app


COPY ./docker-compose.yml /app/docker-compose.yml

# Copie o arquivo JAR da aplicação para o contêiner
COPY api-estoque-0-0.2-SNAPSHOT.jar /app/api-estoque-0-0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["docker-compose", "up"]

# Comando para executar a aplicação Java
ENTRYPOINT ["java", "-jar", "api-estoque-0-0.2-SNAPSHOT.jar"]
