# Spring Boot REST API Exercise

## Goal

The goal is to create a REST API using Spring Boot and a corresponding Docker image with the help of GitHub Copilot.
Follow the instructions below and try to use GitHub Copilot as much as possible.
Try different things and see what GitHub Copilot can do for you, like generating a Dockerfile or a class, add comments, etc.

## Pre-requisites
> Make sure GitHub Copilot is configured and enabled for the current laguage, just check the status bar on the bottom right corner of VS Code.

> If you are running this exercise in GitHub Codespaces, the java environment is already setup.

> If you are running this exercise in local environment, please make sure that:
- JDK 18 and above is installed. If not installed already, please download from: https://www.oracle.com/au/java/technologies/downloads/ (e.g. jdk-23_windows-x64_bin.msi)
- The environment variable for 'JAVA_HOME' is set. If not, please do one of the following:
  - **Windows 7** – Right click My Computer and select Properties > Advanced
  - **Windows 8** – Go to Control Panel > System > Advanced System Settings
  - **Windows 10** – Search for Environment Variables then select Edit the system environment variables
- Click the **Environment Variables** button.
- Under **System Variables**, click **New**.
- In the **Variable Name** field, enter either:
  - *JAVA_HOME* if you installed the JDK (Java Development Kit)
    or
  - *JRE_HOME* if you installed the JRE (Java Runtime Environment)
- In the **Variable** Value field, enter your JDK or JRE installation path.

  ![env var](image-environment_variable.png)
- Click **OK** and **Apply** Changes as prompted

> You may need to close and re-open any command windows that were open before you made these changes, as there's no way to reload environment variables from an active command prompt. If the changes don't take effect after reopening the command window, restart Windows.

> Tips: Run `$env:JAVA_Home` in PowerShell to check current `JAVA_Home`. You can also use `$env:JAVA_Home="C:\Program Files\Java\jdk-23"` to set current terminal to use the jdk path.
  ![java home](image-java-home-env.png)

## Instructions

The `copilot-demo` folder contains the Maven project and Maven installer.

- `src` contains `main` and `test`. Where `main` is where the source code lives, and `test` contains the unit tests.
- `Dockerfile` will be used to create a docker image for the project.
- `mvnw` is the unix CLI that can be invoked to use maven CLI.
- `mvnw.cmd` is the Windows CLI that can be invoked to use maven CLI.

To run Copilot inline on Windows you press `Ctrl + i` (Windows) / `⌘ + i` (Mac)

To run the app open a terminal in the `copilot-demo` folder and run:

```sh
./mvnw package
./mvnw spring-boot:run
```

To run the tests open a terminal in the `copilot-demo` folder and run:

```sh
./mvnw test
```

### Unix Note

The `mvnw` might not have execute permissions.
Please run the following to give it execute permissions.

```sh
chmod +x ./mvnw
```

### Exercise 1: Write a "Hello world" GET Request

For this exercise we will be adding a new endpoint to handle a simple GET request.

- Move to the `src/main/.../DemoController.java` file
- Start writing the code to handle a simple GET request based on the javadoc comment.
- Just press enter and wait a couple of seconds, Copilot will generate the code for you.
- Alternatively, you can test the Copilot inline feature by pressing `ctrl/⌘ + i`. Then write in the text box the desired behaviour.

You can now run the application and then test it with curl.

1. Run the spring app: `./mvnw spring-boot:run`
2. Test with curl: `curl -v http://localhost:8080/hello?key=world`
3. If you are using GitHub `Codespaces`, replace localhost:8080 with actual `Codespaces` url.

### Exercise 2: Write a "Hello world" Test Case

Navigate to `src/test/.../CopilotDemoApplicationTests.java`, to start writing your first test.

- Just press enter and wait a couple of seconds, Copilot will generate the code for you.
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

### Exercise 3: Building more functionalities

For this exercise, reuse the existing `DemoController.java`.

Add the following endpoints using the help of Copilot, then also create the unit tests for every new operation. It is pretty easy with Copilot !

- **/daysbetweendates**:

  - calculate days between two dates
  - receive by query string two parameters `date1` and `date2`, and calculate the days between those two dates.

> **_NOTE:_** Use above information inside the Copilot inline feature. Press enter and wait for Copilot to suggest you the code.

- **/validatephonenumber**:

  - receive by querystring a parameter called phoneNumber
  - validate phoneNumber with Spanish format, for example `+34666777888`
  - if phoneNumber is valid return true

> **_NOTE:_** Use above information inside a comment. Press enter and wait for Copilot to suggest you the code.

- **/validatespanishdni**:

  - receive by querystring a parameter called dni
  - calculate DNI letter
  - if DNI is valid return "valid"
  - if DNI is not valid return "invalid"

> **_NOTE:_** Use above information inside a comment. In this case, you may want to see multiple solutions from Copilot to pick the one that best fits the way to calculate the letter. In order to see the firs 10 suggestions from Copilot press `ctrl/⌘ + enter`.

