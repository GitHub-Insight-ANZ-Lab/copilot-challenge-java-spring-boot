# Copilot Instructions for Spring Boot REST API Project

## Project Overview
This is a Spring Boot 3.1.1 REST API demo application built with Java 17 and Maven. The project demonstrates RESTful API development with OpenAPI documentation support.

## Technology Stack
- **Java**: 17
- **Spring Boot**: 3.1.1
- **Build Tool**: Maven (using Maven wrapper)
- **API Documentation**: SpringDoc OpenAPI (2.3.0)
- **Testing**: Spring Boot Test Starter

## Project Structure
```
copilot-demo/
├── src/
│   ├── main/
│   │   ├── java/com/microsoft/hackathon/copilotdemo/
│   │   │   ├── CopilotDemoApplication.java (Main application class)
│   │   │   └── controller/ (REST controllers)
│   │   └── resources/
│   │       ├── application.properties (Configuration)
│   │       └── colors.json (Data files)
│   └── test/
│       └── java/com/microsoft/hackathon/copilotdemo/ (Unit tests)
├── pom.xml (Maven dependencies)
├── Dockerfile (Container configuration)
└── mvnw / mvnw.cmd (Maven wrapper)
```

## Coding Standards & Conventions

### Package Naming
- Base package: `com.microsoft.hackathon.copilotdemo`
- Controllers: `com.microsoft.hackathon.copilotdemo.controller`
- Follow standard Java package naming conventions (lowercase, reverse domain)

### Class & Method Naming
- Use PascalCase for class names (e.g., `DemoController`, `CopilotDemoApplication`)
- Use camelCase for method names (e.g., `hello()`, `getColors()`)
- REST controller classes should end with `Controller`
- Test classes should end with `Tests` or `Test`

### Spring Boot Annotations
- Use `@SpringBootApplication` for the main application class
- Use `@RestController` for REST API controllers
- Use `@GetMapping`, `@PostMapping`, etc. for HTTP endpoint mappings
- Use `@RequestParam` for query parameters with appropriate `required` attribute

### Code Style
- Include descriptive comments for complex logic
- Use proper indentation (tabs as per existing code)
- Keep methods focused and concise
- Follow Spring Boot best practices for dependency injection

## REST API Guidelines

### Endpoint Design
- Use RESTful conventions for URLs (e.g., `/hello`, `/api/resource`)
- Use appropriate HTTP methods (GET, POST, PUT, DELETE)
- Return meaningful error messages
- Handle edge cases (null values, empty parameters)

### Response Handling
- Return appropriate HTTP status codes
- Use consistent response formats
- Validate input parameters before processing
- Handle exceptions gracefully

### Example Pattern
```java
@GetMapping("/endpoint")
public String methodName(@RequestParam(required = false) String param) {
    if (param == null || param.isEmpty()) {
        return "default response";
    }
    return "processed " + param;
}
```

## Testing Guidelines

### Test Structure
- Place tests in `src/test/java` mirroring the main package structure
- Use `@SpringBootTest` for integration tests
- Use JUnit 5 for unit testing
- Follow AAA pattern: Arrange, Act, Assert

### Test Naming
- Use descriptive test method names (e.g., `testHelloEndpointWithValidKey()`)
- Test classes should match the class they're testing with `Tests` suffix

## Build & Run Commands

### Building the Project
```bash
./mvnw clean package          # Unix/Linux/Mac
mvnw.cmd clean package         # Windows
```

### Running the Application
```bash
./mvnw spring-boot:run        # Unix/Linux/Mac
mvnw.cmd spring-boot:run      # Windows
```

### Running Tests
```bash
./mvnw test                   # Unix/Linux/Mac
mvnw.cmd test                 # Windows
```

## Docker Guidelines

### Dockerfile Best Practices
- Use multi-stage builds for smaller images
- Base image should support Java 17+
- EXPOSE the application port (typically 8080)
- Use appropriate USER directive for security
- Copy only necessary artifacts

## Configuration

### Application Properties
- Configuration file: `src/main/resources/application.properties`
- Use Spring Boot property naming conventions
- Document non-obvious configuration values

### External Resources
- Place JSON/XML data files in `src/main/resources/`
- Use `@Value` or `@ConfigurationProperties` for external configuration

## API Documentation

### OpenAPI/Swagger
- SpringDoc OpenAPI is configured (accessible at `/swagger-ui.html` when running)
- Document endpoints with appropriate annotations
- Include example responses where helpful

## Common Development Tasks

### Adding a New REST Endpoint
1. Create or update a controller in the `controller` package
2. Add appropriate Spring Web annotations
3. Implement business logic
4. Write corresponding unit tests
5. Test manually and verify in Swagger UI

### Adding Dependencies
1. Update `pom.xml` with new dependency
2. Run `./mvnw clean install` to download
3. Import and use in code

### Troubleshooting
- Check application logs for errors
- Verify Java version is 17+
- Ensure JAVA_HOME is set correctly
- Run `./mvnw clean` to clear build artifacts

## Git Workflow
- Main branch: `main`
- Create feature branches for new work
- Write descriptive commit messages
- Test thoroughly before merging

## Notes for GitHub Copilot
- Prefer using Spring Boot's built-in features over custom implementations
- Follow existing code patterns in the project
- Generate tests alongside new functionality
- Use Spring's dependency injection rather than manual instantiation
- Suggest using Maven wrapper (`./mvnw`) commands for platform independence
