package calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CalenderSecond {
    public WebDriver driver;

    @Test
    public void pickTheDate() throws InterruptedException {
        customizeDate("30", "February", "2028");
    }

    public void customizeDate(String selectDay, String selectMonth, String selectYear) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        driver.findElement(By.id("datepicker")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));

        if(Integer.parseInt(selectDay)>31) {
            System.out.println("Invalid date");
            return;
        }

        if(selectMonth.equals("February") && Integer.parseInt(selectDay) > 29) {
            System.out.println("Invalid February Month");
        }

        String monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
        String month = monthYear.split(" ")[0];
        String year = monthYear.split(" ")[1];


        while (!(month.equals(selectMonth) && year.equals(selectYear))) {
            driver.findElement(By.xpath("//a[@title = 'Next']")).click();
            monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
            month = monthYear.split(" ")[0];
            year = monthYear.split(" ")[1];
        }
        Thread.sleep(1000);
        String xpathDayText = "//td[@data-handler = 'selectDay']/a[text() = \' " + selectDay + "\']";

        try {
            driver.findElement(By.xpath(xpathDayText));
        } catch (Exception e) {
            System.out.println("Invalid date selection");
            e.printStackTrace();
        }

    }
}
