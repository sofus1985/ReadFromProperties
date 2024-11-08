package properties_test_properties_reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesWithConstructor {
    public WebDriver driver;
    public Properties prop;
     public String URL;
    public String USERNAME;
    public String PASSWORD;
    public FileInputStream fis;


    public TestPropertiesWithConstructor() throws IOException {
     prop = new Properties();
     fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
     prop.load(fis);

        this.URL = prop.getProperty("URL");
        this.USERNAME= prop.getProperty("USERNAME");
        this.PASSWORD = prop.getProperty("PASSWORD");

    }

    @Test
    public void testSecond(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.findElement(By.xpath("//input[@placeholder= 'Email or phone number']")).sendKeys(USERNAME);
        driver.findElement(By.xpath("//input[@id= 'pass']")).sendKeys(PASSWORD);
        driver.quit();
    }
}
