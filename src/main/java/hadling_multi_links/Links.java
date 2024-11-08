package hadling_multi_links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Links {

    //total number of links in the website

    public WebDriver driver;

    @Test
    public void multipleWebElements() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bbc.com");

        //Total number of links at this instant. Each link is what ? A WebElement.  They are objects.

        List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links present at this instant is : " + totalLinks.size());

        //144 links are present

        //Find out the 101st link ??
        //101st link will be stored inside the 100th index position

        WebElement link101 = totalLinks.get(100);
        System.out.println("The 101st link at this instant is : " + link101 );
        System.out.println("The text of the 101st link at this instant is : " + link101.getText());

        //I want to determine the url present in the 101st link
        System.out.println("The url present in link101 is " + link101.getAttribute("href"));

        //determine the x and y coordinate for link101
        System.out.println(link101.getLocation().x + "-----------" + link101.getLocation().y);

        //you want to click on that link101
        //link101.click();

        //total 144 links are there. I want to print their respective names and also check if they are displayed or not

        for(int i=0 ; i<totalLinks.size() ; i++) {
            System.out.println(totalLinks.get(i).getText() + "---------------" + totalLinks.get(i).getAttribute("href")+ "--------" + totalLinks.get(i).isDisplayed());
            System.out.println("teh thread is : " +Thread.currentThread().getId());// tells the number of the thread
        }


    }
    public void tearDown(){
        driver.quit();
    }
}
