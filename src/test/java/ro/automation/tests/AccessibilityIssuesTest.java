package ro.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ro.automation.base.BaseTest;
import ro.automation.pages.AccessibilityIssuesPage;

public class AccessibilityIssuesTest extends BaseTest {

    @Test
    public void testAccessibilityIssues() {
        openPage("");
        AccessibilityIssuesPage page = new AccessibilityIssuesPage(driver);

        page.clickAccessibilityIssues();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/accessibility_issues"),
                "Nu am ajuns pe pagina corecta!"
        );
    }

    @Test
    public void verifyPageHeading() {
        openPage("accessibility_issues");
        AccessibilityIssuesPage page = new AccessibilityIssuesPage(driver);

        String headingText = page.getTitleAccessibilityIssues();
        System.out.println("Titlul paginii este: " + headingText);

        Assert.assertEquals(
                headingText,
                "Accessibility Issues",
                "Titlul paginii nu este cel asteptat!"
        );
    }

    @Test
    public void verifyImageAltRule() {
        openPage("accessibility_issues");
        AccessibilityIssuesPage page = new AccessibilityIssuesPage(driver);

        Assert.assertTrue(
                page.isRowVisible(),
                "Randul image-alt nu este vizibil!"
        );
    }

    @Test
    public void verifyAllTableRows() {
        openPage("accessibility_issues");
        AccessibilityIssuesPage page = new AccessibilityIssuesPage(driver);

        int numarRanduri = page.getRowsCountAccessibilityIssues();
        System.out.println("Numar de randuri: " + numarRanduri);

        Assert.assertTrue(
                numarRanduri > 0,
                "Nu am gasit niciun rand cu atributul data-rule!"
        );
    }
}