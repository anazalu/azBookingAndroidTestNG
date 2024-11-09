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

public class AccommodationScreen {

    protected AndroidDriver driver;
//
//    @AndroidFindBy(accessibility = "Add to list")
//    private RemoteWebElement addToSavedButton;

    @AndroidFindBy(id = "com.booking:id/menu_favorites")
    private RemoteWebElement addToSavedButton;

    @AndroidFindBy(id = "com.booking:id/toolbar_title_textView")
    private RemoteWebElement accommodationName;

//    @AndroidFindBy(id = "com.booking:id/toolbar_subtitle_textView")
//    private RemoteWebElement travelDates;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backButton;

    public AccommodationScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean accommodationScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addToSavedButton)).isDisplayed();
    }

    public String getAccommodationNameText() {
        return accommodationName.getText();
    }

//    public String getTravelDatesText() {
//        return travelDates.getText();
//    }

    public void addToSaved() {
        addToSavedButton.click();
    }

    public void tapOnBackButton() {
        backButton.click();
    }
}
