package tests;

import data.SaveTravelTestData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Mobile automation Booking app testing")
@Feature("Save items")
public class SaveTravelTest extends SaveTravelTestData {

    @Story("Successful search for accommodation and saving search results")
    @Description("Save items")
    @Test(testName = "Save travel dates and destination test", dataProvider = "dates_data")
    public void saveTravelTest(String dateStartData, String dateEndData) throws InterruptedException {

        Assert.assertTrue(stepConsentScreen.stepConsentScreenLoaded(), "Step consent screen is not loaded");

        stepConsentScreen.clickAcceptButton();
        Assert.assertTrue(stepNotificationsScreen.stepNotificationsScreenLoaded(), "Step notifications screen is not loaded");

        stepNotificationsScreen.tapNotNowButton();
        Assert.assertTrue(stepSignInScreen.stepSignInScreenLoaded(), "Step sign in screen is not loaded");

        stepSignInScreen.tapCrossButton();
        Assert.assertTrue(stepSignInToSaveScreen.stepSignInToSaveScreenLoaded(), "Step sign in to save money screen is not loaded");

        stepSignInToSaveScreen.tapOutOfSignInToSaveScreen();
//        Assert.assertTrue(tabSearchScreen.tabSearchScreenLoaded(), "Tab search screen is not loaded");
//        Assert.assertTrue(tabSearchScreen.searchTa    bNotClickable(), "Search tab can be clicked");

        tabSearchScreen.goToDestinationSelectionScreen();
        Assert.assertTrue(selectDestinationScreen.selectDestinationScreenLoaded(), "Select destination screen is not loaded");

        selectDestinationScreen.enterDestinationText();
//        Assert.assertTrue(selectDestinationScreen.firstSearchResultLoaded(), "Search results not loaded");
        selectDestinationScreen.selectFirstResult();
        Assert.assertTrue(selectDatesScreen.selectDatesScreenLoaded(), "Select dates screen not loaded");

        selectDatesScreen.selectDates(dateStartData, dateEndData);
        Assert.assertTrue(selectDatesScreen.selectDatesScreenLoaded(), "Select dates screen not loaded");
        selectDatesScreen.tapOnSelectDatesButton();
//        Assert.assertTrue(tabSearchScreen.tabSearchScreenLoaded(), "Search screen not loaded");

        tabSearchScreen.goToRoomsAndGuestsScreen();
        Assert.assertTrue(selectRoomsAndGuestsScreen.selectRoomsAndGuestsScreenLoaded(), "Rooms and guests screen not loaded");

        selectRoomsAndGuestsScreen.tapOnAddRoomsButton();
        selectRoomsAndGuestsScreen.tapOnAddGuestsButton();
        selectRoomsAndGuestsScreen.tapOnApplyButton();
//        Assert.assertTrue(tabSearchScreen.tabSearchScreenLoaded(), "Search screen not loaded");
        tabSearchScreen.tapOnSearchButton();

        Assert.assertTrue(searchResultsScreen.searchResultsScreenLoaded());
        Assert.assertEquals(searchResultsScreen.getDestinationText().toLowerCase(), "skopje", "Destination text mismatch");
//        WIP - assert dates match
        String actualDates = searchResultsScreen.getDatesText();
        System.out.println(dateStartData + dateEndData + actualDates);

        searchResultsScreen.goToFirstAccommodationScreen();
        Assert.assertTrue(accommodationScreen.accommodationScreenLoaded(), "Accommodation screen not loaded");

        String expectedAccommodationName = accommodationScreen.getAccommodationNameText();
        System.out.println("expected item: " + expectedAccommodationName);

        accommodationScreen.addToSaved();
        accommodationScreen.tapOnBackButton();
        Assert.assertTrue(searchResultsScreen.searchResultsScreenLoaded());

        searchResultsScreen.tapOnBackButton();
//        Assert.assertTrue(tabSearchScreen.tabSearchScreenLoaded(), "Search screen not loaded");
        tabSearchScreen.tapOnSavedTab();
        Assert.assertTrue(savedItemsScreen.savedItemsScreenLoaded(), "Saved items screen not loaded");

        String actualAccommodationName = savedItemsScreen.getSavedAccommodationNameText();
        System.out.println("actual item: " + actualAccommodationName);
        Assert.assertEquals(actualAccommodationName.toLowerCase(), expectedAccommodationName.toLowerCase(), "Saved item name mismatch");
    }
}
