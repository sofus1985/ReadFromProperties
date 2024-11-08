package data_provider;


import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProvider {
    public WebDriver driver;
    public WebDriverWait webDriverWait;
    public ChromeOptions chromeOptions;


    @Test(priority = 1, dataProvider = "loginDataProvider")
    public void loginTest(String email, String password){
      webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.cssSelector("input.btn-primary")).click();
        driver.findElement(By.xpath("//aside[@id='column-right']//a[text()='Logout']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='content']/h1"))));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/h1")).isDisplayed());

    }

    @org.testng.annotations.DataProvider
    public Object[][]  loginDataProvider(){
        Object [][] loginData = {{"seleniumpanda@gmail.com", "Selenium@123"},
                {"seleniumpanda1@gmail.com", "Selenium@123"},
                {"seleniumpanda2@gmail.com", "Selenium@123"},
                {"seleniumpanda3@gmail.com", "Selenium@123"},
                {"seleniumpanda4@gmail.com", "Selenium@123"},
                {"seleniumpanda5@gmail.com", "Selenium@123"},
                {"seleniumpanda6@gmail.com", "Selenium@123"},

        };
        return loginData;
    }

    @Test(priority = 2, enabled = true)
    public void test1(){
        System.out.println("this is the first test");
    }
    @Test(priority = 3)
    public void test2(){
        System.out.println("this is the second test");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
