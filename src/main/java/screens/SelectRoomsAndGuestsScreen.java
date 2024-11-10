package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class SelectRoomsAndGuestsScreen {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Select rooms and guests\")")
    private RemoteWebElement selectRoomsTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/bui_input_stepper_add_button\").instance(0)")
    private RemoteWebElement addRoomsButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/bui_input_stepper_add_button\").instance(1)")
    private RemoteWebElement addGuestsButton;

    @AndroidFindBy(id = "com.booking:id/group_config_apply_button")
    private RemoteWebElement applyButton;

    public SelectRoomsAndGuestsScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean selectRoomsAndGuestsScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(selectRoomsTitle)).isDisplayed();
    }

    public void tapOnAddRoomsButton(){
        addRoomsButton.click();
    }

    public void tapOnAddGuestsButton(){
        addGuestsButton.click();
    }

    public void tapOnApplyButton() {
//        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.elementToBeClickable(applyButton)).click();
        applyButton.click();
    }
}
