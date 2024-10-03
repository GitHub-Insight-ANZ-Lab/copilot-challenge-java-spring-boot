# Spring Boot REST API Exercise

## Goal

The goal of this exercise is to learn how to use GitHub Copilot, using an exercise that consist of building a REST API using Spring Boot.

## Instructions

The `copilot-demo` folder contains the Maven project and Maven installer.

- `src` contains `main` and `test`. Where `main` is where the source code lives, and `test` contains the unit tests.
- `Dockerfile` will be used to create a docker image for the project.
- `mvnw` is the unix CLI that can be invoked to run the project.
- `mvnw.cmd` is the Windows CLI that can be invoked to run the project.

To run Copilot inline on Windows you press `Ctrl + i` (Windows) / `⌘ + i` (Mac)

To run the tests open a terminal in the `copilot-demo` folder and run:

```sh
./mvnw test
```

To run the app open a terminal in the `copilot-demo` folder and run:

```sh
./mvnw package
./mvnw spring-boot:run

```

### Unix Note

The `mvnw` might not have execute permissions.
Please run the following to give it execute permissions.

```sh
chmod +x ./mvnw
```

### Exercise 1: Introduction

For this exercise we will be adding a new endpoint to handle a simple GET request.

- Move to the `src/main/.../DemoController.java` file
- Start writing the code to handle a simple GET request based on the javadoc comment. Just press enter and wait a couple of seconds, Copilot will generate the code for you.
- Alternatively, you can test the Copilot inline feature by pressing `ctrl/⌘ + i`. Then write in the text box the desired behaviour.
- run `./mvnw test`
- If the test passed you should see something like this:

```sh
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.501 s - in com.microsoft.hackathon.copilotdemo.CopilotDemoApplicationTests
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.713 s
[INFO] Finished at: 2024-10-03T10:49:49+08:00
[INFO] ------------------------------------------------------------------------
```

You can now run the application and then test it with curl.

1. Run the spring app: `./mvnw spring-boot:run`
2. Test with curl: `curl -v http://localhost:8080/hello?key=world`

Let's now create a new unit test for the case when no key is provided in the request.

- Move to `src/test/.../CopilotDemoApplicationTests.java`
- Create a comment with `//` and ask it to generate the test case for you. Wait a couple of seconds and it should autocomplete the test for you.
- You should then see the following output

```sh
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.451 s - in com.microsoft.hackathon.copilotdemo.CopilotDemoApplicationTests
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.686 s
[INFO] Finished at: 2024-10-03T11:04:09+08:00
[INFO] ------------------------------------------------------------------------
```

### 2. Dates comparison

New operation under /diffdates that calculates the difference between two dates. The operation should receive two dates as parameter in format dd-MM-yyyy and return the difference in days.

Additionally, create a unit test that validates the operation.

From now on, you will have to create the unit tests for every new operation. Wasn't it easy with Copilot?

### 3. Validate the format of a spanish phone

Validate the format of a spanish phone number (+34 prefix, then 9 digits, starting with 6, 7 or 9). The operation should receive a phone number as parameter and return true if the format is correct, false otherwise.

### 4. Validate the format of a spanish DNI

Validate the format of a spanish DNI (8 digits and 1 letter). The operation should receive a DNI as parameter and return true if the format is correct, false otherwise.

### 5. From color name to hexadecimal code

Based on existing colors.json file under resources, given the name of the color as path parameter, return the hexadecimal code. If the color is not found, return 404

Hint: Use TDD. Start by creating the unit test and then implement the code.

### 6. Jokes creator

Create a new operation that call the API https://api.chucknorris.io/jokes/random and return the joke.

### 7. URL parsing

Given a url as query parameter, parse it and return the protocol, host, port, path and query parameters. The response should be in Json format.

### 8. List files and folders

List files and folders under a given path. The path should be a query parameter. The response should be in Json format.

### 9. Word counting

Given the path of a file and count the number of occurrence of a provided word. The path and the word should be query parameters. The response should be in Json format.

### 10. Zipping

Create a zip file with the content of a given folder. The path of the folder should be a query parameter.

### 11. Containerize the application

Use the Dockerfile provided to create a docker image of the application. There are some comments in the Dockerfile that will help you to complete the exercise.

In order to build, run and test the docker image, you can use Copilot as well to generate the commands.

For instance, create a DOCKER.md file where you can store the commands to build, run and test the docker image. You will notice that Copilot will also help you to document your project and commands.

Examples of steps to document: Build the container image, Run the container, Test the container.
