package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.DriverProperties;

import java.util.List;

public class FavoriteDeviceLabPage {

    public FavoriteDeviceLabPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverProperties.getAppiumDriver()), this);
    }

    @AndroidFindBy(id = "android:id/action_bar_title")
    private MobileElement titleOpenDevice;

    @AndroidFindBy(id = "com.pixelart.odl:id/menu_not_fav")
    private MobileElement startButton;

    @AndroidFindBy(id = "com.pixelart.odl:id/menu_fav")
    private MobileElement startButtonRemoveFavorites;

    @AndroidFindBy(className = "android.widget.RelativeLayout")
    private MobileElement favoritesDevice;

    @AndroidFindBy(id = "com.pixelart.odl:id/placeholder")
    private MobileElement deviceHelsinki;

    public boolean getTitleOpenDeviceIsPresent() {
        return titleOpenDevice.isDisplayed();
    }

    public void clickStartButton() {
        DriverProperties.waitImplicitMobileElement(30);
        List<MobileElement> mobileElementList = DriverProperties.getAppiumDriver().findElementsByClassName(
                "android.widget.TextView");
        if (mobileElementList.get(11).isDisplayed()) {
            mobileElementList.get(11).click();
        }
    }

    public boolean getFavoritesDeviceIsPresent() {
        DriverProperties.waitForMobileElementIsVisible(30, deviceHelsinki);
        return deviceHelsinki.isDisplayed();
    }

    public boolean getFavoritesDeviceIsNotPresent(){
        DriverProperties.waitForMobileElementIsVisible(30, favoritesDevice);
        return favoritesDevice.isDisplayed();
    }

    public void clickDeviceHelsinki() {
        DriverProperties.waitForMobileElementIsClick(30, deviceHelsinki);
        if (deviceHelsinki.isDisplayed()) {
            deviceHelsinki.click();
        }
    }

    public void clickStartButtonRemoveFavorites() {
        DriverProperties.waitForMobileElementIsClick(30, startButtonRemoveFavorites);
        if (startButtonRemoveFavorites.isDisplayed()) {
            startButtonRemoveFavorites.click();
        }
    }
}
