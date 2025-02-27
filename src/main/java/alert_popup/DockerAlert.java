package alert_popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DockerAlert {

    public WebDriver driver;
    public WebDriverWait webDriverWait;
    @Test
    public void testDockerAlert(){
    ////div[@id='onetrust-button-group']/button[2]
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.docker.com/");
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//div[@id='onetrust-button-group']/button[2]")).click();

        //webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='onetrust-button-group']/button[2]")));

    }
}
