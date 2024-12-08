package slider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Slider2 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void testRangeInput() throws InterruptedException {
        driver.get("https://example.cypress.io/commands/actions");

        // Find the range input element and scroll into view
        WebElement rangeInput = driver.findElement(By.cssSelector("input[type='range']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rangeInput);

        // Set its value to 25 using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", rangeInput, 30);

        // Trigger the change event using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'))", rangeInput);

        // Find the sibling paragraph element
        WebElement siblingParagraph = rangeInput.findElement(By.xpath("following-sibling::p"));

        // Wait for the paragraph to contain the text '30'
        wait.until(ExpectedConditions.textToBePresentInElement(siblingParagraph, "30"));

        // Assert the text of the paragraph
        Assert.assertEquals(siblingParagraph.getText(), "30", "The text in the paragraph should be '30'");
        Thread.sleep(8000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


