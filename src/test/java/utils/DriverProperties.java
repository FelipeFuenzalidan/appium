package utils;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverProperties {

    private static AndroidDriver driver;

    /**
     * This method allows driver loading.
     */
    private static void loadDriver(){

        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "APPIUM");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
            caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") +
                    "/src/main/resources/Open_Device_Lab.apk");
            caps.setCapability(MobileCapabilityType.NO_RESET, true);
            caps.setCapability(MobileCapabilityType.FULL_RESET, false);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(url, caps);
            Thread.sleep(5000);
        }
        catch (Exception ex){
            System.out.println("Cause is: " + ex.getCause());
            System.out.println("Message is: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * This method allows get driver.
     * @return driver
     */
    public static AndroidDriver getAppiumDriver(){
        if (driver == null){
            loadDriver();
        }
        return driver;
    }

    /**
     * Wait implicit to the mobile element.
     * @param time wait time
     */
    public static void waitImplicitMobileElement(int time) {
        DriverProperties.getAppiumDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    /**
     * Wait explicit can it click to the mobile element.
     * @param time wait time
     * @param element mobile element
     */
    public static void waitForMobileElementIsClick(int time, MobileElement element) {
        WebDriverWait wait = new WebDriverWait(getAppiumDriver(), time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait explicit is visible to the mobile element.
     * @param time wait time
     * @param element mobile element
     */
    public static void waitForMobileElementIsVisible(int time, MobileElement element) {
        WebDriverWait wait = new WebDriverWait(getAppiumDriver(), time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
