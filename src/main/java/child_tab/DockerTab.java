package child_tab;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class DockerTab {

    public WebDriver driver;


    @Test
    public void testDockerTab() throws InterruptedException {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.get("https://www.docker.com/");

       String s= Keys.chord(Keys.CONTROL, Keys.ENTER);
       driver.findElement(By.xpath("//ul[@class='main-menu']//a[@class='button secondary'][normalize-space()='Sign In']")).sendKeys(s);

       Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow= iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);

        System.out.println(driver.findElement(By.xpath("//header[@class='ccb0daa49 c5059bdd0']")).getText());

     String actualText = driver.findElement(By.xpath("//header[@class='ccb0daa49 c5059bdd0']")).getText();
     String expectedTEXT= "Sign in\n" +
             "Using Docker for work? We recommend signing in with your work email address.";

        Assert.assertEquals(actualText,expectedTEXT);

        driver.switchTo().window(parentWindow);
        Thread.sleep(5000);
        driver.quit();

    }

}
