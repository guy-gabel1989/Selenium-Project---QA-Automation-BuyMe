package Extras;

import BaseFunctions.DriverSingleton;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static BaseFunctions.DriverSingleton.getData;

public class HomeScreen extends ExtarsBasePage {
    /**
     * Test Class for the extra assignments, runs on the same stucture as POM_BuyMe
     * the test report in under the name "ExtraReport.html
     *
     *
     */
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("Extras Test Report", "Extent report for the Extra assignments");
    private static ChromeDriver driver;
    String timeNow = String.valueOf(System.currentTimeMillis());

    @BeforeClass
    /**
     * The before class does the following:
     * 1.initiate the test report
     * 2.send a status to the report
     * 3.initiate the driver using the DriverSingleton class
     * 4.gets the url from the Data.xml file
     * 5. set up a wait commend to make the dreivr wait for the page to load
     *
     *
     */
    public void extrasRunBeforeclass() throws Exception {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\USER\\OneDrive\\Desktop\\Java\\Automation test-BuyMe\\ExtraReport.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO, "before test method");
        this.driver = (ChromeDriver) DriverSingleton.getDriverInstance();
        driver.get(getData("URL"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        test.log(Status.INFO, "BuyMe.co.il entered");

    }
    @Test(priority = 0)
    /**
     * Test 1
     * This test is assertion test for the error message in the signin form
     *
     */
    public void assertErrorMessasge() throws Exception {
        test.log(Status.INFO,"Assertion test for error message Started");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        try {
            /**
             * Step 1 - assert the email error message
             */
            clickElement(ExtrasLocators.SignInSignUpButton);
            test.log(Status.PASS,"Clicked signIn/SignUp");
            clickElement(ExtrasLocators.SignInButton);
            test.log(Status.PASS,"Clicked SignIn(error message trigger");

            String expectedErrorMessage = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";
            Assert.assertEquals(getText(ExtrasLocators.EmailMissingMessage), expectedErrorMessage);
            test.log(Status.PASS,"Email missing error message assertion passed");
            /**
             * Step 2 - assert password error message
             */
            Assert.assertEquals(getText(ExtrasLocators.PasswordMissingMessage),expectedErrorMessage);
            test.log(Status.PASS,"Password missing error message assertion passed");

        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"Assertion test fail");
            test.fail("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    @Test(priority = 1)
    /**
     * Test 2
     * Using the JavaScript executor, it scrolls to the buttom of the page and takes a screenshot
     *
     */
    public void pickGiftAndTakeScrennShot() throws Exception {
        clickElement(ExtrasLocators.CloseForm);
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            // Scroll down by 500 pixels
            js.executeScript("window.scrollBy(0, 3000)");
            test.pass("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }catch (Exception e){
            e.printStackTrace();
            test.fail("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    @Test(priority = 2)
    /**
     * Test 3
     * This test find an element on the "send a gift" page and prints an elements color using the "getCssValue" commend
     *
     */
    public void testTextColor(){
        test.log(Status.INFO, "test 3 started");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://buyme.co.il/package/400331/3072307");
        WebElement textColorElement = driver.findElement(ExtrasLocators.TextColor);
        String elementsColor = textColorElement.getCssValue("color");
        System.out.println(elementsColor);

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
        extent.flush();
    }

    public static String takeScreenShot(String ImagesPath) {
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