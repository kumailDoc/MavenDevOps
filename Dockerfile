# Use an official OpenJDK runtime as a base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/MavenProjectDevOps-3.2.2.jar /app/

# Specify the command to run your application
CMD ["java", "-jar", "MavenProjectDevOps-3.2.2.jar"]
