package mouse_action_drag_and_drop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class MouseActions {


        //ClickAndHold
        //ClickAndRelease
        //RightClick - ContextClick
        //BackClick
        //ForwardClick
        //DoubleClick
        //MoveToElement
        //MoveByOffset
        //DragAndDrop

        public WebDriver driver;

        @Test
        public void mouseOperations() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://easemytrip.com");

            //Step 1: Create the object of Actions class and pass the driver reference in its constructor
            Actions actions = new Actions(driver);

            //Step 2: I am moving my mouse and hovering over the loginOrSignUpButton
            WebElement loginOrSignupButton = driver.findElement(By.cssSelector("a._btnclick>span"));
            actions.moveToElement(loginOrSignupButton).build().perform(); //the action you are taking has to be chained with methods build() and perform()

            //Step 3: I am clicking on the Customer Login
            WebElement loginOptionCustomer = driver.findElement(By.cssSelector("span#shwlogn > span:nth-child(1)"));
            actions.moveToElement(loginOptionCustomer).click().build().perform();

        }

        @Test
        public void dragMouseOperation() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://jqueryui.com/draggable/");

            Actions actions = new Actions(driver);
            List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
            System.out.println("Total frames in this website is : " + totalFrames.size());

            driver.switchTo().frame(0);
            WebElement dragElement = driver.findElement(By.id("draggable"));
            actions.dragAndDropBy(dragElement, 300, 100).build().perform();

        }

        @Test
        public void dragandDropOperation() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://jqueryui.com/droppable/");

            Actions actions = new Actions(driver);
            List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
            System.out.println("Total frames in this website is : " + totalFrames.size());

            driver.switchTo().frame(0);
            WebElement dragElement = driver.findElement(By.id("draggable"));
            WebElement toBeDroppedAtElement = driver.findElement(By.id("droppable"));
            actions.dragAndDrop(dragElement, toBeDroppedAtElement).build().perform();
        }

    }

