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

public class SelectDestinationScreen {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content")
    private RemoteWebElement selectDestinationTextfield;

    public SelectDestinationScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean selectDestinationScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(selectDestinationTextfield)).isDisplayed();
    }

    public void enterDestinationText() {
        selectDestinationTextfield.sendKeys("Skopje");
    }

    public void selectFirstResult() {
        String uiAutomatorExpression = "new UiSelector().className(\"android.view.ViewGroup\").instance(1)";
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(uiAutomatorExpression))).click();
    }
}
