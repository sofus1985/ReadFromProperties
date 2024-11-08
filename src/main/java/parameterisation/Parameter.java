package parameterisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {

    public WebDriver driver;
    public WebDriverWait webDriverWait;
    @Parameters({"url", "browser" })
    @Test
    public void testToParameters(@Optional("https://tutorialsninja.com/demo/") String url, @Optional ("firefox") String browser){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.cssSelector("input#input-firstname")).sendKeys("Selenium");
        driver.findElement(By.cssSelector("input#input-lastname")).sendKeys("panda");
        driver.findElement(By.cssSelector("input#input-email")).sendKeys("ella123@gmail.com");

    }
    @Parameters({"url", "browser" })
    @Test
    public void testFail(@Optional("https://tutorialsninja.com/demo/") String url, @Optional ("firefox") String browser){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.linkText("M Account")).click();
        driver.findElement(By.linkText("egister")).click();
        driver.findElement(By.cssSelector("nput#input-firstname")).sendKeys("Selenium");
        driver.findElement(By.cssSelector("nput#input-lastname")).sendKeys("panda");
        driver.findElement(By.cssSelector("nput#input-email")).sendKeys("ella123@gmail.com");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

