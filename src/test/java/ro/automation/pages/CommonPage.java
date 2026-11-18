package ro.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ro.automation.base.BasePage;

/**
 * Actions shared by every page of the-internet.herokuapp.com:
 * opening the home page, clicking a link by its text and reading the h3 heading.
 */
public class CommonPage extends BasePage {

    private final By heading = By.tagName("h3");

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openHomePage();
    }

    public void clickLink(String linkText) {
        click(By.linkText(linkText));
    }

    public String getHeading() {
        return text(heading);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
