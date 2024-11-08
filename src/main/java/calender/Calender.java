package calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Calender {
    public WebDriver driver;

    @Test
    public void datePickerTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        // driver.findElement(By.id("datepicker")).sendKeys("12/25/2025");

        //The date we select is Dec 25, 2024
        driver.findElement(By.id("datepicker")).click();

        //Slow down a bit and make sure that this Calendar WebElement is actually popping out
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));

        String monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
        //System.out.println(monthYear);

        //Which mon and Year we are targetting - December 2024

        //December 2024

        String month = monthYear.split(" ")[0];
        String year = monthYear.split(" ")[1];

        while(!(month.equals("November") && year.equals("2028"))) {
            driver.findElement(By.xpath("//a[@title = 'Next']")).click();
            monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
            month = monthYear.split(" ")[0];
            year = monthYear.split(" ")[1];
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[@data-handler = 'selectDay']/a[text() = '25']")).click();


    }
}
