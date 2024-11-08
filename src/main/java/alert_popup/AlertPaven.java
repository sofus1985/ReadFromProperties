package alert_popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class AlertPaven {

public WebDriver driver;
@BeforeMethod
public void setUp(){
    driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
}

@Test

    public void testAccept(){

    driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
    Alert alert = driver.switchTo().alert();
    alert.accept();
     String actualText = "You successfully clicked an alert";
    Assert.assertEquals(actualText, driver.findElement(By.cssSelector("#result")).getText());
    }
    @Test
    public void  testAcceptOrCancel(){
    driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
    Alert alert = driver.switchTo().alert();
    alert.accept();
    //alert.dismiss();
        String actualText = "You clicked: Ok";
        String expectedText = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(actualText, expectedText );
    }

    @Test
    public void testWithBoxFilling(){
    driver.findElement(By.xpath("//button[@onclick ='jsPrompt()']")).click();
    Alert alert = driver.switchTo().alert();
        System.out.println("the alert text is : " +alert.getText());

        // write welcome in the input box and accept or dismiss
    alert.sendKeys("welcome");
    alert.accept();
        String actualText = "You entered: welcome";
        String expectedText = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(actualText, expectedText );
    }





@AfterMethod
  public void tearDown(){

    driver.quit();
  }
}
