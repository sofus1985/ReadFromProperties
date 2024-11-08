package auto_suggestive_drop_down;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;



public class LoopingDropDown {
    public WebDriver driver;



  @Test
    public void loopTest() throws InterruptedException {
      driver = new ChromeDriver();
      driver.manage().deleteAllCookies();
      driver.manage().window().maximize();
      driver.get("https://easemytrip.com");
      driver.findElement(By.id("spnTraveller")).click();
      Thread.sleep(5000);

      int adult = 1;
      while (adult <5){
         driver.findElement(By.xpath("//button[@class='add plus_box1' and @id='add']")).click();
          adult ++;

      }



  }

}
