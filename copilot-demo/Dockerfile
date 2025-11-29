# Build a java application image based on openjdk 17 and run it on port 8080

# Stage 1: Build the application
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Create a non-root user and group, change ownership of /app, and switch to this user
RUN addgroup --system javauser && adduser --system --ingroup javauser javauser && chown -R javauser:javauser /app
USER javauser
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
