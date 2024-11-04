package util;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Helpers {

    public void scrollToElementWithText(AndroidDriver driver, String text) {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0));"));
    }
}
