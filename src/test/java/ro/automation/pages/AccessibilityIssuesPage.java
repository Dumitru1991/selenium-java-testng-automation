package ro.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ro.automation.base.BasePage;

public class AccessibilityIssuesPage extends BasePage {

    private final By accessibilityIssuesLink = By.linkText("Accessibility Issues");
    private final By heading = By.tagName("h3");
    private final By randImageAlt = By.xpath("//tr[@data-rule='image-alt']");
    private final By randuriTabel = By.cssSelector("tr[data-rule]");

    public AccessibilityIssuesPage(WebDriver driver) {
        super(driver);
    }

    public void clickAccessibilityIssues() {
        click(accessibilityIssuesLink);
    }

    public String getTitleAccessibilityIssues() {
        return text(heading);
    }

    public boolean isRowVisible() {
        return isVisible(randImageAlt);
    }

    public int getRowsCountAccessibilityIssues() {
        // Folosește gasesteToate() din BasePage pentru a aștepta și număra rândurile
        return findAll(randuriTabel).size();
    }
    
}
