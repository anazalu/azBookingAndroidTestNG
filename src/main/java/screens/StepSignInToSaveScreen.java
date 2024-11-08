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

public class StepSignInToSaveScreen extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/facet_with_bottom_sheet_header_drag_line")
    private RemoteWebElement stepSignInToSaveScreenTopBar;

    public StepSignInToSaveScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean stepSignInToSaveScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(stepSignInToSaveScreenTopBar)).isDisplayed();
    }

    public void tapOutOfSignInToSaveScreen() {
//        tapOnCoordinates(driver, 50, 100);
        int coordX = (int) Math.round(driver.manage().window().getSize().getWidth() * 0.05);
        int coordY = (int) Math.round(driver.manage().window().getSize().getHeight() * 0.05);
        tapOnCoordinates(driver, coordX, coordY);
    }
}
