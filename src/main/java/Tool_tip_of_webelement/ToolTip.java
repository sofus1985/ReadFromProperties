package Tool_tip_of_webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ToolTip {
  public WebDriver driver;

  @Test
    public void main() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://m.rediff.com/");
       WebElement moneyLink =  driver.findElement(By.linkText("Shopping"));
       String toolTip = moneyLink.getAttribute("title");
      System.out.println("the tool tip of WebElement Money is : " + toolTip);
      driver.close();
    }

}
