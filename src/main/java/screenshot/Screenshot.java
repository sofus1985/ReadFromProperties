package screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public WebDriver driver;
    @Test
    public void screenshot() throws IOException {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.shaadi.com/");
       WebElement logo = driver.findElement(By.xpath("//div[@class='css-1k729dm']"));
       File source = logo.getScreenshotAs(OutputType.FILE);
       File destination = new File(System.getProperty("user.dir") + "\\test-output\\screenshot\\screenshotLog.png");
        FileHandler.copy(source,destination  );
      driver.quit();

    }
}
