package BaseFunctions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;

public class BasePage {
    /**
     * This class is an extension for all the tested pages
     * it contains all the most used selenium actions
     * all the actions receive the driver from the getWebElement, that element gets the driver from the
     * @see DriverSingleton class
     * @param locator
     * @throws Exception
     */
    public void clickElement(By locator) throws Exception {
        getWebElement(locator).click();
    }

    public void findElement(By locator) throws Exception {
        getWebElement(locator);
    }
    public void goToURL() throws Exception {
        DriverSingleton.getDriverInstance();
    }

    public void sendKeysToElement(By locator, String text) throws Exception {
        getWebElement(locator).sendKeys(text);
    }
    public void clearText(By locator) throws Exception {
        getWebElement(locator).clear();
    }

    public static String getValue(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator).getAttribute("value");
    }
    public static String getText(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator).getText();
    }

    public static String getTitle () throws Exception {
        return DriverSingleton.getDriverInstance().getCurrentUrl();
    }

    private WebElement getWebElement(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}
