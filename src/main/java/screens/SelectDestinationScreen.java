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

//    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(1)")
//    private RemoteWebElement firstSearchResult;

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

//    public boolean firstSearchResultLoaded() {
//        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(firstSearchResult)).isDisplayed();
//    }

    public void selectFirstResult() {
        String uiAutomatorExpression = "new UiSelector().className(\"android.view.ViewGroup\").instance(1)";
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorExpression));
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(element)).click();
    }
}
