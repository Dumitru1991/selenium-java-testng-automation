package ro.automation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ro.automation.context.TestContext;
import ro.automation.pages.AddRemoveElementsPage;

public class AddRemoveElementsSteps {

    private final AddRemoveElementsPage page;

    public AddRemoveElementsSteps(TestContext context) {
        this.page = new AddRemoveElementsPage(context.getDriver());
    }

    @Given("the user is on the Add\\/Remove Elements page")
    public void theUserIsOnTheAddRemoveElementsPage() {
        page.open();
    }

    @When("the user clicks Add Element {int} time(s)")
    public void theUserClicksAddElement(int count) {
        page.addElements(count);
    }

    @When("the user deletes {int} element(s)")
    public void theUserDeletesElements(int count) {
        page.deleteElements(count);
    }

    @Then("{int} Delete button(s) is/are displayed")
    public void deleteButtonsAreDisplayed(int expected) {
        int actual = page.getDeleteButtonsCount();
        System.out.println("Number of Delete buttons: " + actual);
        Assert.assertEquals(actual, expected, "Unexpected number of Delete buttons!");
    }
}
