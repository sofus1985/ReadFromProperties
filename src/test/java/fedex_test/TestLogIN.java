package fedex_test;

import fedex.BaseFedex.BaseFedex;
import fedex.pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestLogIN extends BaseFedex {




    @Test
    public void TestLogin() throws InterruptedException {

        HomePage homePage = new HomePage();
        homePage.fedexLogo.isDisplayed();
        homePage.clickOnLoginDropDown();

        homePage.selectLoginDropDown3();

        homePage.logIN();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds

        wait.until(ExpectedConditions.visibilityOf(homePage.logoAccount)); // Wait until element is visible

        boolean isVisible = homePage.logoAccount.isDisplayed();
        System.out.println("Logo Account is displayed: " + isVisible);


    }
}
