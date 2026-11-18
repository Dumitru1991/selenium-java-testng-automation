package ro.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ro.automation.base.BaseTest;
import ro.automation.pages.ABTestingPage;

public class ABTestingTest extends BaseTest {

    @Test
    public void verifyABTestingNavigation() {
        ABTestingPage page = new ABTestingPage(driver);
        page.openHomePage();
        page.clickAbTesting();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/abtest"),
                "Nu am ajuns pe pagina A/B Testing!"
        );
    }

    @Test
    public void verifyABTestingHeading() {
        ABTestingPage page = new ABTestingPage(driver);
        page.openAbPage();
        String heading = page.getTitleABTesting();
        System.out.println("Titlul paginii: " + heading);
        Assert.assertTrue(
                heading.equals("A/B Test Control")
                        || heading.equals("A/B Test Variation 1"),
                "Titlul paginii nu este cel asteptat!"
        );
    }
}