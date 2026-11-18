package ro.automation.context;

import org.openqa.selenium.WebDriver;

/**
 * Object shared between Hooks and Step Definitions within one scenario.
 * PicoContainer creates a new instance for every scenario.
 */
public class TestContext {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
