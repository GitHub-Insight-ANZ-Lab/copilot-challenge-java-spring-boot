# Spring Boot REST API - Copilot Demo Solution

## 📋 Table of Contents
- [Overview](#overview)
- [Technology Stack](#technology-stack)
- [Project Architecture](#project-architecture)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Testing](#testing)
- [Docker Deployment](#docker-deployment)
- [Project Structure](#project-structure)
- [Implementation Details](#implementation-details)
- [Development Workflow](#development-workflow)
- [Troubleshooting](#troubleshooting)

---

## Overview

This is a comprehensive Spring Boot REST API demonstration project built with the assistance of GitHub Copilot. The project showcases various REST API development practices, including endpoint creation, external API integration, data validation, file handling, and Docker containerization.

### Key Features
- RESTful API endpoints with Spring Boot
- OpenAPI/Swagger documentation integration
- Comprehensive unit testing with MockMvc
- Docker containerization with multi-stage builds
- Resource file handling (JSON parsing)
- External API integrations
- Input validation and error handling

---

## Technology Stack

### Core Technologies
- **Java**: 17 (LTS)
- **Spring Boot**: 3.1.1
- **Build Tool**: Maven 3.9+
- **API Documentation**: SpringDoc OpenAPI 2.3.0

### Dependencies
```xml
<dependencies>
    <!-- Spring Boot Web Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Spring Boot Test Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    
    <!-- SpringDoc OpenAPI UI -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.3.0</version>
    </dependency>
</dependencies>
```

### Container Technologies
- **Base Image**: eclipse-temurin:17-jre
- **Build Image**: maven:3.9-eclipse-temurin-17
- **Orchestration**: Docker Compose

---

## Project Architecture

### Application Structure
```
copilot-demo/
├── src/
│   ├── main/
│   │   ├── java/com/microsoft/hackathon/copilotdemo/
│   │   │   ├── CopilotDemoApplication.java       # Main Spring Boot application
│   │   │   └── controller/
│   │   │       └── DemoController.java           # REST API endpoints
│   │   └── resources/
│   │       ├── application.properties            # Application configuration
│   │       └── colors.json                       # Sample JSON data
│   └── test/
│       └── java/com/microsoft/hackathon/copilotdemo/
│           └── CopilotDemoApplicationTests.java  # Unit tests
├── .mvn/                                         # Maven wrapper configuration
├── pom.xml                                       # Maven project configuration
├── Dockerfile                                    # Docker image definition
├── docker-compose.yml                            # Docker Compose configuration
├── mvnw                                          # Maven wrapper script (Unix)
└── mvnw.cmd                                      # Maven wrapper script (Windows)
```

### Design Patterns
- **MVC Pattern**: Separation of concerns with controllers, services would be added for complex logic
- **RESTful Architecture**: HTTP methods and status codes following REST principles
- **Dependency Injection**: Spring's IoC container for managing beans
- **Test-Driven Development**: Comprehensive test coverage with MockMvc

---

## Prerequisites

### Required Software
1. **Java Development Kit (JDK) 17 or higher**
   - Download from: https://www.oracle.com/java/technologies/downloads/
   - Or use OpenJDK: https://adoptium.net/

2. **Maven 3.6+** (Optional - project includes Maven Wrapper)

3. **Docker** (Optional - for containerization)
   - Download from: https://www.docker.com/products/docker-desktop

4. **Git** (for cloning the repository)

### Environment Setup

#### Windows
1. Install JDK 17+
2. Set `JAVA_HOME` environment variable:
   - Right-click **This PC** → **Properties** → **Advanced System Settings**
   - Click **Environment Variables**
   - Under **System Variables**, click **New**
   - Variable name: `JAVA_HOME`
   - Variable value: Path to JDK installation (e.g., `C:\Program Files\Java\jdk-17`)
   - Click **OK** and restart any open command prompts

   **Verify installation:**
   ```powershell
   $env:JAVA_HOME
   java -version
   ```

#### macOS/Linux
1. Install JDK 17+:
   ```bash
   # macOS (using Homebrew)
   brew install openjdk@17
   
   # Ubuntu/Debian
   sudo apt-get install openjdk-17-jdk
   ```

2. Set `JAVA_HOME` in your shell profile (`~/.bashrc`, `~/.zshrc`, etc.):
   ```bash
   export JAVA_HOME=$(/usr/libexec/java_home -v 17)  # macOS
   # or
   export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64  # Linux
   ```

3. Give Maven wrapper execute permissions:
   ```bash
   chmod +x ./mvnw
   ```

---

## Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd copilot-challenge-java-spring-boot/copilot-demo
```

### 2. Build the Project
```bash
# Unix/Linux/macOS
./mvnw clean package

# Windows
mvnw.cmd clean package
```

This command will:
- Download all required dependencies
- Compile the source code
- Run all unit tests
- Package the application as a JAR file in the `target/` directory

### 3. Verify Installation
```bash
# Unix/Linux/macOS
./mvnw --version

# Windows
mvnw.cmd --version
```

Expected output should show Maven and Java versions.

---

## Running the Application

### Development Mode

#### Using Maven Wrapper (Recommended)
```bash
# Unix/Linux/macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

#### Using JAR File
```bash
# First, build the project
./mvnw clean package

# Then run the JAR
java -jar target/copilot-demo-0.0.1-SNAPSHOT.jar
```

### Application URLs
Once the application starts, it will be available at:
- **Base URL**: http://localhost:8080
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI Docs**: http://localhost:8080/v3/api-docs

### Verify Application is Running
```bash
# Test the hello endpoint
curl "http://localhost:8080/hello?key=world"
# Expected output: hello world
```

### Stop the Application
Press `Ctrl+C` in the terminal where the application is running.

---

## API Documentation

### Interactive API Documentation

The application includes SpringDoc OpenAPI for interactive API documentation.

**Access Swagger UI**: http://localhost:8080/swagger-ui.html

### Available Endpoints

#### 1. Hello Endpoint
```
GET /hello?key={value}
```
**Description**: Returns a greeting message with the provided key.

**Parameters**:
- `key` (query, optional): The value to include in the greeting

**Responses**:
- Success: `hello {key}`
- No key provided: `key not passed`

**Example**:
```bash
# With key
curl "http://localhost:8080/hello?key=world"
# Response: hello world

# Without key
curl "http://localhost:8080/hello"
# Response: key not passed
```

### Extending the API

The project structure supports additional endpoints as demonstrated in the exercises:
- `/daysbetweendates` - Calculate days between two dates
- `/validatephonenumber` - Validate Spanish phone numbers
- `/validatespanishdni` - Validate Spanish DNI
- `/returncolorcode` - Return color codes from JSON
- `/tellmeajoke` - Fetch random jokes
- `/moviesbydirector` - Query movie database
- `/parseurl` - Parse URL components
- `/listfiles` - List directory files
- `/calculatememoryconsumption` - Memory usage information
- `/randomeuropeancountry` - Random European country data

---

## Testing

### Running All Tests
```bash
# Unix/Linux/macOS
./mvnw test

# Windows
mvnw.cmd test
```

### Test Coverage

#### Current Test Suite
The project includes comprehensive unit tests in `CopilotDemoApplicationTests.java`:

1. **testHelloWithKey()**: Validates the `/hello` endpoint with a valid key parameter
2. **testHelloWithoutKey()**: Validates the endpoint when no key is provided
3. **testHelloWithEmptyKey()**: Validates the endpoint with an empty key parameter

### Test Implementation Details

**Testing Framework**: JUnit 5 + Spring Boot Test + MockMvc

**Example Test**:
```java
@Test
void testHelloWithKey() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("key", "world"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("hello world"));
}
```

### Test Results Format
```
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

### Writing Additional Tests

Follow the Test-Driven Development (TDD) approach:
1. Write the test first
2. Run the test (it should fail)
3. Implement the feature
4. Run the test again (it should pass)
5. Refactor if needed

---

## Docker Deployment

### Dockerfile Overview

The project uses a **multi-stage Docker build** for optimal image size and security:

#### Stage 1: Build
- Uses `maven:3.9-eclipse-temurin-17` as the build image
- Copies source code and dependencies
- Compiles and packages the application (skipping tests)

#### Stage 2: Runtime
- Uses `eclipse-temurin:17-jre` (JRE only, smaller image)
- Copies only the built JAR file from Stage 1
- Creates a non-root user for security
- Exposes port 8080

### Building the Docker Image

```bash
# Build the image
docker build -t copilot-demo:latest .

# Verify the image was created
docker images | grep copilot-demo
```

### Running the Docker Container

#### Using Docker CLI
```bash
# Run the container
docker run -d \
  --name copilot-demo-app \
  -p 8080:8080 \
  copilot-demo:latest

# View container logs
docker logs copilot-demo-app

# Follow logs in real-time
docker logs -f copilot-demo-app

# Stop the container
docker stop copilot-demo-app

# Remove the container
docker rm copilot-demo-app
```

#### Using Docker Compose
```bash
# Start the application
docker-compose up -d

# View logs
docker-compose logs -f

# Stop the application
docker-compose down

# Rebuild and restart
docker-compose up -d --build
```

### Testing the Dockerized Application
```bash
# Wait a few seconds for the application to start, then test
curl "http://localhost:8080/hello?key=docker"
# Expected output: hello docker

# Test health (if health endpoint is configured)
curl "http://localhost:8080/actuator/health"
```

### Docker Image Details
- **Image Size**: ~250-300 MB (optimized with JRE instead of JDK)
- **Base Image**: Eclipse Temurin 17 JRE (Alpine-based for smaller size)
- **Security**: Non-root user (javauser)
- **Port**: 8080

### Docker Compose Configuration

```yaml
services:
  copilot-demo:
    build:
      context: .
      dockerfile: Dockerfile
    container_name: copilot-demo-app
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=prod
    restart: unless-stopped
    healthcheck:
      test: ["CMD", "curl", "-f", "http://localhost:8080/actuator/health"]
      interval: 30s
      timeout: 10s
      retries: 3
      start_period: 40s
```

---

## Project Structure

### Source Code Organization

#### Main Application
- **CopilotDemoApplication.java**: Entry point of the Spring Boot application
  - Contains `@SpringBootApplication` annotation
  - Bootstraps the Spring context

#### Controllers
- **DemoController.java**: REST API controller
  - Handles HTTP requests
  - Maps endpoints to handler methods
  - Uses `@RestController` and `@GetMapping` annotations

#### Resources
- **application.properties**: Application configuration (currently empty, uses defaults)
- **colors.json**: Sample JSON data for demonstrating file reading

#### Tests
- **CopilotDemoApplicationTests.java**: Unit and integration tests
  - Uses `@SpringBootTest` for full Spring context
  - Uses `MockMvc` for testing REST endpoints
  - Includes 3 test cases covering different scenarios

---

## Implementation Details

### Hello Endpoint Implementation

**Controller Code**:
```java
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String key) {
        if (key == null || key.isEmpty()) {
            return "key not passed";
        }
        return "hello " + key;
    }
}
```

**Key Features**:
- Uses `@GetMapping` for HTTP GET requests
- `@RequestParam(required = false)` makes the parameter optional
- Simple validation logic for null and empty strings
- Returns plain text response

### Spring Boot Configuration

**Application Properties**: The project uses Spring Boot's default configuration with OpenAPI documentation enabled.

**Defaults**:
- Server port: 8080
- Context path: /
- Logging level: INFO

**OpenAPI Configuration**: Automatically enabled via `springdoc-openapi-starter-webmvc-ui` dependency.

---

## Development Workflow

### Adding New Features

1. **Define Requirements**: Clearly specify the endpoint's purpose
2. **Write Tests First** (TDD approach):
   ```java
   @Test
   void testNewFeature() throws Exception {
       // Arrange, Act, Assert
   }
   ```
3. **Implement the Feature**: Add the controller method
4. **Run Tests**: Verify implementation
5. **Document**: Update Swagger/OpenAPI annotations
6. **Commit**: Use descriptive commit messages

### Code Style Guidelines

- Use Java naming conventions (camelCase for methods, PascalCase for classes)
- Keep methods focused and concise
- Add JavaDoc comments for public APIs
- Follow REST principles for endpoint design
- Write meaningful test names

### Using GitHub Copilot

This project was built with GitHub Copilot assistance. Tips for using Copilot:

1. **Inline Suggestions**: Press `Ctrl/Cmd + I` for inline chat
2. **Comment-Driven Development**: Write descriptive comments, let Copilot generate code
3. **Test Generation**: Use `/tests` command in Copilot Chat
4. **Refactoring**: Ask Copilot for refactoring suggestions with `@workspace` context
5. **Documentation**: Use Copilot to generate JavaDoc comments

---

## Troubleshooting

### Common Issues

#### 1. Port Already in Use
**Error**: `Port 8080 is already in use`

**Solution**:
```bash
# Find process using port 8080
# macOS/Linux
lsof -i :8080

# Windows
netstat -ano | findstr :8080

# Kill the process or change the port
# Add to application.properties:
server.port=8081
```

#### 2. JAVA_HOME Not Set
**Error**: `JAVA_HOME environment variable is not set`

**Solution**:
```bash
# macOS/Linux
export JAVA_HOME=$(/usr/libexec/java_home -v 17)

# Windows (PowerShell)
$env:JAVA_HOME="C:\Program Files\Java\jdk-17"
```

#### 3. Maven Wrapper Permission Denied
**Error**: `Permission denied: ./mvnw`

**Solution**:
```bash
chmod +x ./mvnw
```

#### 4. Build Failures
**Error**: Various compilation or test errors

**Solution**:
```bash
# Clean and rebuild
./mvnw clean install

# Skip tests if needed (not recommended)
./mvnw clean package -DskipTests
```

#### 5. Docker Build Fails
**Error**: Docker build issues

**Solution**:
```bash
# Clear Docker cache
docker builder prune

# Rebuild without cache
docker build --no-cache -t copilot-demo:latest .
```

### Getting Help

- Check application logs for detailed error messages
- Review Spring Boot documentation: https://spring.io/projects/spring-boot
- SpringDoc OpenAPI docs: https://springdoc.org/
- Maven documentation: https://maven.apache.org/

---

## Build Information

### Maven Build Lifecycle

```bash
# Clean the project (remove target directory)
./mvnw clean

# Compile source code
./mvnw compile

# Run tests
./mvnw test

# Package as JAR (includes compile and test)
./mvnw package

# Install to local Maven repository
./mvnw install
```

### Build Output
- **JAR Location**: `target/copilot-demo-0.0.1-SNAPSHOT.jar`
- **JAR Size**: ~18-20 MB (includes embedded Tomcat)

---

## Performance Considerations

### Application Startup
- **Typical startup time**: 3-5 seconds
- **Memory footprint**: ~200-300 MB (initial)
- **Docker startup time**: 5-8 seconds (includes container initialization)

### Optimization Tips
1. Use Spring Boot DevTools for faster development
2. Configure appropriate JVM memory settings for production
3. Use Docker multi-stage builds (already implemented)
4. Enable Spring Boot Actuator for monitoring
5. Consider using GraalVM for native compilation (advanced)

---

## Security Considerations

### Current Implementation
- Docker runs as non-root user (`javauser`)
- No hardcoded credentials or secrets
- Input validation on endpoints

### Production Recommendations
1. Add Spring Security for authentication/authorization
2. Enable HTTPS/TLS
3. Implement rate limiting
4. Add CORS configuration
5. Enable security headers
6. Use environment variables for sensitive configuration
7. Implement request validation and sanitization
8. Add audit logging

---

## Contributing

When contributing to this project:

1. Follow existing code style and patterns
2. Write tests for new features
3. Update documentation
4. Use meaningful commit messages
5. Leverage GitHub Copilot for productivity

---

## License

This project is part of the Microsoft Hackathon Copilot Demo series.

---

## Additional Resources

### Documentation
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [SpringDoc OpenAPI](https://springdoc.org/)
- [Docker Documentation](https://docs.docker.com/)
- [GitHub Copilot](https://docs.github.com/en/copilot)

### Tutorials
- [Building REST APIs with Spring Boot](https://spring.io/guides/tutorials/rest/)
- [Testing Spring Boot Applications](https://spring.io/guides/gs/testing-web/)
- [Containerizing Spring Boot Applications](https://spring.io/guides/topicals/spring-boot-docker/)

---

## Version History

- **v0.0.1-SNAPSHOT**: Initial implementation
  - Basic hello endpoint
  - Docker containerization
  - OpenAPI documentation
  - Unit tests with MockMvc

---

## Contact & Support

For questions or issues related to this demo project, please refer to the main repository README or contact the project maintainers.

---

**Built with ❤️ and GitHub Copilot**
