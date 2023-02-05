package BaseFunctions;

import org.openqa.selenium.By;

public class Locators {

    public static final By NameBox = By.id("ember1863");
public static final By SignInButton = By.xpath("//span[contains(text(),'כניסה / הרשמה')]");

public static final By SignUpLink = By.xpath("(//span[@class='text-link theme'])[1]");

public static final By EmailBox = By.xpath("//input[@placeholder='מייל']");

public static final By Password = By.xpath("//input[@placeholder='סיסמה']");
public static final By confirmPassword = By.xpath("//input[@placeholder='אימות סיסמה']");

public static final By radioButtonAcceptTerms = By.xpath("//div[@id='ember1890']//span[@class='circle']//*[name()='svg']//*[name()='circle' and contains(@class,'fill')]");
public static final By closeSignUpForm = By.xpath("//span[@title='סגירה']");

////////////////////////////
//HomeScreen Locators
///////////////////////////
public static final By amountDropDown = By.cssSelector("div[class='selected-name'] span[alt='סכום']");
public static final By clickUpTo99 = By.xpath("//li[@value='2']");
public static final By regionDropDown = By.xpath("//label[@id='ember1088']//div[@class='selected-name']");
public static final By clickNorth = By.xpath("(//span[contains(text(),'צפון')])");
public static final By categoryDropDown =  By.cssSelector("label[id='ember1120'] div[class='selected-name']");
public static final By clickChefResturants = By.xpath("//span[contains(text(),'גיפט קארד למסעדות שף')]");
public static final By clickSearchGift = By.xpath("//a[@id='ember1199']");
///////////////////////////////
//*PickBusinees Class locators
///////////////////////////////
 public static final By clickRestaurant = By.xpath("(//span[@class='name bm-subtitle-1'])[5]");
public static final By clickCouplesChefDeal = By.cssSelector("button[id='ember2086']");

///////////////////////////////
//Send And Receiver test locators
///////////////////////////////

    public static final By receiversName = By.xpath("(//input[@id='ember1373'])[1]");
    public static final By whichEventDropDown = By.xpath("(//div[@class='selected-name'])[1]");
    public static final By thanksEventDropDown = By.xpath("(//span[contains(text(),'תודה')])[1]");
    public static final By textArea = By.xpath("//textarea[@placeholder='מזל טוב, תודה רבה או פשוט מלא אהבה? כאן כותבים מילים טובות ואיחולים שמחים']");
    public static final By DropImage = By.xpath("(//input[@accept='image/png,image/jpeg,video/quicktime,video/mp4,.mov,.qt'])[1]");
    public static final By ClickContinue = By.xpath("(//button[@type='submit'])[1]");

    //<-------------Next Screen------------>
    public static final By RadioButtonLater = By.xpath("(//*[name()='circle'][@class='check'])[2]");
    public static final By RadioButtonNow = By.xpath("(//*[name()='circle'][@class='check'])[1]");
    public static final By SMS = By.xpath("(//*[name()='path'][@class='circle'])[1]");
    public static final By PhoneNumber = By.xpath("//input[@placeholder='נייד מקבל/ת המתנה']");



}




