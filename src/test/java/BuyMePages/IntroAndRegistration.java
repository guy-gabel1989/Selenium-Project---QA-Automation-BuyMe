package BuyMePages;

import BaseFunctions.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class IntroAndRegistration extends BasePage {
    private WebDriver driver;

    public void start(){
        clickSignUp_SignInButton();
    }
    public void clickSignUp(){
        clickSignUpLink();
    }

    public void password(){
        fillPasswords();
    }

    public void nameBox(){
        fillNameBox();
    }
    public void emailBox(){
        fillEmailBox();
    }

    public void clickAndSubmit(){
        acceptTerms();
    }

    public void compareEmail(){
        compareEmailBoxs();
    }

    private void clickSignUp_SignInButton(){
        clickElement(By.xpath("//span[contains(text(),'כניסה / הרשמה')]"));
    }

    private void clickSignUpLink(){
        clickElement(By.xpath("//span[@class='text-link theme']"));
    }

    private void fillNameBox(){
        sendKeysToElement(By.id("ember1863"),("גרבר"));
    }
    private void fillEmailBox(){
        sendKeysToElement(By.xpath("//input[@placeholder='מייל']"), ("Darling@gsmurf.com"));
    }

    private void fillPasswords(){
        sendKeysToElement(By.xpath("//input[@placeholder='סיסמה']"), ("passTest2023"));
        sendKeysToElement(By.xpath("//input[@placeholder='אימות סיסמה']"), ("passTest2023"));
    }

    private void acceptTerms(){
        clickElement(By.xpath("//div[@id='ember1890']//span[@class='circle']//*[name()='svg']//*[name()='circle' and contains(@class,'fill')]"));
    }

    private void compareEmailBoxs(){
        String expectedEmail = "Darling@gsmurf.com";
        String actualEmail = getResult(By.xpath("//input[@placeholder='מייל']"));
        Assert.assertEquals(actualEmail, expectedEmail);

    }












}
