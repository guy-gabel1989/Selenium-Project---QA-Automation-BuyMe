package BuyMePages;

import BaseFunctions.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import BaseFunctions.Locators;

public class IntroAndRegistration extends BasePage {

    /**
     * This is the first step of the page
     * it's simulating a user completing a sign-up from the home page
     *steps:
     * 1. click the "signin/signup" button
     * 2. click signup
     * 3. fill the signup form
     * 4. asserting all the fields (see the assertAllFields method at the button of this class
     *
     * the test is being executed here: POM_BuyMe (main test class)
     *
     *
     */

    private WebDriver driver;


    public void signUpOrInButton() throws Exception {
        clickSignUp_SignInButton();

    }
    public void clickSignUp() throws Exception {
        clickSignUpLink();
    }
    public void nameFiled() throws Exception {
        fillNameBox();
    }
    public void emailFiled() throws Exception {
        fillEmailBox();
    }
    public void insertPasswords() throws Exception {
        fillPasswords();
    }

    public void checkRadioButton() throws Exception {
        acceptTerms();
    }
    public void assetrtFileds() throws Exception {
        assertAllFeilds();
    }
    public void closeSignUp() throws Exception {
        closForm();
    }



    private void clickSignUp_SignInButton() throws Exception {
        clickElement(Locators.SignInButton);
    }

    private void clickSignUpLink() throws Exception {
        clickElement(Locators.SignUpLink);
    }

    private void fillNameBox() throws Exception {
        sendKeysToElement(Locators.NameBox, ("גרבר"));

    }
    private void fillEmailBox() throws Exception {
        sendKeysToElement(Locators.EmailBox, ("Darling@gsmurf.com"));
    }

    private void fillPasswords() throws Exception {
        sendKeysToElement(Locators.Password, ("passTest2023"));
        sendKeysToElement(Locators.confirmPassword, ("passTest2023"));
    }

    private void acceptTerms() throws Exception {
        clickElement(Locators.radioButtonAcceptTerms);
    }

    private void assertAllFeilds() throws Exception {
        String expectedEmail = "Darling@gsmurf.com";
        String actualEmail = getValue(Locators.EmailBox);
        Assert.assertEquals(actualEmail, expectedEmail);

        String expectedName = "גרבר";
        String actualName = getValue(Locators.NameBox);
        Assert.assertEquals(actualName, expectedName);

        String expectedPassword = "passTest2023";
        String actualPassword = getValue(Locators.Password);
        Assert.assertEquals(actualPassword, expectedPassword);

        String expectedConfirmPassword = "passTest2023";
        String actualConfirmPassword = getValue(Locators.confirmPassword);
        Assert.assertEquals(actualConfirmPassword, expectedConfirmPassword);

    }

    private void closForm() throws Exception {
        clickElement(Locators.closeSignUpForm);
    }




}
