package back_ground_color;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BackGroundColor {

    public static WebDriver driver;
  public static WebDriverWait driverWait;
  @Test
    public static void main() throws InterruptedException {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://example.cypress.io/commands/actions");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@id='fullName1']")).click();
        String rgbBackGroundColor =  driver.findElement(By.xpath("//input[@id='fullName1']")).getCssValue("background-color");

        System.out.println("this is teh color format rgb is :  " + rgbBackGroundColor);

     Color color = Color.fromString(rgbBackGroundColor);
     String hexColor = color.asHex();
      System.out.println();
      System.out.println("this is teh color format hex is :  " + hexColor);

    }
    public void tearDown(){
      driver.close();
      driver.quit();
    }

}
