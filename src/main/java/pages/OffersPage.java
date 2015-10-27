package pages;

import components.LoggedInUserBarComponent;
import core.pageobjectbasis.WebElem;
import utils.DynamicWaitUtil;

public class OffersPage extends OcadoPage {

    private static String firstElementXpath = "(//ul[@id='prodList']/li[contains(@id,'productDetails-')])[1]";
    protected static WebElem firstPromoProductElement = new WebElem(firstElementXpath);
    protected static WebElem firstPromoProductTitleElement = new WebElem(firstElementXpath + "//div[@class='shelfTop']/*[@class='productTitle']");
    protected static WebElem firstPromoProductQuantityInput = new WebElem(firstElementXpath + "//div[@class='shelfBottom']//form/label[@class='productQuantity']/input[@class='quantity']");
    protected static WebElem firstPromoProductAddToCartButton = new WebElem(firstElementXpath + "//div[@class='shelfBottom']//form//span[@class='addBtn']");
    protected static WebElem firstPromoProductElementImage = new WebElem(firstElementXpath + "/div[@class='shelfTop']//a/img");

    public static String addFirstProductsToTrolley(int quantity) {
        firstPromoProductElement.waitUntilDisplayed(15, true);
        firstPromoProductQuantityInput.waitUntilDisplayed(20, true);
        firstPromoProductQuantityInput.clear();
        String productAltImageText = firstPromoProductElementImage.getAttribute("alt");
        firstPromoProductQuantityInput.sendKeys(Integer.toString(quantity));
        firstPromoProductAddToCartButton.click();
        return productAltImageText;
    }

    public static TrolleyPage goToTrolley() {
        LoggedInUserBarComponent.goToTrolley();
        DynamicWaitUtil.waitForTitleToContain("trolley", 20, true);
        return new TrolleyPage();
    }
}
