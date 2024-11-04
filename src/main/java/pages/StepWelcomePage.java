package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class StepWelcomePage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/gdpr_consent_description_scroll_view")
    private RemoteWebElement stepWelcomePageContainer;

    @AndroidFindBy(id = "com.booking:id/bt_accept")
    private RemoteWebElement acceptButton;

    public StepWelcomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean stepWelcomePageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(stepWelcomePageContainer)).isDisplayed();
    }

    public void clickAcceptButton() {
        acceptButton.click();
    }
}
