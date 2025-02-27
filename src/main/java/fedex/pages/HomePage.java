package fedex.pages;

import fedex.BaseFedex.BaseFedex;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BaseFedex {

    WebDriverWait wait;
    // Constructor to initialize elements
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //  //div[@id='global-login-wrapper']//a[contains(text(), 'SIGN UP / LOG IN')]
    @FindBy(xpath = "//img[@ src='https://www.fedex.com/content/dam/fedex-com/logos/logo.png' ]")
    public WebElement fedexLogo;
    @FindBy(xpath = "//div[@id='global-login-wrapper']")
    public WebElement loginDropDown;

    @FindBy(xpath = "//div[@id='global-login-wrapper']/div/div/div/div")
    public List <WebElement> listOfDropDownLogIn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userID;

    @FindBy(xpath = "//input[@id='password']")
    public  WebElement password;

    @FindBy(xpath = "//button[@id='login_button']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='stive ']")
    public  WebElement logoAccount;



   public void clickOnLoginDropDown(){

       loginDropDown.click();

   }

    public void selectLoginDropDown() {
        for (WebElement element : listOfDropDownLogIn) {
            if (element.getText().trim().equalsIgnoreCase("SIGN UP / LOG IN")) {
                element.click();  // Click on the matching element
                break;  // Stop the loop after clicking
            }
        }
    }



    public void selectLoginDropDown1() {
        System.out.println("Dropdown Options:");
        for (WebElement element : listOfDropDownLogIn) {
            System.out.println("- " + element.getText().trim()); // Debugging

            if (element.getText().trim().equalsIgnoreCase("SIGN UP / LOG IN")) {
                element.click();
                System.out.println("Clicked on SIGN UP / LOG IN");
                break;
            }
        }
    }





    public void selectLoginDropDown2() {
        for (WebElement element : listOfDropDownLogIn) {
            if (element.getText().trim().equalsIgnoreCase("SIGN UP / LOG IN")) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element); // Force click
                System.out.println("Clicked using JavaScript");
                break;
            }
        }
    }




    public void selectLoginDropDown3() {
     wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        for (WebElement element : listOfDropDownLogIn) {
            if (element.getText().trim().equalsIgnoreCase("SIGN UP / LOG IN")) {
                System.out.println("Waiting for element to be clickable: " + element.getText());
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                System.out.println("Clicked after waiting!");
                break;
            }
        }
    }




    public void selectLoginDropDown4() {
        Actions actions = new Actions(driver);

        for (WebElement element : listOfDropDownLogIn) {
            if (element.getText().trim().equalsIgnoreCase("SIGN UP / LOG IN")) {
                System.out.println("Scrolling to element: " + element.getText());
                actions.moveToElement(element).build().perform();  // Scroll
                element.click();
                System.out.println("Clicked after scrolling!");
                break;
            }
        }
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
       wait.until(ExpectedConditions.elementToBeClickable(userID));
        inputFieldUserId("stiveatom15@gmail.com");
        inputFieldPassword("Fedextesting1985?");
        loginButton();
    }

}
