package BaseFunctions;

import org.openqa.selenium.By;

public class Locators {
    //////////////////////////////////////////
    // Home page locators for @TestSignup
//////////////////////////////////////////

  public static final By NameBox = By.id("ember1863");
public static final By SignInButton = By.xpath("//span[contains(text(),'כניסה / הרשמה')]");
public static final By SignUpLink = By.xpath("//span[@class='text-link theme']");
public static final By EmailBox = By.xpath("//input[@placeholder='מייל']");
public static final By Password = By.xpath("//input[@placeholder='סיסמה']");
public static final By confirmPassword = By.xpath("//input[@placeholder='אימות סיסמה']");
public static final By radioButtonAcceptTerms = By.xpath("//div[@id='ember1890']//span[@class='circle']//*[name()='svg']//*[name()='circle' and contains(@class,'fill')]");

//////////////////////////////////////////
    // Home page locators for @TestHomePage
//////////////////////////////////////////
public static final By priceDropDown = By.cssSelector("div[class='selected-name'] span[alt='סכום']");
public static final By clickUpTo99 = By.xpath("//li[@value='2']");
public static final By regionDropDown = By.xpath("//label[@id='ember1088']//div[@class='selected-name']");
public static final By clickNorth = By.xpath("(//span[contains(text(),'צפון')])");
public static final By categoryDropDown = By.cssSelector("label[id='ember1120'] div[class='selected-name']");
public static final By clickChefRestaurants = By.xpath("//span[contains(text(),'גיפט קארד למסעדות שף')]");
public static final By clickSearchGift = By.className("ember-view bm-btn no-reverse main md ember-view");
}
