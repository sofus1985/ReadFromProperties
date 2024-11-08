package data_provider;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class DataProviderTimeStamp {


    public WebDriver driver;
    public WebDriverWait webDriverWait;
    public ChromeOptions chromeOptions;


    @Test(dataProvider = "loginDataProvider")
    public void loginTest(String firstName, String lastName, String email, String telephone, String password, String confirmPassword){
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.xpath("//li[@class='dropdown open']//a[text()='Register']")).click();
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(telephone);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(confirmPassword);
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/h1")).isDisplayed());

    }

    public String understandDateTimeSTAMP() {


        Date date = new Date();
        System.out.println(date);
        String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
        System.out.println(timeStamp);
        return "seleniumPanda" + timeStamp + "@gamil.com";

    }

    @org.testng.annotations.DataProvider
    public Object[][]  loginDataProvider(){
        Object [][] loginData = {
                {"stephany", "johnson", understandDateTimeSTAMP(), "2953447867", "pooqJgC@4dZhS5vx", "pooqJgC@4dZhS5vx"},
                {"sarah", "peter", understandDateTimeSTAMP(), "2671427867", "pttqJJgC@4dZhS5vx", "pttqJJgC@4dZhS5vx"},
                {"lola", "hugh", understandDateTimeSTAMP(), "2673447367", "pffqJJgC@4dZhS5vx", "pffqJJgC@4dZhS5vx"},
                {"kerry", "johny", understandDateTimeSTAMP(), "2673442867", "pwwqJJgC@4dZhS5vx", "pwwqJJgC@4dZhS5vx"},
                {"jerry", "johan", understandDateTimeSTAMP(), "2673441867", "pssqJJgC@4dZhS5vx", "pssqJJgC@4dZhS5vx"},



        };
        return loginData;
    }
    @Test
    public void test(){
        Date date = new Date();
        System.out.println(date);
    }
     @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
