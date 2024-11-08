package web_table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ClassAssignment {

    public WebDriver driver;

    // 1. Print the current price of Kush Industries
    @Test
    public void assignment1() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupall");

        String companyName = "Kush Industries";
        List<WebElement> companyNames = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr/td[1]"));
        List<WebElement> currentPrices = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr/td[4]"));

        for (int i = 0; i < companyNames.size(); i++) {
            if (companyName.equals(companyNames.get(i).getText())) {
                System.out.println(companyNames.get(i).getText() + "-----------" + currentPrices.get(i).getText());
                break;
            }
        }
    }

    // 2. Determine the current price of the company present in the 999th row
    @Test
    public void assignment2() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupall");
        WebElement nineNintyNinthEntity = driver.findElement(By.xpath("//table[@class = 'dataTable']/tbody/tr[999]/td[4]"));
        System.out.println(nineNintyNinthEntity.getText());
    }

    // 3. Print 5 rows of the WebTable with all the cols associated
    //    i. top 5 rows of the WebTable
    //    ii. bottom 5 rows of the WebTable
    //    iii. 5 rows anywhere in the middle

    @Test
    public void assignment3() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupall");

        // i. top 5 rows of the WebTable
        List<WebElement> firstTop5Rows = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr[position() > 0 and position() <= 5]"));
        for (int i = 0; i<firstTop5Rows.size(); i++) {
            System.out.println(firstTop5Rows.get(i).getText());
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------");

        // ii. bottom 5 rows of the WebTable
        List<WebElement> bottom5Rows = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr[position() > 1572 and position() <= 1577]"));
        for (int i = 0; i<bottom5Rows.size(); i++) {
            System.out.println(bottom5Rows.get(i).getText());
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------");

        // iii. 5 rows anywhere in the middle
        List<WebElement> middle5Rows = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr[position() > 995 and position() <= 1000]"));
        for (int i = 0; i<middle5Rows.size(); i++) {
            System.out.println(middle5Rows.get(i).getText());
        }
    }

    // 4. Choose any 5 companies of your choice - Get their respective Current Price(rs) only
    // company name - Current price
    // company name - Current price
    // company name - Current price
    // company name - Current price
    // company name - Current price
    @Test
    public void assignment4() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupall");
        String[] companiesOfMyChoice = { "Coral Labs.", "Finolex Cables", "Inox Wind Ltd.", "Arihant Capital", "SVC Industries"};

        List<WebElement> companyNames = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr/td[1]"));
        List<WebElement> currentPrices = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr/td[4]"));

        for(int i=0 ; i<companyNames.size() ; i++) {
            for(String companyName : companiesOfMyChoice ) {
                if(companyName.equals(companyNames.get(i).getText())) {
                    System.out.println(companyNames.get(i).getText() + "--------" + currentPrices.get(i).getText()) ;
                    break;
                }
            }
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
