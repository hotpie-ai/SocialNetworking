# Step 1: Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy the JAR file built by Gradle
COPY build/libs/*.jar app.jar

# Step 4: Expose port 8082 (as per application.yml)
EXPOSE 8082

# Step 5: Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
