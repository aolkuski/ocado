package pages;

import components.LoggedInUserBarComponent;
import core.pageobjectbasis.AbstractBasePage;
import core.pageobjectbasis.WebElem;

public class OcadoPage extends AbstractBasePage {

    protected static LoggedInUserBarComponent loggedInUserBarComponent = new LoggedInUserBarComponent();

    protected static WebElem logo = new WebElem("//div[@id='brandLogo']/a/img");
    protected static WebElem searchInput = new WebElem("//input[@id='findText']");
    protected static WebElem searchButton = new WebElem("//input[@id='findButton']");
}
