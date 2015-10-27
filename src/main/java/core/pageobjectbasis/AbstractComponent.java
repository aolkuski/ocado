package core.pageobjectbasis;

import core.WebDriverFactory;

import org.openqa.selenium.WebDriver;

public abstract class AbstractComponent {
    WebDriver driver = WebDriverFactory.getWebDriverInstance();

}
