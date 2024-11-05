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
//        Assert.assertTrue(stepSignInToSaveScreen.stepSignInToSaveScreenLoaded(), "Step sign in to save screen is not loaded");

        stepSignInToSaveScreen.tapOutOfSignInToSaveScreen();
    }
}
