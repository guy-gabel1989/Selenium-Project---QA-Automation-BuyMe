package Extras;

import org.openqa.selenium.By;

public class ExtrasLocators {
    public static final By SignInSignUpButton = By.xpath("//span[contains(text(),'כניסה / הרשמה')]");
    public static final By SignInButton = By.xpath("//button[@id='ember1852']//span[1]");
    public static final By EmailMissingMessage = By.xpath("(//li[@class='parsley-required'][contains(text(),'כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה')])[1]");
    public static final By PasswordMissingMessage = By.xpath("(//li[@class='parsley-required'][contains(text(),'כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה')])[2]");
    public static final By CloseForm = By.xpath("(//*[name()='svg'][@id='times'])[1]");
    public static final By TextColor = By.xpath("(//div[@class='label bottom-xs'])[1]");

}
