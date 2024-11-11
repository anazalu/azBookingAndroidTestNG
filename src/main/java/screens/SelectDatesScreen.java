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

public class SelectDatesScreen {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/facet_date_picker_confirm")
    private RemoteWebElement selectDatesButton;

    public SelectDatesScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean selectDatesScreenLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(selectDatesButton)).isDisplayed();
    }

    @Step("Select dates")
    public void selectDates(String startDate, String endDate) {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId(startDate))).click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId(endDate))).click();
    }

    public void tapOnSelectDatesButton() {
        selectDatesButton.click();
    }
}
