# Use OpenJDK 17 as base
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Gradle build output
COPY build/libs/user-service-1.0.0.jar user-service.jar

# Expose port 8080
EXPOSE 8081

# Run the app
ENTRYPOINT ["java", "-jar", "user-service.jar"]
