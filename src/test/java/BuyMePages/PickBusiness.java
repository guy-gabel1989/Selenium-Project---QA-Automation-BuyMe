package BuyMePages;

import BaseFunctions.BasePage;
import org.testng.Assert;
import BaseFunctions.Locators;

public class PickBusiness extends BasePage {
    public void assertURL() throws Exception {
        assertPageURL();
    }

    public void chooseHelenaRestaurant() throws Exception {
        choseGift();
    }
    public void chooseDoubleChefDeal() throws Exception {
        clickChefDeal();
    }




    private void assertPageURL() throws Exception {
        String expectedURL = "https://buyme.co.il/search?budget=2&category=16&region=9";
        String actualURL = getTitle();
        Assert.assertEquals(actualURL, expectedURL);
    }

    private void choseGift() throws Exception {
        clickElement(Locators.clickRestaurant);

    }

    private void clickChefDeal() throws Exception {
        clickElement(Locators.clickCouplesChefDeal);
    }



}
