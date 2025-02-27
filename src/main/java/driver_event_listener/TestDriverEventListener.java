package driver_event_listener;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class TestDriverEventListener {

    public WebDriver driver;
    @Test
    public void test() throws InterruptedException {
    driver = new ChromeDriver(); // Create normal WebDriver instance
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Wrap it with the EventFiringDecorator to attach the listener
        WebDriver decoratedDriver = new EventFiringDecorator<>(new DriverEventListener()).decorate(driver);

        // Example actions
        decoratedDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("[type='submit']")).click();


        decoratedDriver.quit();
    }
}

/*
The DriverEventListener class is a custom implementation of the WebDriverListener interface in Selenium.

Where Did It Come From?
Introduced in Selenium 4: Selenium 4 introduced the WebDriverListener interface to provide event-driven logging and debugging capabilities.
Custom Event Listener: This class extends WebDriverListener, allowing you to hook into various Selenium WebDriver events, such as navigation, element interactions, and browser actions.
What Does It Do?
It logs actions before and after key WebDriver events, such as:
Navigating to a page (beforeGet, afterGet)
Finding elements (beforeFindElement, afterFindElement)
Clicking elements (beforeClick, afterClick)
Handling alerts, cookies, timeouts, and window management
 */

