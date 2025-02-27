package child_tab;


import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TabChild extends Base {

    //https://www.docker.com

  @FindBy(xpath = "//ul[@class='main-menu']//a[@class='button secondary'][normalize-space()='Sign In']")
  public WebElement clickButtON;

    public TabChild(){
        PageFactory.initElements(driver,this);

    }
    @Test
    public void  childTab(){
   clickOnElement(clickButtON);
   String parentWindow = driver.getWindowHandle();
        System.out.println(parentWindow);


   Set<String> windows =driver.getWindowHandles();

        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()){
          String childWindows =   iterator.next();

            System.out.println(childWindows);

            if(!childWindows.equalsIgnoreCase(parentWindow)) {
                driver.switchTo().window(childWindows);
            }
        }

      //  for (String childWindows : windows) {
      //      System.out.println(childWindows);
      //  }



    }
}
