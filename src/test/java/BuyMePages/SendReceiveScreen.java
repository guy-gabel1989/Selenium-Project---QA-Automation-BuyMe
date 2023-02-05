package BuyMePages;
import BaseFunctions.BasePage;
import BaseFunctions.Locators;
public class SendReceiveScreen extends BasePage {
//
//
//
//
    public void fillReciversName() throws Exception {
        fillReceiversName();
    }

    public void choseEventType() throws Exception {
        clickEventTypeDropDown();
    }

    public void clickThanksOption() throws Exception {
        choseThanksOption();
    }
    public void addTextTogift() throws Exception {
        textToGift();
    }
    public void uploadPicture() throws Exception {
        uploadPic();
    }
    public void clickContinue() throws Exception {
        counitue();
    }
    public void clickRadioButtonNow() throws Exception {
        checkRadioNow();
    }
    public void addSMSnumber() throws Exception {
        addSMSnum();
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
        sendKeysToElement(Locators.textArea, "" +
                "That's it Morty! I turned myself into a textbox! \n" +
                "I'm textbox Rick!!! " +
                "_____\n" +
                "/     \\\n" +
                "|  o o |\n" +
                "|   >   |\n" +
                "| '---' |\n" +
                " \\_____/");
    }

    private void uploadPic() throws Exception {
        sendKeysToElement(Locators.DropImage,"C:\\Users\\USER\\OneDrive\\Desktop\\Java\\Automation test-BuyMe\\pictureForTest\\pngtree-future-intelligent-technology-robot-ai-png-image_2588803.jpg") ;
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
        sendKeysToElement(Locators.PhoneNumber,"055478962");
    }

}


