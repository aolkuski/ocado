package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class TrolleyPage extends OcadoPage {

    private static String orderedProductsLocator = "//div[@id='smartTrolley']//li[contains(@id,'item')]/div[contains(@class,'pictureViewMain')]/a/img[@alt='%s']";

    public static void assertProductsAdded(String productName, int quantity) {
        Assert.assertEquals(driver.findElements(By.xpath(String.format(orderedProductsLocator, productName))).size(), quantity);
    }
}
