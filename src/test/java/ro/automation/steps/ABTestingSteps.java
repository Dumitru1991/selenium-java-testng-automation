package ro.automation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import ro.automation.context.TestContext;
import ro.automation.pages.ABTestingPage;

public class ABTestingSteps {

    private final ABTestingPage page;

    public ABTestingSteps(TestContext context) {
        this.page = new ABTestingPage(context.getDriver());
    }

    @Given("the user is on the A\\/B Testing page")
    public void theUserIsOnTheAbTestingPage() {
        page.open();
    }

    @Then("the page heading is one of {string} or {string}")
    public void thePageHeadingIsOneOf(String variation1, String variation2) {
        String heading = page.getHeading();
        System.out.println("Page heading: " + heading);
        Assert.assertTrue(
                heading.equals(variation1) || heading.equals(variation2),
                "Unexpected page heading: " + heading
        );
    }
}
