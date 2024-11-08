package alert_popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertPopUP {
    public WebDriver driver;


    @Test
    public void alertPopUP(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.findElement(By.name("proceed")).click();
        Alert alert= driver.switchTo().alert();
        System.out.println("the alert is : " + alert.getText()); // print the text in the alert
        alert.accept();// if there is ok button
       // alert.dismiss();// if there is a close button
        driver.quit();
    }
}
