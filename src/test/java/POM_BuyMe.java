import BaseFunctions.DriverSingleton;
import BuyMePages.HomeScreen;
import BuyMePages.IntroAndRegistration;
import BuyMePages.PickBusiness;
import BuyMePages.SendReceiveScreen;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BaseFunctions.DriverSingleton;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class POM_BuyMe extends DriverSingleton {
    /**
     *Automation sanity test for the website BuyMe.co.il
     * @author Guy Gabel
     * @version 1.0
     * This is the Main page of the program
     * all thge tests runs in it using TesnNG library
     * @see ExtentReports  - the library it uses to genarate reports
     * @see DriverSingleton - the classs that intiate the webdriver (detirmened by the Data.xml file
     *
     */
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("BuyMe - Automation test", "QA Automation test for https://buyme.co.il/" +
            "Sanity test for buyMe.co.il - a maven based Automation project using Selenium JAVA");
    /**
     * This string is used by the Screenshot method
     * See the "takeScreenShot" method at the bottom of the page
     */
    String timeNow = String.valueOf(System.currentTimeMillis());


        private static WebDriver driver;

        @BeforeClass
        /**
         * This methodes do:
         * 1.initiate the Extent Report object
         * 2. initiate the driver using the @DriverSingleton class
         * 3.calls the pageLoadtimeOut to make sure the website is loading in a reasonable time
         * 4. load the URL from the Data.xml file using "getData" method
         * 5. report to the extent report that the site is loading
         *
         *
         */
        public void runBeforeClass() throws Exception {
            // creating a new report
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\USER\\OneDrive\\Desktop\\Java\\Automation test-BuyMe");

            extent.attachReporter(htmlReporter);
            test.log(Status.INFO,"driver invoked");
            //Driver is initiated here
            this.driver = DriverSingleton.getDriverInstance();

            //Set a wait comment to let the page load
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

            //Gets the url from Data.xml file using the "getData" method
            driver.get(getData("URL"));
            test.log(Status.INFO, "BuyMe.co.il entered");
    }

    @Test (priority = 0)
    /**
     * Step A - Intro & Registration screen
     * test the Signup flow
     * @see introAndRegistration - were the test steps are progremed.
     *
     */

    public void TestSignup() throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
            introAndRegistration.closeSignUp();
        }catch (Exception e){
            test.log(Status.FAIL,"intro and registration test failed");
            test.fail("ScreenShot",  MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
            e.printStackTrace();

        }
    }

     @Test (priority = 1)
     public void TestHomePage() throws Exception {
         /**
          *  STEP B - Home Screen
          *          This test is runs in the website's homepage
          *          The test is for the price/regin/ category filter search, all the actions int the test sits inside the
          *          "filterAndSearch" method, these are the steps:
          *          1.click the price and chose the "up to 99 ILS option
          *          2.click the regin dropdown and click "north"
          *        3.click the category dropdown and click "gift card for chef restaurants"
          *
          */



         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
           // driver.get(getData("URL"));
         HomeScreen homeScreen = new HomeScreen();
         test.log(Status.INFO,"Test 2 - Homscreen test Started");
         try {
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
             homeScreen.filterAndSearch();
             test.log(Status.PASS, "HomeScreen filter and search test complete");
         }catch (Exception e){
             e.printStackTrace();
             test.log(Status.FAIL, "HomeScreen test Failed");
             test.fail("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());

         }

     }

     @Test (priority = 2)
     public void pickABusiness(){
/**
 * STEP C - Pick business
 *            This class is testing the page the user lands after the test of "homeScreen":
 *         1. Assert the user with a string that holds the expected URL with the current URL
 *         2. click an item from the suggested option
 *         3. clicks a gift and finish the test for this page
 */

         PickBusiness pickBusiness = new PickBusiness();
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
         /**
          *          assuming all the locator works and all the tests before passed, this test should start from the currect place on the website
          *          in case you want to run Step C individually - uncomment this line:
          *          driver.get("https://buyme.co.il/search?budget=2&category=16&region=9");
          */
         test.log(Status.INFO, "Test 3 -Testing PickBusiness started");

         try {
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
             pickBusiness.assertURL();
             test.log(Status.PASS, "URL asserted as expected");
             pickBusiness.chooseHelenaRestaurant();
             test.log(Status.PASS, "Click restaurant item passed");
             pickBusiness.chooseDoubleChefDeal();
             test.log(Status.PASS, "Click a deal item passed");


         }catch (Exception e){
             e.printStackTrace();
             test.log(Status.FAIL, "Pick a businees test failed");
             test.fail("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
         }
     }

     @Test (priority = 3)
     public void sendAndRreciverGift() throws Exception {
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
         /**
          * STEP D - Sender & Receiver information screen
          *
          * This is Step 3 of the test- "Sender and Reciver
          * it continues where the previous test ended.
          * in order to run this test individually - use this line:
          * driver.get("https://buyme.co.il/package/335223/781184");
           */

         test.log(Status.INFO, "Test 4 - Send and reciver test started");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            try {
                //   <--------First Screen---------------->
                SendReceiveScreen sendReceiveScreen = new SendReceiveScreen();
                sendReceiveScreen.fillReciversName();
                test.log(Status.PASS, "reciver name inserted");
                sendReceiveScreen.choseEventType();
                test.log(Status.PASS, "Event Type dropdown clicked");
                sendReceiveScreen.clickThanksOption();
                test.log(Status.PASS, "Event Type clicked ");
                sendReceiveScreen.addTextTogift();
                test.log(Status.PASS, "Added text to gift");
                sendReceiveScreen.uploadPicture();
                test.log(Status.PASS, "Picture uploaded successfully");
                sendReceiveScreen.assertFirstPage();
                test.log(Status.PASS, "First screen aseert pass");
                sendReceiveScreen.clickContinue();
                test.log(Status.PASS,"Clicked continue");
                //   <--------Second Screen---------------->
                sendReceiveScreen.clickRadioButtonNow();
                test.log(Status.PASS, "Radio button 'Now' clicked");
                sendReceiveScreen.addSMSnumber();
                test.log(Status.PASS, "Reciver phone number added");
                sendReceiveScreen.senderNameAndPhone();
                test.log(Status.PASS, "Sender name and phone added");
                sendReceiveScreen.assertSecondPage();
                test.log(Status.PASS,"Second page assertion passed");


            }catch (Exception e){
                e.printStackTrace();
                test.log(Status.FAIL, "Sender & Receiver test failed");
                test.fail("screenshot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());

            }
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
