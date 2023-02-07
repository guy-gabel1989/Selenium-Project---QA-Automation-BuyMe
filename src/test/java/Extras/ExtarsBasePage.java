package Extras;

import BaseFunctions.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExtarsBasePage {
    public void clickElement(By locator) throws Exception {
        getWebElement(locator).click();
    }
    public static String getText(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator).getText();
    }

    private WebElement getWebElement(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}
