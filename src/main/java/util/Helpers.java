package util;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class Helpers {

    public void scrollToElementWithText(AndroidDriver driver, String text) {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0));"));
    }

//    public void scrollToElementWithId(AndroidDriver driver, String id) {
//        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
//                ".scrollIntoView(new UiSelector().resourceId(\"" + id + "\").instance(0));")).click();
//    }

    public void scrollToElementWithId(AndroidDriver driver, String id) {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                        ".scrollIntoView(new UiSelector().resourceId(\"" + id + "\"));"
        ));
    }

    public static void tapOnCoordinates(AndroidDriver driver, int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(150)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }
}
