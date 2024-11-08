package properties_test_properties_reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public Properties prop;
    public FileInputStream fis;
    public WebDriver driver;

    public PropertiesReader() throws IOException {
        prop = new Properties();
        fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
        prop.load(fis);
    }

     @Test
    public void test(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("URL"));
         driver.findElement(By.xpath("//input[@placeholder= 'Email or phone number']")).sendKeys(prop.getProperty("USERNAME"));
         driver.findElement(By.xpath("//input[@id= 'pass']")).sendKeys(prop.getProperty("PASSWORD"));
         driver.quit();
    }




}
