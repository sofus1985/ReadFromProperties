package alert_popup;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AlertAuth {
    WebDriver driver;
    ChromeOptions chromeOptions;

  @Test
  public void testAuth() {
      driver= new ChromeDriver();
      driver.manage().window().maximize();
      driver.get(" https://admin:admin@the-internet.herokuapp.com/basic_auth");// passed the password and username in the url

  }

  @Test
  public void testPopUp(){

      chromeOptions = new ChromeOptions();
      chromeOptions.addArguments("--disable-notifications");

      driver= new ChromeDriver(chromeOptions);
      driver.manage().window().maximize();
      driver.get("https://www.redbus.in/");
  }

  @Test
  public void testACME(){



      driver= new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://the-internet.herokuapp.com/disappearing_elements");
      driver.findElement(By.xpath("//div[@class='example']/ul/li[5]/a")).click();

  }




    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}

