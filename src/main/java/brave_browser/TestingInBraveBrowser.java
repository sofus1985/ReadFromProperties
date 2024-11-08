package brave_browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestingInBraveBrowser {


        public WebDriver driver;
        public ChromeOptions options;
        public Properties prop;
        public FileInputStream ip;


        //Step1: Download and instal brave browser in your PC
        //Step2: You need the path where the brave.exe file is

        // C:\Program Files\BraveSoftware\Brave-Browser\Application\brave.exe

        //Step3: We have to use ChromeOptions

        @Test
        public void usingBraveBrowser() {
            options= new ChromeOptions();
            options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.get("https://tutorialsninja.com/demo");
            driver.findElement(By.linkText("My Account")).click();
            driver.findElement(By.linkText("Login")).click();

        }

        public TestingInBraveBrowser() throws IOException {
            prop = new Properties();
            ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\com\\automation\\Day19_18th_May_2024_Brave_Browser\\browserConfig.properties");
            prop.load(ip);
        }

        @Test
        public void multipleBrowserTechnique(String browserName) throws Exception {
            options = new ChromeOptions();
            if(browserName.equals(prop.getProperty("browser1"))) {
                driver = new ChromeDriver(options);
            }else if(browserName.equals(prop.getProperty("browser2"))) {
                options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
            }


        }



    }

