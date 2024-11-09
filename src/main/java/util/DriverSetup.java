package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import screens.*;

public class DriverSetup extends ConfigReader {

    public static AndroidDriver driver;

    protected Helpers helpers;

    protected StepConsentScreen stepConsentScreen;
    protected StepNotificationsScreen stepNotificationsScreen;
    protected StepSignInScreen stepSignInScreen;
    protected StepSignInToSaveScreen stepSignInToSaveScreen;
    protected TabSearchScreen tabSearchScreen;
    protected TabSignInScreen tabSignInScreen;
    protected GeniusScreen geniusScreen;
    protected DiscoverNewLevelsScreen discoverNewLevelsScreen;
    protected SelectDestinationScreen selectDestinationScreen;
    protected SelectDatesScreen selectDatesScreen;
    protected SelectRoomsAndGuestsScreen selectRoomsAndGuestsScreen;
    protected SearchResultsScreen searchResultsScreen;
    protected AccommodationScreen accommodationScreen;
    protected SavedItemsScreen savedItemsScreen;

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

        stepConsentScreen = new StepConsentScreen(driver);
        stepNotificationsScreen = new StepNotificationsScreen(driver);
        stepSignInScreen = new StepSignInScreen(driver);
        stepSignInToSaveScreen = new StepSignInToSaveScreen(driver);
        tabSearchScreen = new TabSearchScreen(driver);
        tabSignInScreen = new TabSignInScreen(driver);
        geniusScreen = new GeniusScreen(driver);
        discoverNewLevelsScreen = new DiscoverNewLevelsScreen(driver);
        selectDestinationScreen = new SelectDestinationScreen(driver);
        selectDatesScreen = new SelectDatesScreen(driver);
        selectRoomsAndGuestsScreen = new SelectRoomsAndGuestsScreen(driver);
        searchResultsScreen = new SearchResultsScreen(driver);
        accommodationScreen = new AccommodationScreen(driver);
        savedItemsScreen = new SavedItemsScreen(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
