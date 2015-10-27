package components;

import core.pageobjectbasis.AbstractComponent;
import core.pageobjectbasis.WebElem;
import pages.OffersPage;
import utils.DynamicWaitUtil;

public class NavigationBarComponent extends AbstractComponent {
    static WebElem browseShopContainerLink = new WebElem("//li[@id='browseShopContainer']/a");
    static WebElem favouritesLink = new WebElem("//li[@id='favourites']/a");
    static WebElem offersLink = new WebElem("//li[@id='offers']/a");
    static WebElem newLink = new WebElem("//li[@id='new']/a");
    static WebElem smartPassLink = new WebElem("//li[@id='savingpass']/a");
    static WebElem wineLink = new WebElem("//li[@id='wine']/a");
    static WebElem seasonalLink = new WebElem("//li[@id='event']/a");

    public static OffersPage goToOffersPage() {
        offersLink.click();
        DynamicWaitUtil.waitForTitleToContain("Offers", 30, false);
        return new OffersPage();
    }
}
