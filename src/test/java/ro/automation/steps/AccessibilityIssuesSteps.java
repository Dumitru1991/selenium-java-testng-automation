package ro.automation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import ro.automation.context.TestContext;
import ro.automation.pages.AccessibilityIssuesPage;

public class AccessibilityIssuesSteps {

    private final AccessibilityIssuesPage page;

    public AccessibilityIssuesSteps(TestContext context) {
        this.page = new AccessibilityIssuesPage(context.getDriver());
    }

    @Given("the user is on the Accessibility Issues page")
    public void theUserIsOnTheAccessibilityIssuesPage() {
        page.open();
    }

    @Then("the {string} rule row is visible")
    public void theRuleRowIsVisible(String rule) {
        Assert.assertTrue(page.isRuleRowVisible(rule),
                "The '" + rule + "' rule row is not visible!");
    }

    @Then("the rules table has at least {int} row(s)")
    public void theRulesTableHasAtLeastRows(int minimum) {
        int rows = page.getRuleRowsCount();
        System.out.println("Number of rows: " + rows);
        Assert.assertTrue(rows >= minimum,
                "Expected at least " + minimum + " rows with data-rule, found " + rows);
    }
}
