package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.DriverSetup;

@Epic("Mobile automation Booking app testing")
@Feature("Genius levels")
public class ViewGeniusLevelTest extends DriverSetup {

    @Test(testName = "View Genius Level test")
    public void viewGeniusLevelTest() throws Exception {

        Assert.assertTrue(stepConsentScreen.stepConsentScreenLoaded(), "Step consent screen is not loaded");

        stepConsentScreen.clickAcceptButton();
        Assert.assertTrue(stepNotificationsScreen.stepNotificationsScreenLoaded(), "Step notifications screen is not loaded");

        stepNotificationsScreen.tapNotNowButton();
        Assert.assertTrue(stepSignInScreen.stepSignInScreenLoaded(), "Step sign in screen is not loaded");

        stepSignInScreen.tapCrossButton();
        Assert.assertTrue(stepSignInToSaveScreen.stepSignInToSaveScreenLoaded(), "Step sign in to save money screen is not loaded");

        stepSignInToSaveScreen.tapOutOfSignInToSaveScreen();
//        driver.wait(1000);
//        Assert.assertTrue(tabSearchScreen.tabSearchScreenLoaded(), "Tab search screen is not loaded");
//        Assert.assertTrue(tabSearchScreen.searchTabNotClickable(), "Search tab can be clicked");

        tabSearchScreen.tapOnSignInTab();
        Assert.assertTrue(tabSignInScreen.tabSignInScreenLoaded(), "Tab sign in screen is not loaded");
        Assert.assertTrue(tabSignInScreen.userIsNotLoggedIn(), "User is logged in");

        tabSignInScreen.tapOnGenius();
        Assert.assertTrue(geniusScreen.geniusScreenInitialViewTitleLoaded(), "Genius screen is not loaded");

        geniusScreen.tapOnAboutGeniusLevelsButton();
        Assert.assertTrue(discoverNewLevelsScreen.discoverNewLevelsScreenLoaded(), "Discover new levels screen is not loaded");

        // WIP - scroll horizontally to level 3

        discoverNewLevelsScreen.tapGotItButton();

        geniusScreen.tapOnBackButton();
    }
}
