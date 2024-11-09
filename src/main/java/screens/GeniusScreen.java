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

public class GeniusScreen extends Helpers {
    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/genius_value_title")
    private RemoteWebElement geniusScreenInitialViewTitle;

    @AndroidFindBy(id = "com.booking:id/activity_genius_info_title")
    private RemoteWebElement geniusScreenRepeatedViewTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/benefit_root_view\").instance(0)")
    private RemoteWebElement geniusLevel1Button;

    @AndroidFindBy(id = "com.booking:id/genius_see_all_levels")
    private RemoteWebElement aboutGeniusLevelsButton;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backButton;

    public GeniusScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean geniusScreenInitialViewTitleLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(geniusScreenInitialViewTitle)).isDisplayed();
    }

    public boolean geniusScreenRepeatedViewTitleLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(geniusScreenRepeatedViewTitle)).isDisplayed();
    }

    public void tapOnAboutGeniusLevelsButton() {
//        scrollToElementWithText(driver, "About Genius Levels");
//        scrollToElementWithTextOPTION(driver, "About Genius Levels");
        scrollToElementByUIAuto(driver);
        aboutGeniusLevelsButton.click();
    }

//    WIP swipe to level 3

    public void tapOnBackButton() {
        backButton.click();
    }
}
