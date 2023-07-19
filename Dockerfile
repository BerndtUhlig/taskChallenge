# Use a base image with OpenJDK
FROM openjdk:17
ARG JAR_FILE=target/*.jar
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]

# Expose the port used by the application

