# Use the official maven/Java 17 image to create a build artifact.
FROM maven:3.9.3-amazoncorretto-17 AS builder
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Build a release artifact.
RUN mvn clean package -DskipTests

# Use the official lightweight Java image.
FROM openjdk:17-slim

# Copy the jar to the production image from the builder stage.
COPY --from=builder /workspace/app/target/parquimetro-0.0.1-SNAPSHOT.jar /parquimetro.jar

# Set the startup command to execute the jar
CMD ["java", "-jar", "/parquimetro.jar"]
