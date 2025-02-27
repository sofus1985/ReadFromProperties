package fedex_test;

import fedex.BaseFedex.BaseFedex;
import fedex.pages.Shipping;
import org.testng.annotations.Test;

public class TestShipment extends BaseFedex {


    @Test
    public void createShipment(){
        Shipping shipping = new Shipping();
        shipping.clickShippingDropDown();
        shipping.clickCreateShipment();
        shipping.logIN();


    }
}
