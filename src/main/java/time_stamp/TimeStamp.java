package time_stamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class TimeStamp {
  public WebDriver driver;
    public String understandDateTimeSTAMP() {


        Date date = new Date();
        System.out.println(date);
        String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
        System.out.println(timeStamp);
        return "seleniumPanda" + timeStamp + "@gamil.com";

    }

    @Test(invocationCount = 3)
    public void test() {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("https://tutorialsninja.com/demo/");
    driver.findElement(By.linkText("My Account")).click();
    driver.findElement(By.linkText("Register")).click();
    driver.findElement(By.cssSelector("input#input-firstname")).sendKeys("Selenium");
    driver.findElement(By.cssSelector("input#input-lastname")).sendKeys("panda");
    driver.findElement(By.cssSelector("input#input-email")).sendKeys(understandDateTimeSTAMP());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
