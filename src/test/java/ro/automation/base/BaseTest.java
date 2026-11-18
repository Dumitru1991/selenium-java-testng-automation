package ro.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    protected static final String BASE_URL = "https://the-internet.herokuapp.com/";

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void openPage(String path) {
        driver.get(BASE_URL + path);
    }
}
