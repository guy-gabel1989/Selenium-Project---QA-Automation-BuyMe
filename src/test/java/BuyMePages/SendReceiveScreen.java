package BuyMePages;
import BaseFunctions.BasePage;
import BaseFunctions.Locators;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SendReceiveScreen extends BasePage {
    /**
     * This if the fourth and last step of the test
     *
     * After choosing a gift in the:
     * @see PickBusiness class - this class tests filing all the dietales of the gift
     * sender and the reciver
     *
     * after filling the first screen the class runs an assertion test
     * same assertion runs after filling the secind screen
     *
     * @throws Exception
     */
    //fill the gift reciver name
    public void fillReciversName() throws Exception {
        fillReceiversName();
    }

    //chose an ebnt type for the gift
    public void choseEventType() throws Exception {
        clickEventTypeDropDown();
    }

    public void clickThanksOption() throws Exception {
        choseThanksOption();
    }
    // add a text in the "add a letter to yopr gift" textBox
    public void addTextTogift() throws Exception {
        textToGift();
    }
    // upload a png image to the "add a photo" filed
    public void uploadPicture() throws Exception {
        uploadPic();
    }
    //assertion test to of the textBoxs before continuing to the next screen
    public void assertFirstPage() throws Exception {
        firstPageAssert();
    }
    //submit first screen ang continue to the next screen
    public void clickContinue() throws Exception {
        counitue();
    }
    // click the"send later radio button and then back to "send gift now" radio button
    public void clickRadioButtonNow() throws Exception {
        checkRadioNow();
    }
    //add the gift receiver number
    public void addSMSnumber() throws Exception {
        addSMSnum();
    }
   // add the senders name and phone number
    public void senderNameAndPhone() throws Exception {
        addSenderName();
        addSenderPhone();
    }
  //assert all the fields in the second screen
    public void assertSecondPage() throws Exception {
        secondPageAssertion();
    }


private void fillReceiversName() throws Exception {
    sendKeysToElement(Locators.receiversName, "ממבו ג'מבו");
}
private void clickEventTypeDropDown() throws Exception {
        clickElement(Locators.whichEventDropDown);

}
    private void choseThanksOption() throws Exception {
        clickElement(Locators.thanksEventDropDown);
    }

    private void textToGift() throws Exception {
        clearText(Locators.textArea);
        sendKeysToElement(Locators.textArea, "That's it Morty! I turned myself into a textbox!  I'm textbox Rick!!! ");

    }

    private void uploadPic() throws Exception {
        sendKeysToElement(Locators.DropImage,"C:\\Users\\USER\\OneDrive\\Desktop\\Java\\Automation test-BuyMe\\pictureForTest\\pngtree-future-intelligent-technology-robot-ai-png-image_2588803.jpg") ;
    }

    /**
     *Runs Assertion on all the fields in the first screen before continuing to the next screen
     */
    private void firstPageAssert() throws Exception {
        String expectedReciverName = "ממבו ג'מבו";
            Assert.assertEquals(getValue(Locators.receiversName), expectedReciverName);

            String expectedEventType = "תודה";
            Assert.assertEquals(getText(Locators.thanksEventDropDown),expectedEventType);

            String expectedTextToGift = "That's it Morty! I turned myself into a textbox!  I'm textbox Rick!!! ";
            Assert.assertEquals(getValue(Locators.textArea),expectedTextToGift);

    }

    private void counitue() throws Exception {
        clickElement(Locators.ClickContinue);
    }
    private void checkRadioNow() throws Exception {
        clickElement(Locators.RadioButtonLater);
        clickElement(Locators.RadioButtonNow);
    }
    private void addSMSnum() throws Exception {
        clickElement(Locators.SMS);
        sendKeysToElement(Locators.PhoneNumber,"065478962");
    }

    private void addSenderName()throws Exception{
        sendKeysToElement(Locators.SenderName, "אבי ביטר");
    }
    private void addSenderPhone()throws Exception{
        sendKeysToElement(Locators.SenderPhoneNumber, "0647899654");
    }
    private void secondPageAssertion() throws Exception {
        String expectedSMS = "065478962";
        Assert.assertEquals(getValue(Locators.PhoneNumber), expectedSMS);

        String expectedsenderName = "אבי ביטר";
        Assert.assertEquals(getValue(Locators.SenderName), expectedsenderName);

        String expectedSenderPhoneNumber = "0647899654";
        Assert.assertEquals(getValue(Locators.SenderPhoneNumber), expectedSenderPhoneNumber);

    }

}


