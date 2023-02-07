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

    //This method is used to click any element in the project
    public void clickElement(By locator) throws Exception {
        getWebElement(locator).click();
    }

    //This method is used to send keys to element in the project
    public void sendKeysToElement(By locator, String text) throws Exception {
        getWebElement(locator).sendKeys(text);
    }
   //This method is used to clear text in a textbox
    public void clearText(By locator) throws Exception {
        getWebElement(locator).clear();
    }

    //this methoed is used to get the text that is inside a text box, used mainly in assertion tests
    public static String getValue(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator).getAttribute("value");
    }
   //this method is used to get an elements text
    public static String getText(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator).getText();
    }

    //this method get the pages URL
    public static String getTitle () throws Exception {
        return DriverSingleton.getDriverInstance().getCurrentUrl();
    }

   //this method creates the web-element using the DriverSingleton class, all the other methods in this class use it to call the "driver." commend
    private WebElement getWebElement(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}
