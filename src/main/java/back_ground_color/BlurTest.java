package back_ground_color;

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

public class BlurTest {
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
    public void testBlur() {
        driver.get("https://example.cypress.io/commands/actions");

        // Find the input element and type into it
        WebElement blurInput = driver.findElement(By.cssSelector(".action-blur"));
        blurInput.sendKeys("About to blur");

       // Trigger blur event using JavaScript
       ((JavascriptExecutor) driver).executeScript("arguments[0].blur();", blurInput);

       // Wait for the class 'error' to be present
        Assert.assertTrue(wait.until(ExpectedConditions.attributeContains(blurInput, "class", "error")));

        // Verify the class 'error' is present on the input element
        Assert.assertTrue(blurInput.getAttribute("class").contains("error"), "Class 'error' is not present");

        // Verify the previous element's style attribute contains 'color: red;'
        WebElement previousElement = blurInput.findElement(By.xpath("preceding-sibling::*[1]"));
        String style = previousElement.getAttribute("style");
        Assert.assertTrue(style.contains("color: red;"), "Style does not contain 'color: red;'");
    }


}

