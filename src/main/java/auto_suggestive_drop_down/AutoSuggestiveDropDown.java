package auto_suggestive_drop_down;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.security.Key;


public class AutoSuggestiveDropDown {
    public WebDriver driver;

    @Test
    public void makeMyTrip() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");

        driver.findElement(By.id("fromCity")).click();

        driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']")).sendKeys("New");

        int i=0;
        while(i<4) {
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys(Keys.DOWN);
            i++;
        }
        driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys(Keys.ENTER);

    }
}
