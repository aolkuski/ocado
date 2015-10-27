package core;

import core.configurators.Configurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class WebDriverFactory {

    private static WebDriver driver;
    private static Configurator configurator;

    private WebDriverFactory() {
    }

    public static WebDriver getWebDriverInstance() {
        if (driver == null) {
            startWebDriver();
        }
        return driver;
    }

    public static void startWebDriver() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"Beans.xml"});
        configurator = (Configurator) context.getBean("configurator");
        driver = configurator.configure();
        driver.get("about:blank");
        driver.manage().window().maximize();
    }

    public static void stopWebDriver() {
        if (driver != null && driver.getWindowHandle() != null && !driver.getWindowHandle().equals("")) {
            try{
                driver.quit();
            } catch (SessionNotFoundException ignored){} finally {
                driver = null;
            };
        }
    }

    public static void restartWebDriver() {
        stopWebDriver();
        startWebDriver();
    }

    public Configurator getConfigurator() {
        return configurator;
    }

    public void setConfigurator(Configurator driverConfigurator) {
        configurator = driverConfigurator;
    }
}