- **/returncolorcode**:

  - receive by querystring a parameter called color
  - read colors.json file under resources and return the rgba field
  - get color var from querystring
  - iterate for each color in colors.json to find the color
  - return the hex field
  - return 404 if not found

> **_NOTE:_** Hint: Use TDD. Start by creating the unit test and then implement the code.
> Lets try Copilot chat now.
> Paste the above information and make it as detailed as possible in the Copilot chat text box.
> Copilot will use by default the open file as context in order to generate the suggestion.

### Exercise 4: Refactor your endpoints

In exercise 3, we have created a few endpoints in the `DemoController.java` file. Now let's refactor the code to make it more readable and maintainable by moving those endpoints into separate controllers. With the `DemoController.java` file open, ask Copilot using the chat feature how to refactor those endpoints into separate files.

> **_NOTE:_** You can use the `@workspaces` command to give Copilot the context of the structure of the whole repo.

### Exercise 5: Building more integrations

We have tried out write coding for a few simple tasks earlier. Now let's explore more complex integrations.

> **_NOTE:_** You should follow the same pattern as the previous exercise and create each new endpoint in a separate controllers.

- **/tellmeajoke**:

  - Make a call to the joke api and return a random joke - <https://api.chucknorris.io/jokes/random>

> **_NOTE:_** Here's example where you might need to use you own knowledge and judgement
> to validate that Copilot follows best practices. Just because Copilot mimics
> what many developers do, doesn't always mean it's the correct way. You might need
> to be extra specific in your prompt to let Copilot know what's best practices.

- **/moviesbydirector**:

  - Receive by querystring a parameter called director
  - Make a call to the movie api and return a list of movies of that director
  - Return the full list of movies

> **_NOTE:_** This will require to browse to <https://www.omdbapi.com/apikey.aspx> and request a FREE API Key

- **/parseurl**:

  - Retrieves a parameter from querystring called someurl
  - Parse the url and return the protocol, host, port, path, querystring and hash
  - Return the parsed host

> **_NOTE:_** Copilot can help you learn new frameworks.

- **/listfiles**:

  - Get the current directory
  - Get the list of files in the current directory
  - Return the list of files

> **_NOTE:_** Copilot can also help with these kind of commands locally. The feature is called Copilot in the CLI. You can learn more information about this feature [here](https://docs.github.com/en/copilot/github-copilot-in-the-cli/about-github-copilot-in-the-cli).

- **/calculatememoryconsumption**:

  - Return the memory consumption of the process in GB, rounded to 2 decimals

- **/randomeuropeancountry**:

  - Make an array of european countries and its iso codes
  - Return a random country from the array
  - Return the country and its iso code

### Exercise 6: Adding in Swagger

Lets now add in Swagger to the project. This will involve installing the following dependency `springfox-boot-starter`. The version should be `3.0.0`.

Ask Copilot how you could achieve this. You can use the `@workspaces` command to give Copilot the context of the structure of the whole repo.

### Exercise 7: Refactor the code to follow REST principles

At this point in the previous exercises, we created a number of endpoints that are not following REST principles. Let's refactor the code to follow REST principles. You should also update the Swagger documentation, so that each endpoint has a summary and is grouped using tags.

Ask Copilot how you could achieve this. You can use the `@workspaces` command to give Copilot the context of the structure of the whole repo.

### Exercise 8: Document the code

Documenting code is always a boring and painful task. However, we can use Copilot to document it for us. In the chat, ask Copilot to add javadoc to all of your files.

You can use `@workspaces` to write documentation for the whole repo.

### Exercise 9: Verify Tests

Have you been building your Unit Tests along the way? If not this is the perfect time to take a breather and get Copilot to write some unit tests for you!

We will create automated tests to check that the functionality of the previous endpoints is correctly implemented. The tests should be together in the `CopilotDemoApplicationTests.java` file.

You can leverage Copilot to run the tests. There is a `/tests` command that you can directly run from Copilot Chat or by selecting the piece of code you want to create tests for and using the Copilot inline feature.

### Exercise 10: Create a Dockerfile

Use the Dockerfile provided to create a docker image of the application. There are some comments in the Dockerfile that will help you to complete the exercise.

In order to build, run and test the docker image, you can use Copilot as well to generate the commands.

For instance, create a `DOCKER.md` file where you can store the commands to build, run and test the docker image.

Examples of steps to document: Build the container image, Run the container, Test the container.

## Summary

With the previous exercises you have gone through some common activities that developers usually run:

- Create new features in the code
- Work with external APIs
- Refactor an existing codebase
- Create documentation
- Create tests

However, there are many other things that Copilot can help you with. Feel free to explore other slash command in the Copilot chat like:

- `/fix`: to fix the problems in your code
- `/explain`: for Copilot to explain you what the code does
