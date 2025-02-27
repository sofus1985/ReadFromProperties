package child_tab;

import Base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestTabChild extends Base {


    @Test
    public void  testTabChild(){
     TabChild tabChild = new TabChild();
      tabChild.childTab();


     try {


         Thread.sleep(5000);
     }catch (Exception e){
         System.out.println(e);
     }
     String expectedUrl = "https://the-internet.herokuapp.com/windows/new";

        System.out.println("the url is : " + driver.getCurrentUrl());

        Assert.assertTrue(validationURL(driver,expectedUrl));

    }
}
