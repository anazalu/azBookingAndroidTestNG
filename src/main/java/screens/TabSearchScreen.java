package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;
import util.Helpers;

public class TabSearchScreen {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Enter your destination\")")
    private RemoteWebElement tabSearchScreenDestinationField;

    @AndroidFindBy(accessibility = "Sign in")
    private RemoteWebElement signInTabButton;

    public TabSearchScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean tabSearchScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(tabSearchScreenDestinationField)).isDisplayed();
    }

    public void tapOnSignInTab() {
        signInTabButton.click();
    }
}
