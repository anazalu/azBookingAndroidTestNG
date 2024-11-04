package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import pages.*;

public class DriverSetup extends ConfigReader {

    public static AndroidDriver driver;

    protected Helpers helpers;
//    protected RestAssuredUtility restAssuredUtility;

//    protected StepTrackingPage stepTrackingPage;
//    protected LoginHomePage loginHomePage;
    protected StepWelcomePage stepWelcomePage;
//    protected StepSearchPage stepSearchPage;
//    protected StepPriceAlertsPage stepPriceAlertsPage;
//    protected StepCurrencyPage stepCurrencyPage;
//    protected StepHomeAirportPage stepHomeAirportPage;
//    protected SearchPage searchPage;
//    protected ProfilePage profilePage;
//    protected FeedbackPage feedbackPage;

    @BeforeMethod
    public void setUp() {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setAvd(getProperty("avd"))
                .setApp(getProperty("app"))
                .setAppPackage(getProperty("app.package"))
                .setAppActivity(getProperty("app.activity"))
                .setNoReset(false)
                .setFullReset(true)
                .setCapability("appium:disableIdLocatorAutocompletion", true);

        try {
            driver = new AndroidDriver(new URI(GlobalVariables.localAppiumServerUrl).toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        helpers = new Helpers();
//        restAssuredUtility = new RestAssuredUtility();

//        stepTrackingPage = new StepTrackingPage(driver);
//        loginHomePage = new LoginHomePage(driver);
        stepWelcomePage = new StepWelcomePage(driver);
//        stepSearchPage = new StepSearchPage(driver);
//        stepPriceAlertsPage = new StepPriceAlertsPage(driver);
//        stepCurrencyPage = new StepCurrencyPage(driver);
//        stepHomeAirportPage = new StepHomeAirportPage(driver);
//        searchPage = new SearchPage(driver);
//        profilePage = new ProfilePage(driver);
//        feedbackPage = new FeedbackPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
