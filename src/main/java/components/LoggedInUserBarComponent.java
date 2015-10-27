package components;

import core.pageobjectbasis.AbstractComponent;
import core.pageobjectbasis.WebElem;
import pages.TrolleyPage;
import utils.DynamicWaitUtil;

public class LoggedInUserBarComponent extends AbstractComponent {
    static WebElem bookADeliveryButton = new WebElem("//div[@id='orderOptions']/div[@class='deliveryContainer']/a");
    static WebElem viewTrolleyButton = new WebElem("//div[@id='orderOptions']/a[@class='viewTrolley button']");
    static WebElem checkoutButton = new WebElem("//div[@id='orderOptions']//div[@id='basketCheckoutLinkEnabled']/a[@class='button continue']");


    public static TrolleyPage goToTrolley() {
        viewTrolleyButton.click();
        DynamicWaitUtil.waitForTitleToContain("trolley", 30, false);
        return new TrolleyPage();
    }
}
