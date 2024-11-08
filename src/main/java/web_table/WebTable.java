package web_table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {
    //it is a dynamic table which represents data in the form of rows and cols
    //Criteria to work with WebTables - Very good xpath or cssSelector knowledge

    //url - https://money.rediff.com/gainers/bse/daily/groupall
    //html - table
    //class = dataTable

    //table - parent
    //thead - represents the top row
    //tr - this represents the row of the head
    //th - represents the 5 cols present in the row. So here tr acts as the parent of all these th

    //tbody - represents the full body
    //tr - this represents each row present in the body
    //td - this represents each col present in the row. So tr acts as a parent to all these td

    //table[@class = 'dataTable'] - this represents the whole of WebTable which also includes the top header row as well as the body
    //table[@class = 'dataTable']/thead - this represents the whole header row and it excludes the body
    //table[@class = 'dataTable']/tbody - this represents the whole body but it excludes the header row
    //table[@class = 'dataTable']/thead/tr - this represents the complete row of the header
    //table[@class = 'dataTable']/thead/tr/th - this represents all the cols present in the header row
    //table[@class = 'dataTable']/thead/tr/th[4] - this represents the 4th col of the header row

    //table[@class = 'dataTable']/tbody - this represents the complete body
    //table[@class = 'dataTable']/tbody/tr - this represents total no of rows in the body as of today
    //table[@class = 'dataTable']/tbody/tr[1] - this represents the 1st row of the body
    //table[@class = 'dataTable']/tbody/tr[1]/td - this represents all the cols of the 1st row of the body
    //table[@class = 'dataTable']/tbody/tr[27]/td[5] - this represents the 5th col present in the 27th row of the body

    //table[@class = 'dataTable']/tbody/tr/td[1] - this represents all the cols present in the 1st col of the body
    //table[@class = 'dataTable']/tbody/tr/td[4] - this represents all the cols present in the 4th col of the body





    public WebDriver driver;

    @Test
    public void printAllColumnNamesOfHeaderRow() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupall");

        List<WebElement> namesOfColsOfHeaderRow = driver.findElements(By.xpath("//table[@class = 'dataTable']/thead/tr/th"));

        for(int i=0 ; i<namesOfColsOfHeaderRow.size() ; i++) {
            System.out.println(namesOfColsOfHeaderRow.get(i).getText());
        }
    }

    @Test
    public void printAnIndividualColInHeaderRow() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupall");

        //This is simple way
        WebElement specificColName = driver.findElement(By.xpath("//table[@class = 'dataTable']/thead/tr/th[4]"));
        System.out.println(specificColName.getText());

        System.out.println("************************************************************************************************");

        //You can use this way also
        List<WebElement> namesOfColsOfHeaderRow = driver.findElements(By.xpath("//table[@class = 'dataTable']/thead/tr/th[4]"));
        for(int i=0 ; i<namesOfColsOfHeaderRow.size() ; i++) {
            System.out.println(namesOfColsOfHeaderRow.get(i).getText());
        }
    }


    @Test
    public void printAllRowsOfBody() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupall");

        List<WebElement> namesOfRowsInBody = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr"));

        for(int i=0 ; i<namesOfRowsInBody.size() ; i++) {
            System.out.println(namesOfRowsInBody.get(i).getText());
        }
    }


    @Test
    public void printAllColsOfFirstRowOfBody() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupall");


        List<WebElement> namesOfColsOfFirstRowOfBody = driver.findElements(By.xpath("//table[@class = 'dataTable']/tbody/tr[1]/td"));
        for(int i=0 ; i<namesOfColsOfFirstRowOfBody.size() ; i++) {
            System.out.println(namesOfColsOfFirstRowOfBody.get(i).getText());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
