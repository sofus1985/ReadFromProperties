package up_load_file;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileUpLoad {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");



        Thread.sleep(2000);
        driver.findElement(By.id("uploadfile")).sendKeys("C:\\Users\\sofiane\\Desktop\\Egzodia Release.PDF");
    }
}
