package tests;

import data.ShareYourFeedbackTestData;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.DriverSetup;
import util.GlobalVariables;

public class ViewGeniusLevelTest extends DriverSetup {

    @Test(testName = "View Genius Level test")
    public void viewGeniusLevelTest() throws InterruptedException {

        Assert.assertTrue(stepWelcomePage.stepWelcomePageLoaded(), "Step welcome page is not loaded");

        stepWelcomePage.clickAcceptButton();
    }
}
