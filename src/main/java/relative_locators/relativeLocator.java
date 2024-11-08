package relative_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class relativeLocator {
    public WebDriver driver;

    @FindBy(xpath = "//input[@id='login1']")
    public WebElement userNameBelow;
    @FindBy(xpath = "//p[text()='Password']")
    public WebElement passwordBoxToTheRight;


    @Test
    public void test(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("login1")).toRightOf(By.xpath("//p[text()='Password']"))).sendKeys("1234ali");
       // driver.findElement(RelativeLocator.with(By.tagName("input")).below(userNameBelow).toRightOf(passwordBoxToTheRight)).sendKeys("1234ali");

    }
}
