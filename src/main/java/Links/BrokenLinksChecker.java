package Links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksChecker {

    public WebDriver driver;
    @Test
    public void main1() throws IOException {
        driver = new ChromeDriver();
        driver.get("http://www.deadlinkcity.com/");  // Replace with the website you want to check
        //https://www.lambdatest.com/selenium-playground/


        // Get all links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String url = link.getAttribute("href");  // Get the href value of each link
            if (url != null && !url.isEmpty()) {
                checkBrokenLink(url);
            }
        }

        driver.quit();
    }

    @Test
    public void checkBrokenLink(String linkUrl) throws IOException {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD"); // Send a HEAD request for fast response
            connection.connect();
            int responseCode = connection.getResponseCode();

            if (responseCode >= 400) {
                System.out.println(linkUrl + " is BROKEN (Response Code: " + responseCode + ")");
            } else {
                System.out.println(linkUrl + " is WORKING (Response Code: " + responseCode + ")");
            }

            connection.disconnect();
        } catch (Exception e) {
            System.out.println(linkUrl + " is INVALID or BROKEN");
        }
    }


}


/*
How to Check if a Link is Working or Broken in Selenium
To determine whether a link is working or broken, you can follow these steps:

Extract the link URL using Selenium.
Send an HTTP request to the URL.
Check the HTTP response code:
200 → Link is working
404 or other 4xx/5xx → Link is broken

 */