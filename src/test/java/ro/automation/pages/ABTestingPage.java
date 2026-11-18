package ro.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ro.automation.base.BasePage;

public class ABTestingPage extends BasePage {

    private final By pageHeading = By.tagName("h3");

    public ABTestingPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPage("abtest");
    }

    public String getHeading() {
        return text(pageHeading);
    }
}
