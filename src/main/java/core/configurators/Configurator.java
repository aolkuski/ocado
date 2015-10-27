package core.configurators;

import config.beans.WebDriverConfigurationBean;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Configurator {

    @Autowired
    WebDriverConfigurationBean driverConfig;

    public abstract WebDriver configure();
}
