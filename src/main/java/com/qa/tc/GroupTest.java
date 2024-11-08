package com.qa.tc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class GroupTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp()
    {


        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    @Test
    public void TestSignIn(){


        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.cssSelector("input#input-firstname")).sendKeys("Selenium");
        driver.findElement(By.cssSelector("input#input-lastname")).sendKeys("panda");
        driver.findElement(By.cssSelector("input#input-email")).sendKeys("ella123@gmail.com");

    }
    @Test
    public void testFirst(){
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();
        System.out.println("this is the first test");
    }
    @Test
    public void testSecond(){
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();
        System.out.println("this is the second test");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
