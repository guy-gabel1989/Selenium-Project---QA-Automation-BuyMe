package BaseFunctions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;

public class BasePage {
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


    public static String getResult(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator).getAttribute("value");
    }

    public static String getTitle () throws Exception {
        return DriverSingleton.getDriverInstance().getCurrentUrl();
    }

    private WebElement getWebElement(By locator) throws Exception {
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
