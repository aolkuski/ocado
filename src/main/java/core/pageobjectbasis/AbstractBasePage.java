package core.pageobjectbasis;

import config.beans.WebDriverConfigurationBean;
import core.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AbstractBasePage {

    protected static WebDriverConfigurationBean driverConfig;
    protected static WebDriver driver;

    public AbstractBasePage() {
        driver = WebDriverFactory.getWebDriverInstance();
        driverConfig = (WebDriverConfigurationBean) new ClassPathXmlApplicationContext(new String[]{"Beans.xml"}).getBean("driverConfig");
        driver.manage().timeouts().implicitlyWait(driverConfig.getImplicitWait(), TimeUnit.SECONDS);
    }

}
