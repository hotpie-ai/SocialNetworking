# Step 1: Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy Gradle wrapper and project files
COPY build/libs/*.jar app.jar

# Step 4: Expose port 8080
EXPOSE 8080

# Step 5: Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
