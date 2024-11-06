package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class TabSignInScreen {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sign in\")")
    private RemoteWebElement tabSignInScreenText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign in or create account\")")
    private RemoteWebElement signInButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Genius loyalty program\")")
    private RemoteWebElement geniusButton;

    public TabSignInScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean tabSignInScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(tabSignInScreenText)).isDisplayed();
    }

    public boolean userIsNotLoggedIn() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(signInButton)).isDisplayed();
    }

    public void tapOnGenius() {
        geniusButton.click();
    }
}
