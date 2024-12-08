package slider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Slider {

public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

       driver= new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.get("https://example.cypress.io/commands/actions");
        WebElement element = driver.findElement(By.xpath("//input[@class='trigger-input-range']"));
        Actions actions= new Actions(driver);
        actions.dragAndDropBy(element,-30, 0).perform();
        Thread.sleep(5000);
       driver.quit();
    }



}
