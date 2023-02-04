import BaseFunctions.DriverSingleton;
import BuyMePages.HomeScreen;
import BuyMePages.IntroAndRegistration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class POM_BuyMe extends DriverSingleton {
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("BuyMe - Automation test", "QA Automation test for https://buyme.co.il/");
    String timeNow = String.valueOf(System.currentTimeMillis());

        private static WebDriver driver;

        @BeforeClass
        public void runBeforeClass() throws Exception {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\USER\\OneDrive\\Desktop\\Java\\Automation test-BuyMe");
            extent.attachReporter(htmlReporter);
            this.driver = DriverSingleton.getDriverInstance();
            test.log(Status.INFO,"driver invoked");


            driver.get("https://buyme.co.il/");
            test.log(Status.INFO, "BuyMe.co.il entered");
    }

    @Test

    public void TestSignup() throws Exception {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        IntroAndRegistration introAndRegistration = new IntroAndRegistration();
        test.log(Status.INFO, "Test 1 - signUp sanity test start");
        try {
            introAndRegistration.signUpOrInButton();
            test.log(Status.PASS, "SignUp/ SignIn Button pass");
            introAndRegistration.clickSignUp();
            test.log(Status.PASS,"SignUp form load");
            introAndRegistration.nameFiled();
            test.log(Status.PASS,"Sent Kets to name textbox");
            introAndRegistration.emailFiled();
            test.log(Status.PASS, "Sent keys to Email textbox");
            introAndRegistration.insertPasswords();
            test.log(Status.PASS, "Password & password confirmed sent keys");
            introAndRegistration.checkRadioButton();
            test.log(Status.PASS," Radio button checked");
            introAndRegistration.assetrtFileds();
            test.log(Status.PASS, "Asserted all fields");
        }catch (Exception e){
            test.fail(e.getMessage(),
            MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());

        }
    }

//     @Test (priority = 1)
//     public void TestHomePage() throws Exception {
//         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
//         HomeScreen homeScreen = new HomeScreen();
//         driver.get("https://buyme.co.il/");
//         try {
//             homeScreen.filterAndSearch();
//             test.log(Status.PASS, "HomeScreen filter and search test complete");
//         }catch (Exception e){
//             test.fail(e.getMessage(),
//             MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
//
//         }
//
//     }
//
//     @Test
//     public void pickABusiness(){
//            driver.get("");
//     }



    @AfterClass
    public void afterClass(){
//            driver.quit();
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
