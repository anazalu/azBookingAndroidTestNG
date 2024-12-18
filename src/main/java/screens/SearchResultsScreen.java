package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class SearchResultsScreen {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/searchbox_destination")
    private RemoteWebElement destinationText;

    @AndroidFindBy(id = "com.booking:id/searchbox_dates")
    private RemoteWebElement datesText;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sort\")")
    private RemoteWebElement sortButtonText;

    public SearchResultsScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean searchResultsScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(sortButtonText)).isDisplayed();
//        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(backButton)).isDisplayed();
    }

    public String getDestinationText() {
        return destinationText.getText();
    }

    public String getDatesText() {
        return datesText.getText();
    }

    @Step("Go to accommodation screen")
    public void goToFirstAccommodationScreen(){
        String elementText = "new UiSelector().className(\"android.view.ViewGroup\").instance(13)";
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(elementText))).click();
    }

    public void tapOnBackButton() {
        backButton.click();
    }
}
