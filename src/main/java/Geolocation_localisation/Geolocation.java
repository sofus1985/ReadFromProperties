package Geolocation_localisation;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class Geolocation {


    @Test

    public void geolocation(){
       ChromeDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();

      DevTools devTools = driver.getDevTools();
      devTools.createSession();

        HashMap<String, Object> coordinates = new HashMap<>();
        coordinates.put("latitude", 40);
        coordinates.put("longitude", 3);
        coordinates.put("accuracy", 1);

      driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

      driver.get("http://google.com");

      // click in google search
      driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);


      // wit to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".LC20lb.MBeuO.DKV0Md")));
      // click in netflix
        driver.findElements(By.cssSelector(".LC20lb.MBeuO.DKV0Md")).get(0).click();



      // get the text in netflix
      String title = driver.findElement(By.xpath("//h1[@class=' default-ltr-cache-jmnaey euy28770']")).getText();
        System.out.println(title);


        driver.quit();

    }


}
//https://chromedevtools.github.io/devtools-protocol/tot/Emulation/

/*
The DevTools class comes from the Selenium DevTools package, which is part of the Selenium 4.x suite. This package allows integration with the Chrome DevTools Protocol (CDP), enabling advanced interactions with the Chrome browser.

Specifically, the main classes related to DevTools in Selenium are found in the org.openqa.selenium.devtools package.

Here's a brief overview of some key classes:

DevTools - Represents the DevTools object you use to create sessions and send commands.

HasDevTools - An interface that allows a WebDriver instance to access DevTools.

DevToolsSession - Represents a devtools session, which is used to send commands and receive events.
 */

/*
Emulation.setGeolocationOverride explain where come from
The Emulation.setGeolocationOverride method comes from the Chrome DevTools Protocol (CDP), which allows you to interact with the browser at a lower level compared to standard WebDriver commands. This method specifically belongs to the emulation domain of CDP, enabling you to override the geolocation of the browser.

In Selenium 4, you access these DevTools commands via the DevTools and Emulation classes provided by Selenium’s DevTools package. Here's a breakdown:

Chrome DevTools Protocol (CDP)
The Chrome DevTools Protocol is a set of tools to understand and tweak Chrome’s behavior. It includes the following domains:

Emulation: Override device features like geolocation, sensors, and user-agent.

Network: Inspect and manipulate network interactions.

Performance: Measure and optimize performance.
 */