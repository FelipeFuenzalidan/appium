package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class Scrolling {

    //Variable for the class
    private  static TouchAction action = new TouchAction(DriverProperties.getAppiumDriver());
    private static Double screenHeightStart;
    private static Double screenHeightEnd;
    private static Double screenWidthStart;
    private static Double screenWidthEnd;
    private static int scrollStart;
    private static int scrollEnd;
    private static  Dimension dimensions;


    /**
     * Simulate scroll down in the device
     */
    public static void scrollDown() {
        dimensions = DriverProperties.getAppiumDriver().manage().window().getSize();
        screenHeightStart = (dimensions.getHeight() * 0.5);
        scrollStart = screenHeightStart.intValue();
        screenHeightEnd = dimensions.getHeight() * 0.2;
        scrollEnd = screenHeightEnd.intValue();
        action.press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }

    /**
     * Simulate scroll up in the device
     */
    public static void scrollUp() {
        dimensions = DriverProperties.getAppiumDriver().manage().window().getSize();
        screenHeightStart = dimensions.getHeight() * 0.5;
        int scrollStart = screenHeightStart.intValue();
        screenHeightEnd = dimensions.getHeight() * 0.2;
        int scrollEnd = screenHeightEnd.intValue();

        action.press(PointOption.point(0, scrollEnd))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollStart))
                .release().perform();
    }

    /**
     * Simulate scroll right in the device
     */
    public static void scrollRight() {
        dimensions = DriverProperties.getAppiumDriver().manage().window().getSize();
        screenWidthStart = dimensions.getWidth() * 0.5;
        scrollStart = screenWidthStart.intValue();
        screenWidthEnd = dimensions.getWidth() * 0.2;
        scrollEnd = screenWidthEnd.intValue();

        action.press(PointOption.point(scrollStart, 0))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(scrollEnd, 0))
                .release().perform();


    }

    /**
     * Simulate scroll left in the device
     */
    public static void scrollLeft() {
        dimensions = DriverProperties.getAppiumDriver().manage().window().getSize();
        screenWidthStart = dimensions.getWidth() * 0.5;
        scrollStart = screenWidthStart.intValue();
        screenWidthEnd = dimensions.getHeight() * 0.2;
        scrollEnd = screenWidthEnd.intValue();

        action.press(PointOption.point(0, scrollEnd))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollStart))
                .release().perform();


    }
}
