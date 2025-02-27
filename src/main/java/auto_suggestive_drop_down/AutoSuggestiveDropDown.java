package auto_suggestive_drop_down;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


 public class AutoSuggestiveDropDown extends Base {
     public WebDriver driver;
     public WebDriverWait webDriverWait;

     @Test
     public void makeMyTrip() throws InterruptedException {
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://www.makemytrip.com/");
         webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
         webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='fromCity']")));

         driver.findElement(By.xpath("//input[@id='fromCity']")).click();
         webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-controls='react-autowhatever-1']")));

         driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']")).sendKeys("New");

         int i = 0;
         while (i < 4) {
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys(Keys.DOWN);
             i++;
         }
         driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys(Keys.ENTER);
     }
 }




/*
Explanation:
int i = 0;

This line initializes an integer variable i and sets its value to 0. This variable will be used as a counter in the
while loop.

while (i < 4) {

This line starts a while loop that will continue to execute as long as the value of i is less than 4.

Thread.sleep(1000);

This line makes the current thread sleep (pause execution) for 1000 milliseconds (1 second). It is used to introduce a
delay before executing the next line of code.

driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys(Keys.DOWN);

This line finds the web element with the placeholder "From" and sends a "DOWN" arrow key press to it. This action
simulates the user pressing the "DOWN" arrow key to navigate through the options in the auto-suggestive dropdown.

i++;

This line increments the value of the variable i by 1. This is necessary to eventually terminate the while loop.

}

This line marks the end of the while loop.

driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys(Keys.ENTER);

After the while loop has completed (i.e., after 4 iterations), this line finds the web element with
the placeholder "From" and sends an "ENTER" key press to it. This action simulates the user pressing
the "ENTER" key to select the highlighted option from the auto-suggestive dropdown.
 */