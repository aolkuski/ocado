package core;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;


public abstract class UiTestBaseClass {

    protected static WebDriver driver;

    @BeforeClass
    public static final void setUp() {
        driver = WebDriverFactory.getWebDriverInstance();
    }

    @AfterClass
    public static final void tearDown() {
        WebDriverFactory.stopWebDriver();
    }


}
