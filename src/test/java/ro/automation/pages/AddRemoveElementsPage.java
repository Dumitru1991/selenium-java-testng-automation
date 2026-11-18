package ro.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ro.automation.base.BasePage;

public class AddRemoveElementsPage extends BasePage {

    private final By addElementButton = By.xpath("//button[text()='Add Element']");
    private final By deleteButtons = By.cssSelector("#elements button.added-manually");

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPage("add_remove_elements/");
    }

    public void addElements(int count) {
        for (int i = 0; i < count; i++) {
            click(addElementButton);
        }
    }

    public void deleteElements(int count) {
        for (int i = 0; i < count; i++) {
            click(deleteButtons);
        }
    }

    public int getDeleteButtonsCount() {
        // findElements (not findAll) so it returns 0 right away when there are no buttons
        return driver.findElements(deleteButtons).size();
    }
}
