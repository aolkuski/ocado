package core.pageobjectbasis;

import config.beans.WebDriverConfigurationBean;
import core.LocatorType;
import core.WebDriverFactory;

import javax.xml.xpath.*;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

public class WebElem implements WebElement {

    protected WebDriverConfigurationBean driverConfig;

    protected WebDriver driver = WebDriverFactory.getWebDriverInstance();

    protected boolean isXpathValid() {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        try {
            xpath.compile(this.locator);
            return true;
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return false;
    }

    public WebElem(String xpath) {
        this(LocatorType.XPATH, xpath);
    }

    public WebElem(LocatorType locType, String locator) {
        this(locType, locator, false);
    }

    WebElem(LocatorType locType, String locator, boolean lazyInit) {
        this.locType = locType;
        this.locator = locator;
        this.byLoc = locType.getBy(locator);
        if (locType.equals(LocatorType.XPATH) && !lazyInit) {
            isXpathValid();
        }
    }

    protected LocatorType locType;
    protected final String locator;
    protected By byLoc;

    @Override
    public void click() {
        try {
            this.waitUntilDisplayed(5, false).getWebElement().click();
        } catch (StaleElementReferenceException sere) {
            getWebElement().click();
        }
    }

    protected WebElement getWebElement() {
        return driver.findElement(byLoc);
    }

    @Override
    public void submit() {
        getWebElement().submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        getWebElement().sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        getWebElement().clear();
    }

    @Override
    public String getTagName() {
        return getWebElement().getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return getWebElement().getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return getWebElement().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return getWebElement().isEnabled();
    }

    @Override
    public String getText() {
        return getWebElement().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return getWebElement().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return getWebElement().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return getWebElement().isDisplayed();
    }

    @Override
    public Point getLocation() {
        return getWebElement().getLocation();
    }

    @Override
    public Dimension getSize() {
        return getWebElement().getSize();
    }

    @Override
    public String getCssValue(String propertyName) {
        return getWebElement().getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return getWebElement().getScreenshotAs(outputType);
    }

    public WebElem waitUntilPresent(long timeoutInSeconds, boolean throwingException) {
        if (throwingException && !elementPresence(true, timeoutInSeconds * 1000)) {
            throw new NoSuchElementException(String.format("Element with locator %s and locator type %s not found within %d seconds", this.locator, this.locType.name(), timeoutInSeconds));
        }
        return this;
    }

    public WebElem waitUntilNotPresent(long timeoutInSeconds) {
        elementPresence(false, timeoutInSeconds * 1000);
        return this;
    }

    protected void elementDisplay(boolean shouldBeDisplayed, long timeoutInSeconds, boolean throwingException) {
        Long startTime = Calendar.getInstance().getTimeInMillis();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

        while ((Calendar.getInstance().getTimeInMillis() - startTime) < (timeoutInSeconds * 1000)) {
            try {
                if (shouldBeDisplayed && this.isDisplayed()) {
                    return;
                }
                if (!shouldBeDisplayed && !this.isDisplayed()) {
                    return;
                }
            } catch (StaleElementReferenceException sere) {
                continue;
            } catch (NoSuchElementException nsee) {
                if (!shouldBeDisplayed) {
                    return;
                }
            } catch (ElementNotVisibleException enve) {
                if (!shouldBeDisplayed) {
                    return;
                }
            } finally {
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            }
        }
        if (throwingException) {
            String msg = shouldBeDisplayed ? "Element with locator type '%s' and locator '%s' not displayed!" : "Element with locator type '%s' and locator '%s' still displayed, although should be not visible.";
            throw new IllegalStateException(String.format(msg, this.locType.name(), this.locator));
        }
    }

    public WebElem waitUntilDisplayed(long timeoutInSeconds, boolean throwingException) {
        elementDisplay(true, timeoutInSeconds, throwingException);
        return this;
    }

    public WebElem waitUntilNotDisplayed(long timeoutInSeconds, boolean throwingException) {
        elementDisplay(false, timeoutInSeconds, throwingException);
        return this;
    }

    protected boolean elementPresence(boolean shouldBePresent, Long timeoutInMilis) {
        Long startTime = Calendar.getInstance().getTimeInMillis();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        while ((Calendar.getInstance().getTimeInMillis() - startTime) < (timeoutInMilis)) {
            try {
                this.getWebElement();
                if (shouldBePresent) {
                    return true;
                }
            } catch (StaleElementReferenceException sere) {
                continue;
            } catch (NoSuchElementException nsee) {
                if (!shouldBePresent) {
                    return true;
                }
                continue;
            } finally {
                driver.manage().timeouts().implicitlyWait(driverConfig.getImplicitWait(), TimeUnit.SECONDS);
            }
        }
        return false;
    }

    public boolean isPresent(long timeoutInMilis) {
        return elementPresence(true, timeoutInMilis);
    }

    public boolean isNotPresent(long timeoutInMilis) {
        return elementPresence(false, timeoutInMilis);
    }

    public LocatorType getLocType() {
        return locType;
    }

    public String getLocator() {
        return locator;
    }
}
