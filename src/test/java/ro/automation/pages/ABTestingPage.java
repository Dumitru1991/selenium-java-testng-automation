
package ro.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ro.automation.base.BasePage;

public class ABTestingPage extends BasePage {

    private final By abTestingLink = By.linkText("A/B Testing");
    private final By titluPagina = By.tagName("h3");

    public ABTestingPage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get(BASE_URL);
    }

    public void openAbPage() {
        driver.get("https://the-internet.herokuapp.com/abtest");
    }

    public void clickAbTesting() {
        click(abTestingLink);
    }

    public String getTitleABTesting() {
        return text(titluPagina);
    }
}
