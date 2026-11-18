# UI Automation - Java + Maven + TestNG + Selenium

## Requirements

- JDK 21
- Maven 3.8+ (or Maven Wrapper, if added)
- Google Chrome installed
- Internet connection on the first run to download Maven dependencies and, if necessary, the ChromeDriver.

## Opening the Project in IntelliJ IDEA

1. Extract the project archive.
2. Select **File > Open** and choose the `UiAutomationMaven` directory.
3. If prompted, import the project as a Maven project.
4. Make sure the Project SDK is set to JDK 21.
5. Open `pom.xml` and click **Load Maven Changes** if prompted.

## Running the Tests

Open a terminal in the project directory and run:

```bash
mvn clean test
```

Alternatively, you can run `GoogleTest` or `testng.xml` directly from IntelliJ IDEA.

## What the Test Does

- `BaseTest` launches Chrome before each test method.
- `GoogleTest` opens https://www.google.com and verifies the current URL.
- `BaseTest.tearDown()` closes the browser after each test, even if the test fails.

## WebDriver Management

Selenium 4 includes Selenium Manager. Normally, you do not need to download `chromedriver` manually. Selenium Manager attempts to locate or download the appropriate driver automatically.

Google Chrome must be installed on your machine.
