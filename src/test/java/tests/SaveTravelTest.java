package tests;

import data.SaveTravelTestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaveTravelTest extends SaveTravelTestData {

    @Test(testName = "Save travel dates and destination test", dataProvider = "dates_data")
    public void saveTravelTest(String datesData) throws InterruptedException {

        Assert.assertTrue(stepConsentScreen.stepConsentScreenLoaded(), "Step consent screen is not loaded");

        stepConsentScreen.clickAcceptButton();
        Assert.assertTrue(stepNotificationsScreen.stepNotificationsScreenLoaded(), "Step notifications screen is not loaded");

        stepNotificationsScreen.tapNotNowButton();
        Assert.assertTrue(stepSignInScreen.stepSignInScreenLoaded(), "Step sign in screen is not loaded");

        stepSignInScreen.tapCrossButton();
        Assert.assertTrue(stepSignInToSaveScreen.stepSignInToSaveScreenLoaded(), "Step sign in to save money screen is not loaded");

        stepSignInToSaveScreen.tapOutOfSignInToSaveScreen();
//        Assert.assertTrue(tabSearchScreen.tabSearchScreenLoaded(), "Tab search screen is not loaded");
//        Assert.assertTrue(tabSearchScreen.searchTabNotClickable(), "Search tab can be clicked");

        tabSearchScreen.goToDestinationSelectionScreen();
        Assert.assertTrue(selectDestinationScreen.selectDestinationScreenLoaded(), "Select destination screen is not loaded");

//        tabSearchScreen.enterDatesText(datesData);
    }
}
