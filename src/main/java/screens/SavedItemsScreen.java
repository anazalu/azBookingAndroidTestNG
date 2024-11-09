package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class SavedItemsScreen {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"My next trip\").instance(0)")
    private RemoteWebElement screenTitle;
//
//    @AndroidFindBy(accessibility = "com.booking:id/sr_property_card_header_property_name")
//    private RemoteWebElement savedAccommodationText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/sr_property_card_header_property_name\")")
    private RemoteWebElement savedAccommodationText;
//
//    @AndroidFindBy(accessibility = "Navigate up")
//    private RemoteWebElement backButton;

    public SavedItemsScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean savedItemsScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(screenTitle)).isDisplayed();
    }

    public String getSavedAccommodationNameText() {
        return savedAccommodationText.getText();
    }

//    public void tapOnBackButton() {
//        backButton.click();
//    }
}
