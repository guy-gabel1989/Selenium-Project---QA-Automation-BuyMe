import BaseFunctions.DriverSingleton;
import BuyMePages.IntroAndRegistration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class POM_BuyMe extends DriverSingleton {

        private WebDriver driver;

        @BeforeClass
        public void runBeforeClass(){
            this.driver = DriverSingleton.getDriverInstance();
            driver.get("https://buyme.co.il/");
    }

    @Test

    public void test_01_Test(){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        IntroAndRegistration introAndRegistration = new IntroAndRegistration();
        introAndRegistration.start();
        introAndRegistration.clickSignUp();
        introAndRegistration.nameBox();
        introAndRegistration.emailBox();
        introAndRegistration.password();
        introAndRegistration.compareEmail();




    }
}
