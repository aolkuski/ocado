package core;

import org.openqa.selenium.By;

public enum LocatorType {
    CSS, XPATH, LINK_TEXT, CLASS_NAME, ID, NAME, TAG_NAME;

    public By getBy(String locator) {
        switch (this) {
            case CSS:
                return By.cssSelector(locator);
            case CLASS_NAME:
                return By.className(locator);
            case ID:
                return By.id(locator);
            case LINK_TEXT:
                return By.linkText(locator);
            case NAME:
                return By.name(locator);
            case TAG_NAME:
                return By.tagName(locator);
            default:
                return By.xpath(locator);
        }
    }
}
