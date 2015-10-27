package components;

import core.pageobjectbasis.AbstractComponent;
import core.pageobjectbasis.WebElem;

public class LoginComponent extends AbstractComponent {

    static WebElem loginComponentDiv = new WebElem("//*[@id='loginRegPopup']//div[@id='loginSubview']");
    static WebElem mailInput = new WebElem("//input[@id='username']");
    static WebElem passwordInput = new WebElem("//input[@id='password']");
    static WebElem loginButton = new WebElem("//button[@id='js-popupLoginButton']");

    public void login(String userMail, String password) {
        mailInput.sendKeys(userMail);
        passwordInput.sendKeys(password);
        loginButton.click();
        loginComponentDiv.waitUntilNotDisplayed(5, true);
    }
}
