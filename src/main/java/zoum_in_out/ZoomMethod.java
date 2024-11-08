package zoum_in_out;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZoomMethod {
    public  WebDriver driver;

    @Test
    public  void main() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://m.rediff.com/");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("document.body.style.zoom = '100%' ; ");
        Thread.sleep(2000);
        javascriptExecutor.executeScript("document.body.style.zoom = '50%' ; ");
        Thread.sleep(2000);
        javascriptExecutor.executeScript("document.body.style.zoom = '300%' ; ");
        driver.quit();


    }
}
