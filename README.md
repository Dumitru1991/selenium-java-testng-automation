# UI Automation - Java + Maven + Selenium + Cucumber (BDD) + TestNG

UI tests for https://the-internet.herokuapp.com/, written as Gherkin scenarios and run by Cucumber through TestNG.

## Requirements

- JDK 21
- Maven 3.8+
- Google Chrome installed
- Internet connection on the first run to download Maven dependencies and, if necessary, the ChromeDriver.

## Project Structure

```
src/test/
├── java/ro/automation/
│   ├── base/BasePage.java          # common Selenium helpers (waits, click, text, ...)
│   ├── pages/                      # Page Objects
│   ├── steps/                      # Cucumber step definitions (CommonSteps holds shared steps)
│   ├── hooks/Hooks.java            # starts Chrome before / closes it after every scenario
│   ├── context/TestContext.java    # shares the WebDriver between hooks and steps (PicoContainer)
│   └── runners/CucumberTestRunner.java
└── resources/
    ├── features/                   # Gherkin .feature files
    └── testng.xml
```

## Running the Tests

Whole suite:

```bash
mvn clean test
```

Only the Cucumber runner, filtered by feature, scenario line or tag:

```bash
mvn test -Dtest=CucumberTestRunner "-Dcucumber.features=src/test/resources/features/ab_testing.feature"
mvn test -Dtest=CucumberTestRunner "-Dcucumber.features=src/test/resources/features/ab_testing.feature:7"
mvn test -Dtest=CucumberTestRunner "-Dcucumber.filter.tags=@smoke"
```

### From VS Code

- Press `Ctrl+Shift+B` with a `.feature` file open to run that feature, or pick another task
  (scenario at cursor, by tag, all features) from **Terminal > Run Task...**. Tasks are defined in `.vscode/tasks.json`.
- `CucumberTestRunner` can also be run from the **Testing** panel.
- Install the **Cucumber** extension (`CucumberOpen.cucumber-official`) for syntax highlighting,
  step autocomplete and Go to Definition.

### From IntelliJ IDEA

Install the **Cucumber for Java** plugin to run a feature or scenario directly from the gutter, or run `testng.xml`.

## Reports

After a run, the Cucumber report is in `target/cucumber-reports/cucumber.html`.
A screenshot is attached to the report for every failed scenario.

## WebDriver Management

Selenium 4 includes Selenium Manager, so you normally do not need to download `chromedriver` manually.
Google Chrome must be installed on your machine.
