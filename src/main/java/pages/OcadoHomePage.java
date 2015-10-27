package pages;

import components.LoginComponent;
import components.NavigationBarComponent;
import components.RegisterComponent;
import core.pageobjectbasis.WebElem;

public class OcadoHomePage extends OcadoPage {

    protected static WebElem loginButton = new WebElem("//a[@id='loginButton']");
    protected static WebElem registerButton = new WebElem("//a[@id='quickReg']");

    protected static RegisterComponent registerComponent = new RegisterComponent();
    protected static NavigationBarComponent navigationBar = new NavigationBarComponent();
    protected static LoginComponent loginComponent = new LoginComponent();

    public OcadoHomePage getHomePage() {
        driver.get("http://ocado.com");
        return this;
    }

    public OcadoHomePage registerAnyCustomer() {
        registerButton.click();
        registerComponent.getRegisterComponentDiv().waitUntilDisplayed(30, true);
        registerComponent.registerAnyUser("Abc12345T");
        return this;
    }

    // enums or modificable WebElem would be better, but not in this scope
    public OffersPage navigateToOffers() {
        return navigationBar.goToOffersPage();
    }
}
