package fedex.pages;

import fedex.BaseFedex.BaseFedex;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Shipping  extends BaseFedex {
    WebDriverWait wait;

    @FindBy(xpath = "//a[@class='fxg-link fxg-dropdown-js fxg-keyboard']/span[contains(text(),'Shipping')]")
    public WebElement shippingDropDown;
    @FindBy(xpath = "//a[contains(@href,'https://www.fedex.com/en-us/shipping/ship-manager/login.html')][normalize-space()='Create a Shipment']")
    public WebElement createShipment;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userID;

    @FindBy(xpath = "//input[@id='password']")
    public  WebElement password;

    @FindBy(xpath = "//button[@id='login_button']")
    public WebElement loginButton;


    public Shipping(){

        PageFactory.initElements(driver,this);
    }


    public void clickShippingDropDown(){

        //shippingDropDown.click();
        clickOnElement(shippingDropDown);
    }
    public void clickCreateShipment(){

        clickOnElement(createShipment);
    }


    public void inputFieldUserId( String userId){
        userID.sendKeys(userId);
    }
    public void inputFieldPassword(String Password){
        password.sendKeys(Password);
    }

    public void loginButton(){
        loginButton.click();
    }

    public void logIN(){

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(userID));
        inputFieldUserId("stiveatom15@gmail.com");
        inputFieldPassword("Fedextesting1985?");
        loginButton();
    }

}
