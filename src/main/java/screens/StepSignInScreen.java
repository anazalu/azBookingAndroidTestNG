package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class StepSignInScreen {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/identity_header_title")
    private RemoteWebElement stepSignInScreenText;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Navigate up\")")
    private RemoteWebElement crossButton;

    public StepSignInScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean stepSignInScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(stepSignInScreenText)).isDisplayed();
    }

    public void tapCrossButton() {
        crossButton.click();
    }
}
