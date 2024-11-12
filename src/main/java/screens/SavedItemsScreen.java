package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class SavedItemsScreen {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"My next trip\").instance(0)")
    private RemoteWebElement screenTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/sr_property_card_header_property_name\")")
    private RemoteWebElement savedAccommodationText;

    public SavedItemsScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Saved items screen loaded")
    public boolean savedItemsScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(screenTitle)).isDisplayed();
    }

    @Step("Confirmed the name of the saved item")
    public String getSavedAccommodationNameText() {
        return savedAccommodationText.getText();
    }
}
