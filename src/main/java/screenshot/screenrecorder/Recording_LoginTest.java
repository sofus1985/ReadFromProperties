package screenshot.screenrecorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Recording_LoginTest {
    public WebDriver driver;

    public Recording_LoginTest() {
    }

    @Test
    public void recordingLoginTest() throws Exception {
        ScreenRecorderUtil.startRecord("recordingLoginTest");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://tutorialsninja.com/demo");
        this.driver.findElement(By.linkText("My Account")).click();
        this.driver.findElement(By.linkText("Login")).click();
        this.driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
        this.driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
        this.driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        ScreenRecorderUtil.stopRecord();
        driver.quit();
    }
}
