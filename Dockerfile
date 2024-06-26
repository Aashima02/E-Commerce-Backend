# Use the official Eclipse Temurin image for JDK 17
FROM eclipse-temurin:17-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the entire project to the working directory
COPY . .

# Grant execute permissions on the Gradle wrapper script
RUN chmod +x ./gradlew

# Build the project using the Gradle wrapper
RUN ./gradlew build

# Copy the built JAR file to the app directory
COPY build/libs/*.jar app.jar

# Specify the entrypoint for the container to run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose port 8080 to the host machine
EXPOSE 8080


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

