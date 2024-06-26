# FROM eclipse-temurin:17-jdk-alpine
# VOLUME /tmp
# COPY build/libs/*.jar app.jar
# ENTRYPOINT ["java", "-jar", "/app.jar"]
# EXPOSE 8080
# Build stage
FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app
COPY . .
RUN ./gradlew build

# Run stage
FROM eclipse-temurin:17-jdk-alpine AS runner

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]