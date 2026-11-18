package ro.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ro.automation.base.BasePage;

public class AccessibilityIssuesPage extends BasePage {

    private final By ruleRows = By.cssSelector("tr[data-rule]");

    public AccessibilityIssuesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPage("accessibility_issues");
    }

    public boolean isRuleRowVisible(String rule) {
        return isVisible(By.cssSelector("tr[data-rule='" + rule + "']"));
    }

    public int getRuleRowsCount() {
        // findAll() from BasePage waits until the rows are present, then counts them
        return findAll(ruleRows).size();
    }
}
