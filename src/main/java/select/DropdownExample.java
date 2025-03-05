package select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownExample {

    public WebDriver driver;

    @Test
    public  void main() {
         driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // Locate the dropdown element
        WebElement dropdown = driver.findElement(By.name("my-select"));

        // Create Select object
        Select select = new Select(dropdown);

        // Get all options
        List<WebElement> options = select.getOptions();

        // Print all options
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}

