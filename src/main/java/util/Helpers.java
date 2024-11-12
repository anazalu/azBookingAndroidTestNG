package util;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.time.Duration.ZERO;
import static java.time.Duration.ofSeconds;

import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class Helpers {

    public enum Directions {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private final PointerInput FINGER = new PointerInput(TOUCH, "finger");

    public void swipeVertically(AndroidDriver driver, Directions directions) {
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;

        int endY;

        switch (directions) {
            case UP -> endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);
            case DOWN -> endY = (int) (driver.manage().window().getSize().getHeight() * 0.8);
            default -> throw new IllegalArgumentException("Invalid direction selected:" + directions);
        }

        Sequence swipe = new Sequence(FINGER, 0);
        swipe.addAction(FINGER.createPointerMove(ZERO, viewport(), startX, startY));
        swipe.addAction(FINGER.createPointerDown(LEFT.asArg()));
        swipe.addAction(FINGER.createPointerMove(ofSeconds(1), viewport(), startX, endY));
        swipe.addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(List.of(swipe));
    }

    public void scrollTo(AndroidDriver driver, WebElement element, Directions directions, int swipeCount) {
        IntStream.range(0, swipeCount).forEach(obj -> {
            System.out.println("Swiping...");
            try {
                if (!element.isDisplayed()) {
                    System.out.println("Element not visible");
                }
            } catch (NoSuchElementException e) {
                swipeVertically(driver, directions);
                System.out.println("Exception");
            }
        });
    }

    // WIP ===============================
    public void swipeHorizontally(AndroidDriver driver, Directions directions) {
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = (int) (driver.manage().window().getSize().getHeight() * 0.75 );

        int endX;

        switch (directions) {
            case LEFT -> endX = (int) (driver.manage().window().getSize().getWidth() * 0.2);
            case RIGHT -> endX = (int) (driver.manage().window().getSize().getWidth() * 0.8);
            default -> throw new IllegalArgumentException("Invalid direction selected:" + directions);
        }

        Sequence swipe = new Sequence(FINGER, 0);
        swipe.addAction(FINGER.createPointerMove(ZERO, viewport(), startX, startY));
        swipe.addAction(FINGER.createPointerDown(LEFT.asArg()));
        swipe.addAction(FINGER.createPointerMove(ofSeconds(1), viewport(), endX, startY));
        swipe.addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(List.of(swipe));
    }

    // WIP ===============================
    public void scrollHorizontallyTo(AndroidDriver driver, WebElement element, Directions directions, int swipeCount) {
        IntStream.range(0, swipeCount).forEach(obj -> {
            System.out.println("Swiping... " + directions.toString());
            try {
                if (!element.isDisplayed()) {
                    System.out.println("Element not visible");
                }
            } catch (NoSuchElementException e) {
                swipeHorizontally(driver, directions);
                System.out.println("Scrolling " + directions.toString());
            }
        });
    }

    public static void tapOnCoordinates(AndroidDriver driver, int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(ZERO, viewport(), x, y))
                .addAction(finger.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(250)))
                .addAction(finger.createPointerUp(LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }
}
