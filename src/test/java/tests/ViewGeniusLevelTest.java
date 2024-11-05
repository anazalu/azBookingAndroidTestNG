package tests;

import data.ShareYourFeedbackTestData;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.DriverSetup;
import util.GlobalVariables;

public class ViewGeniusLevelTest extends DriverSetup {

    @Test(testName = "View Genius Level test")
    public void viewGeniusLevelTest() throws InterruptedException {

        Assert.assertTrue(stepConsentScreen.stepConsentScreenLoaded(), "Step consent screen is not loaded");

        stepConsentScreen.clickAcceptButton();
        Assert.assertTrue(stepNotificationsScreen.stepNotificationsScreenLoaded(), "Step notifications screen is not loaded");

        stepNotificationsScreen.tapNotNowButton();
        Assert.assertTrue(stepSignInScreen.stepSignInScreenLoaded(), "Step sign in screen is not loaded");

        stepSignInScreen.tapCrossButton();
        Assert.assertTrue(stepSignInToSaveScreen.stepSignInToSaveScreenLoaded(), "Step sign in to save money screen is not loaded");

        stepSignInToSaveScreen.tapOutOfSignInToSaveScreen();
//        Assert.assertTrue(tabSearchScreen.tabSearchScreenLoaded(), "Tab search screen is not loaded");

        tabSearchScreen.tapOnSignInTab();
        Assert.assertTrue(tabSignInScreen.tabSignInScreenLoaded(), "Tab sign in screen is not loaded");
        Assert.assertTrue(tabSignInScreen.userIsNotLoggedIn(), "User is logged in");

        tabSignInScreen.tapOnGenius();
    }
}
