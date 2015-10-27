package core.configurators;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class FirefoxConfigurator extends Configurator {

    @Override
    public WebDriver configure() {
        FirefoxProfile profile = new FirefoxProfile();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File firebug = new File(classLoader.getResource("firebug-2.0.12b1.xpi").getFile());
            File firepath = new File(classLoader.getResource("firepath-0.9.7.1-fx.xpi").getFile());
            profile.addExtension(firebug);
            profile.addExtension(firepath);
            profile.setPreference("extensions.firebug.currentVersion", "2.0.12");
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            profile = new FirefoxProfile();
        }
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("browser.download.manager.showWhenStarting", driverConfig.getShowDownloadManagerOnStart());
        profile.setPreference("browser.download.folderList", driverConfig.getDownloadFolderList());
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", driverConfig.getNeverAskSaveToDisk());

        System.setProperty("webdriver.firefox.bin", driverConfig.getBinaryLocation());

        return new EventFiringWebDriver(new FirefoxDriver(profile));
    }
}
