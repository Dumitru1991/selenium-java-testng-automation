package ro.automation.pages;

import java.util.function.Supplier;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ro.automation.base.BasePage;

/**
 * Page object for /iframes_advanced. The page has three frames that need more than a plain switch:
 * <ul>
 *   <li>a sandboxed frame (own origin, talks to the page with postMessage)</li>
 *   <li>a srcdoc frame (no URL, its HTML is inline)</li>
 *   <li>a frame inside the shadow root of the {@code frame-host} element</li>
 * </ul>
 * Every method that enters a frame switches back to the main page before it returns,
 * so the steps never have to track which frame the driver is in.
 */
public class IframesAdvancedPage extends BasePage {

    // Main page
    private final By sandboxedFrame = By.id("sandboxed-frame");
    private final By srcdocFrame = By.id("srcdoc-frame");
    private final By frameHost = By.id("frame-host");
    private final By shadowFrame = By.cssSelector("#shadow-frame");
    private final By parentAccess = By.id("parent-access");
    private final By messageLog = By.id("message-log");

    // Inside the sandboxed and shadow frames (both load the same frame page)
    private final By frameTitle = By.id("frame-title");
    private final By sendMessageButton = By.id("send-message");

    // Inside the srcdoc frame
    private final By srcdocText = By.id("srcdoc-text");
    private final By srcdocInput = By.id("srcdoc-input");

    public IframesAdvancedPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPage("iframes_advanced");
    }

    /** Text the page shows after it tried to read the sandboxed frame's document. */
    public String getParentAccessText() {
        // The text is replaced when the frame finishes loading, so wait for the final value
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBe(parentAccess, "Checking access to the sandboxed frame...")));
        return text(parentAccess);
    }

    public String getMessageLog() {
        return text(messageLog);
    }

    /** Waits until the message log shows the expected text, then returns what it shows. */
    public String waitForMessageLog(String expected) {
        try {
            wait.until(ExpectedConditions.textToBe(messageLog, expected));
        } catch (TimeoutException ignored) {
            // the step's assertion reports the actual text
        }
        return getMessageLog();
    }

    // ---------- sandboxed / shadow frames ----------

    /** @param frameName "sandboxed" or "shadow" */
    public String getFrameTitle(String frameName) {
        return inFrame(frameName, () -> text(frameTitle));
    }

    /** @param frameName "sandboxed" or "shadow" */
    public void clickSendMessage(String frameName) {
        inFrame(frameName, () -> {
            click(sendMessageButton);
            return null;
        });
    }

    /** @param frameName "sandboxed" or "shadow" */
    public String getSendMessageButtonText(String frameName) {
        return inFrame(frameName, () -> text(sendMessageButton));
    }

    // ---------- srcdoc frame ----------

    public String getSrcdocText() {
        return inFrame("srcdoc", () -> text(srcdocText));
    }

    public void typeInSrcdocInput(String value) {
        inFrame("srcdoc", () -> {
            write(srcdocInput, value);
            return null;
        });
    }

    public String getSrcdocInputValue() {
        return inFrame("srcdoc", () -> find(srcdocInput).getDomProperty("value"));
    }

    // ---------- frame switching ----------

    private <T> T inFrame(String frameName, Supplier<T> action) {
        switchToFrame(frameName);
        try {
            return action.get();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    private void switchToFrame(String frameName) {
        switch (frameName) {
            case "sandboxed" -> wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(sandboxedFrame));
            case "srcdoc" -> wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(srcdocFrame));
            case "shadow" -> {
                // The iframe is not in the main DOM: go through the host's shadow root to find it
                SearchContext shadowRoot = find(frameHost).getShadowRoot();
                WebElement frame = wait.until(d -> shadowRoot.findElement(shadowFrame));
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
            }
            default -> throw new IllegalArgumentException(
                    "Unknown frame '" + frameName + "'. Use sandboxed, srcdoc or shadow.");
        }
    }
}
