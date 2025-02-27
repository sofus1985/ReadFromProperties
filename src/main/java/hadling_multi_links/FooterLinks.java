package hadling_multi_links;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class FooterLinks {
    // click on each link in the footerlink and get their respective title or currenturl

    public WebDriver driver;

    @Test
    public void multipleWebElements() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rediff.com");
        // collect all the footer links in a list
        List<WebElement> footerLinks = driver.findElements(By.xpath("//div[@class = 'footer alignC wrapper']/a"));
        System.out.println("Total of footer links are : " + footerLinks.size());

        for(int i=0 ; i<footerLinks.size() ; i++) {
            System.out.println(footerLinks.get(i).getText() + "-----" + footerLinks.get(i).getAttribute("href"));
            //Investors - click on this footerlink and get me the title of this page

            //if you want to click on each link
            footerLinks.get(i).click();
            System.out.println("The title of the link : " + driver.getTitle());

            //driver.get("https://rediff.com");
            driver.navigate().back();
            Thread.sleep(2000);
           // StaleElementReferenceException
            footerLinks = driver.findElements(By.xpath("//div[@class = 'footer alignC']/a")); //call the list again
            //the above statement will respect the for loop while activating the dormant or stale elements
            Thread.sleep(1000);
        }



    }
    public void tearDown(){
        driver.quit();
    }

}
