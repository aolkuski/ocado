package utils;

import core.WebDriverFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicWaitUtil {

    public static void waitForTitleToEqual(String title, int timeoutInSeconds, boolean throwingException) {
        waitForTitle(title, timeoutInSeconds, throwingException, true);
    }

    public static void waitForTitleToContain(String titlePart, int timeoutInSeconds, boolean throwingException) {
        waitForTitle(titlePart, timeoutInSeconds, throwingException, false);
    }

    private static void waitForTitle(String title, int timeoutInSeconds, boolean throwingException, boolean titleEquals) {
        if (titleEquals) {
            new WebDriverWait(WebDriverFactory.getWebDriverInstance(), timeoutInSeconds).until(ExpectedConditions.titleIs(title));
        } else {
            new WebDriverWait(WebDriverFactory.getWebDriverInstance(), timeoutInSeconds).until(ExpectedConditions.titleContains(title));
        }
    }
}
