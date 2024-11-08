package webdriver_wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DriverWait {

    public WebDriver driver;
    public WebDriverWait webDriverWait;


    @Test
    public void test(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.linkText("My Account")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.findElement(By.linkText("Register")).click();

       WebElement firstName = driver.findElement(By.cssSelector("input#input-firstname"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(firstName)).click();
        WebElement lastName = driver.findElement(By.cssSelector("input#input-lastname"));
        webDriverWait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys("panda");
        driver.findElement(By.cssSelector("input#input-email")).sendKeys("ela122@gmail.com");

    }
}
