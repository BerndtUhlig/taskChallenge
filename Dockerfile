# Use a base image with OpenJDK
FROM openjdk:17
ARG JAR_FILE=target/*.jar
# Set the working directory
# Copy the application JAR file
COPY ./target/CraftworksChallenge-0.0.1-SNAPSHOT.jar CraftworksChallenge.jar

# Expose the port used by the application
EXPOSE 8080

# Set the command to run the application
ENTRYPOINT ["java", "-jar", "/CraftworksChallenge.jar"]