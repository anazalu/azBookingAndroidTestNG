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
//    protected RestAssuredUtility restAssuredUtility;

//    protected LoginHomePage loginHomePage;
    protected StepConsentScreen stepConsentScreen;
    protected StepNotificationsScreen stepNotificationsScreen;
//    protected SearchPage searchPage;

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

        stepConsentScreen = new StepConsentScreen(driver);
        stepNotificationsScreen = new StepNotificationsScreen(driver);
//        searchPage = new SearchPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
