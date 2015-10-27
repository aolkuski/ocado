package components;

import utils.RandomStringGenerator;
import core.pageobjectbasis.AbstractComponent;
import core.pageobjectbasis.WebElem;

public class RegisterComponent extends AbstractComponent {

    protected static WebElem registerComponentDiv = new WebElem("//div[@id='loginRegPopup']//div[@class='popupSubview']/div[@id='quickRegistrationSubview']");
    protected static WebElem firstNameInput = new WebElem("//input[@id='qr-forename']");
    protected static WebElem lastNameInput = new WebElem("//input[@id='qr-surname']");
    protected static WebElem mailInput = new WebElem("//input[@id='qr-email']");
    protected static WebElem passowrdInput = new WebElem("//input[@id='qr-password']");
    protected static WebElem postcodeInput = new WebElem("//input[@id='qr-postcode']");
    protected static WebElem registerButton = new WebElem("//button[@id='acceptForm']");

    public void registerSpecificUser(String firstName, String lastName, String userMail, String password, String postCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        mailInput.sendKeys(userMail);
        passowrdInput.sendKeys(password);
        postcodeInput.sendKeys(postCode);
        registerButton.click();
        registerComponentDiv.waitUntilNotDisplayed(5, true);
    }

    public String registerAnyUser(String password) {
        String userMail = RandomStringGenerator.getRandomString(7) + "@gmail.com";
        registerSpecificUser("Annnnnna", "Naaaaaaana", userMail, password, "CA7 9NX");
        return userMail;
    }

    public static WebElem getRegisterComponentDiv() {
        return registerComponentDiv;
    }
}
