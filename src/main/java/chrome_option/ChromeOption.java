package chrome_option;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ChromeOption {
    //you can make you coding execution faster, slower,keep the same speed
    // you can directly maximize the window
    // you can use other argument
    public WebDriver driver;
    public ChromeOptions options;


    @Test(invocationCount = 1)
    public void test() {
        options = new ChromeOptions();
        //you can make you coding execution faster, slower,keep the same speed
            // options.setPageLoadStrategy(PageLoadStrategy.EAGER);
           //  options.setPageLoadStrategy(PageLoadStrategy.NONE);
               options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
               options.addArguments("--start-maximized"); // open window and maximized directly
               options.addArguments("--incognito"); // open a page with incognito mode
               options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars")); // disable the info bar that says chrome is controlled by automated software
             //  options.addArguments("--headless");// do the test without opening the window

        driver = new ChromeDriver(options);
       // driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/");
        driver.quit();
    }
}