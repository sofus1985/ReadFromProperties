package web_table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TesT {

    public WebDriver driver;
    @Test
    public void test(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupall");
//        List<WebElement> headerName = driver.findElements(By.xpath("//table[@class='dataTable']//tr//th"));
//        for (int i = 0 ; i < headerName.size(); i++){
//            System.out.println("the text headerName is : " + headerName.get(i).getText());
//        }


        List<WebElement> headerName2 = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr[4]//td[4]"));
        List<WebElement> headerName1 = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr[4]//td//a"));
        for (int i = 0 ; i < headerName2.size(); i++){
            System.out.println(headerName1.get(i).getText() + "--------" + headerName2.get(i).getText());
        }

}
}
