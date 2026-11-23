package ro.automation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ro.automation.context.TestContext;
import ro.automation.pages.IframesAdvancedPage;

public class IframesAdvancedSteps {

    private final IframesAdvancedPage page;

    public IframesAdvancedSteps(TestContext context) {
        this.page = new IframesAdvancedPage(context.getDriver());
    }

    @Given("the user is on the Advanced Iframes page")
    public void theUserIsOnTheAdvancedIframesPage() {
        page.open();
    }

    @Then("the page access status is {string}")
    public void thePageAccessStatusIs(String expected) {
        String actual = page.getParentAccessText();
        System.out.println("Access status: " + actual);
        Assert.assertEquals(actual, expected, "Unexpected access status!");
    }

    @Then("the {word} frame title is {string}")
    public void theFrameTitleIs(String frameName, String expected) {
        Assert.assertEquals(page.getFrameTitle(frameName), expected,
                "Unexpected title in the " + frameName + " frame!");
    }

    @When("the user clicks Send a message in the {word} frame")
    public void theUserClicksSendMessageInTheFrame(String frameName) {
        page.clickSendMessage(frameName);
    }

    @Then("the send button in the {word} frame reads {string}")
    public void theSendButtonInTheFrameReads(String frameName, String expected) {
        Assert.assertEquals(page.getSendMessageButtonText(frameName), expected,
                "Unexpected button text in the " + frameName + " frame!");
    }

    @Then("the message log is {string}")
    public void theMessageLogIs(String expected) {
        String actual = page.waitForMessageLog(expected);
        System.out.println("Message log: " + actual);
        Assert.assertEquals(actual, expected, "Unexpected message log!");
    }

    @Then("the srcdoc frame text is {string}")
    public void theSrcdocFrameTextIs(String expected) {
        Assert.assertEquals(page.getSrcdocText(), expected, "Unexpected text in the srcdoc frame!");
    }

    @When("the user types {string} in the srcdoc frame input")
    public void theUserTypesInTheSrcdocFrameInput(String value) {
        page.typeInSrcdocInput(value);
    }

    @Then("the srcdoc frame input contains {string}")
    public void theSrcdocFrameInputContains(String expected) {
        Assert.assertEquals(page.getSrcdocInputValue(), expected, "Unexpected value in the srcdoc input!");
    }
}
