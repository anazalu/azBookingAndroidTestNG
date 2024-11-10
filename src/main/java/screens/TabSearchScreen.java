package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class TabSearchScreen {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "com.booking:id/facet_index_section_search_view_item")
    private RemoteWebElement searchOptionsContainer;

    @AndroidFindBy(accessibility = "Enter your destination")
    private RemoteWebElement destinationTextField;

    @AndroidFindBy(accessibility = "1 room · 2 adults · 0 children")
    private RemoteWebElement roomsAndGuestsTextField;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(3)")
    private RemoteWebElement searchButton;

    @AndroidFindBy(accessibility = "Search")
    private RemoteWebElement searchTab;

    @AndroidFindBy(accessibility = "Saved")
    private RemoteWebElement savedTab;

    @AndroidFindBy(accessibility = "Sign in")
    private RemoteWebElement signInTab;

    public TabSearchScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean tabSearchScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchOptionsContainer)).isDisplayed();
    }

    public boolean searchTabNotClickable() {
        try {
            new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchTab));
            new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.elementToBeClickable(searchTab));
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public void goToDestinationSelectionScreen() {
        destinationTextField.click();
    }

    public void goToRoomsAndGuestsScreen() {
        roomsAndGuestsTextField.click();
    }

    public void tapOnSearchButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void tapOnSavedTab() {
        savedTab.click();
    }

    public void tapOnSignInTab() {
        signInTab.click();
    }
}
