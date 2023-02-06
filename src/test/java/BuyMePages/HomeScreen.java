package BuyMePages;

import BaseFunctions.BasePage;
import org.openqa.selenium.By;
import BaseFunctions.Locators;

public class HomeScreen extends BasePage {
    /**
     * This is the Second step in the test. This Class is testng the home pages filter and search bar
     * it uses the clickElement to chose items and click search
     *
     *
     * @throws Exception
     */

    public void filterAndSearch() throws Exception {
        searchAndFilterItem();
    }

    private void searchAndFilterItem() throws Exception {
        // open the "סכום" (amount) dropdown
     clickElement(Locators.amountDropDown);
     // Click "עד 99" (up to 99ILS) item
     clickElement(Locators.clickUpTo99);
     // Open "אזור" (region) dropdown
     clickElement(Locators.regionDropDown);
     //Click "צפון" (North) item
     clickElement(Locators.clickNorth);
     // Open "קטגוריה" (Category) dropdown
     clickElement(Locators.categoryDropDown);
     // Click "גיפט קארד למסעדות שף" (gift card for chef restaurants) item
     clickElement(Locators.clickChefResturants);
     // Click "תמצאו לי מתנה" (search) button
     clickElement(Locators.clickSearchGift);


    }
}
