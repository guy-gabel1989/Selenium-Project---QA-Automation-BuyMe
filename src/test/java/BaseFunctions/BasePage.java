package BaseFunctions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class BasePage {
    public void clickElement(By locator)  {
        getWebElement(locator).click();
    }

    public void findElement(By locator) {
        getWebElement(locator);
    }
    public void goToURL()  {
        DriverSingleton.getDriverInstance();
    }

    public void sendKeysToElement(By locator, String text)  {
        getWebElement(locator).sendKeys(text);
    }


    public static String getResult(By locator)  {
        return DriverSingleton.getDriverInstance().findElement(locator).getAttribute("value");
    }

    private WebElement getWebElement(By locator)  {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
    public static String takeScreenShot(WebDriver driver, String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }
}
