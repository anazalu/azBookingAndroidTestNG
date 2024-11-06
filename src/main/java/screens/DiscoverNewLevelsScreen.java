package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class DiscoverNewLevelsScreen {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/genius_levels_title")
    private RemoteWebElement discoverNewLevelsScreenText;

    @AndroidFindBy(id = "com.booking:id/action_button")
    private RemoteWebElement gotItButton;

    public DiscoverNewLevelsScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean discoverNewLevelsScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(discoverNewLevelsScreenText)).isDisplayed();
    }

    public void tapGotItButton() {
        gotItButton.click();
    }
}
