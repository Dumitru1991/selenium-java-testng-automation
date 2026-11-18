package ro.automation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ro.automation.context.TestContext;
import ro.automation.pages.CommonPage;

/**
 * Steps reused by several feature files. Cucumber does not allow the same step
 * to be defined twice, so shared steps live here.
 */
public class CommonSteps {

    private final CommonPage page;

    public CommonSteps(TestContext context) {
        this.page = new CommonPage(context.getDriver());
    }

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        page.open();
    }

    @When("the user clicks the {string} link")
    public void theUserClicksTheLink(String linkText) {
        page.clickLink(linkText);
    }

    @Then("the page URL contains {string}")
    public void thePageUrlContains(String fragment) {
        String url = page.getCurrentUrl();
        Assert.assertTrue(url.contains(fragment),
                "The URL does not contain '" + fragment + "': " + url);
    }

    @Then("the page heading is {string}")
    public void thePageHeadingIs(String expected) {
        String heading = page.getHeading();
        System.out.println("Page heading: " + heading);
        Assert.assertEquals(heading, expected, "Unexpected page heading!");
    }
}
