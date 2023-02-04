package BuyMePages;

import BaseFunctions.BasePage;
import BaseFunctions.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IntroAndRegistration extends BasePage {
    private WebDriver driver;

    public void signUpOrInButton(){
        clickSignUp_SignInButton();

    }
    public void clickSignUp() {
        clickSignUpLink();
    }
    public void nameFiled() {
        fillNameBox();
    }
    public void emailFiled() {
        fillEmailBox();
    }
    public void insertPasswords() {
        fillPasswords();
    }

    public void checkRadioButton() {
        acceptTerms();
    }
    public void assetrtFileds() {
        assertAllFeilds();
    }
    public void closeSignUp() {
        closForm();
    }



    private void clickSignUp_SignInButton()  {
        clickElement(Locators.SignInButton);
    }

    private void clickSignUpLink() {
        clickElement(Locators.SignUpLink);
    }

    private void fillNameBox() {
        sendKeysToElement(Locators.NameBox, ("גרבר"));

    }
    private void fillEmailBox() {
        sendKeysToElement(Locators.EmailBox, ("Darling@gsmurf.com"));
    }

    private void fillPasswords()  {
        sendKeysToElement(Locators.Password, ("passTest2023"));
        sendKeysToElement(Locators.confirmPassword, ("passTest2023"));
    }

    private void acceptTerms()  {
        clickElement(Locators.radioButtonAcceptTerms);
    }

    private void assertAllFeilds()  {
        String expectedEmail = "Darling@gsmurf.com";
        String actualEmail = getResult(Locators.EmailBox);
        Assert.assertEquals(actualEmail, expectedEmail);

        String expectedName = "גרבר";
        String actualName = getResult(Locators.NameBox);
        Assert.assertEquals(actualName, expectedName);

        String expectedPassword = "passTest2023";
        String actualPassword = getResult(Locators.Password);
        Assert.assertEquals(actualPassword, expectedPassword);

        String expectedConfirmPassword = "passTest2023";
        String actualConfirmPassword = getResult(Locators.confirmPassword);
        Assert.assertEquals(actualConfirmPassword, expectedConfirmPassword);

    }

    private void closForm() {
        clickElement(By.cssSelector("span[title='סגירה']"));
    }




}
