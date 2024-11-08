package scroll_up_down_page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scroll {
    public WebDriver driver;
    @Test
    public void scroll() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.bmwusa.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1800)");//scroll down
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,-700)");// scroll up


    }
}
