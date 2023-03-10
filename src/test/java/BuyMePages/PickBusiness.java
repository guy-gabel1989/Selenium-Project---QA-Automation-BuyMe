package BuyMePages;

import BaseFunctions.BasePage;
import org.testng.Assert;
import BaseFunctions.Locators;

public class PickBusiness extends BasePage {
    /**
     * This is the Third step of the whole test.
     *
     * After Comliting the second step this test begins with asserting the URL
     * Since it's based on the privios step to provide the parameters for the search, the:
     * @see HomeScreen class must complete first
     *
     * @throws Exception
     */
    //a Method that assert thge pages url to make sure the user lands in the right place in the website
    public void assertURL() throws Exception {
        assertPageURL();
    }

   // chose an item on the page
    public void chooseHelenaRestaurant() throws Exception {
        choseGift();
    }
    //chose an item on the page (last step in the test)
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
