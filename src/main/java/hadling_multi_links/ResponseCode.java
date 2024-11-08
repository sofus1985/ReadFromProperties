package hadling_multi_links;

import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ResponseCode {

    public WebDriver driver;

    @Test
    public void multipleWebElements() throws IOException, Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rediff.com");
        // collect all the footer links in a list
        List<WebElement> footerLinks = driver.findElements(By.xpath("//div[@class = 'footer alignC']/a"));
        System.out.println("Total no of footer links are : " + footerLinks.size());

        for(int i=0 ; i<footerLinks.size() ; i++) {

            String url = footerLinks.get(i).getAttribute("href");

            //Investors - click on this footerlink and get me the title of this page


            //if the url is returning response code == 200 then only allow click operation


            boolean result = validateResponseCode(url );
            Assert.assertTrue(result, "invalid response code");

            //if you want to click on each link
            footerLinks.get(i).click();
            System.out.println("The title of the link : " + driver.getTitle());
            System.out.println("The response statement of this link is : " + result);

            driver.get("https://rediff.com");
            //driver.navigate().back();
            Thread.sleep(2000);
            //StaleElementReferenceException
            footerLinks = driver.findElements(By.xpath("//div[@class = 'footer alignC']/a")); //call the list again
            //the above statement will respect the for loop while activating the dormant or stale elements
            Thread.sleep(1000);
        }

    }



    public boolean validateResponseCode(String url) throws Exception, IOException {
        //https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
        //200 is the response code which is OK status

        int response_code = 0;
        response_code = Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
        if(response_code == 200) {
            return true;
        }

        return false;
    }
    public void tearDown(){
        driver.quit();
    }
}
