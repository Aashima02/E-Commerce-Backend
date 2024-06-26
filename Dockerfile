# Use the official OpenJDK image as a parent image
FROM openjdk:17-jre-slim

# Set the working directory
WORKDIR /app

# Copy the Gradle wrapper and build scripts
COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle settings.gradle /app/

# Copy the application source
COPY src /app/src

# Grant execution rights to the Gradle wrapper
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build -x test

# Copy the built jar file to the container
COPY build/libs/*.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]


# FROM eclipse-temurin:17-jdk-alpine
# VOLUME /tmp
# COPY build/libs/*.jar app.jar
# ENTRYPOINT ["java", "-jar", "/app.jar"]
# EXPOSE 8080
# Build stage
# FROM eclipse-temurin:17-jdk-alpine AS builder
#
# WORKDIR /app
# COPY . .
# RUN ./gradlew build
#
# # Run stage
# FROM eclipse-temurin:17-jdk-alpine AS runner
#
# WORKDIR /app
# COPY --from=builder /app/target/*.jar app.jar
#
# CMD ["java", "-jar", "app.jar"]

