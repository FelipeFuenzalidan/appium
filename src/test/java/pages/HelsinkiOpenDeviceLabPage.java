package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.DriverProperties;
import utils.Scrolling;

import java.util.List;

public class HelsinkiOpenDeviceLabPage {

    public HelsinkiOpenDeviceLabPage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverProperties.getAppiumDriver()), this);
    }

    @AndroidFindBy(id = "android:id/action_bar_title")
    private MobileElement titleHelsinkiDevice;

    @AndroidFindBy(id = "com.pixelart.odl:id/container_general")
    private MobileElement generalInfoSection;

    @AndroidFindBy(id = "com.pixelart.odl:id/container_devices")
    private MobileElement deviceSection;

    @AndroidFindBy(id = "com.pixelart.odl:id/container_location")
    private MobileElement addressSection;

    @AndroidFindBy(id = "com.pixelart.odl:id/container_links")
    private MobileElement linkSection;

    @AndroidFindBy(id = "com.pixelart.odl:id/details_organization")
    private MobileElement countryAddress;

    @AndroidFindBy(className = "android.widget.RelativeLayout")
    private  MobileElement googleMapHelsinkiDevice;


    public boolean getTitleHelsinkiDeviceLoaded(){
        DriverProperties.waitForMobileElementIsVisible(30, titleHelsinkiDevice);
        return titleHelsinkiDevice.isEnabled();
    }

    public boolean getGeneralInfoSectionIsPresent() {
        DriverProperties.waitForMobileElementIsVisible(30, generalInfoSection);
        return generalInfoSection.isDisplayed();
    }

    public boolean getDeviceSectionIsPresent() {
        DriverProperties.waitForMobileElementIsVisible(30, deviceSection);
        return deviceSection.isDisplayed();
    }

    public boolean getAddressSectionIsPresent() {
        DriverProperties.waitForMobileElementIsVisible(30, addressSection);
        return addressSection.isDisplayed();
    }

    public boolean getLinkSectionIsPresent() {
        Scrolling.scrollDown();
        DriverProperties.waitForMobileElementIsVisible(30, linkSection);
        return linkSection.isDisplayed();
    }

    public String getTextCountryAddress() {
        DriverProperties.waitForMobileElementIsVisible(30, countryAddress);
        return countryAddress.getText();
    }

    public void clickOptionHelsinkiDevice (String nameOption) {
        DriverProperties.waitImplicitMobileElement(30);
        List<MobileElement> listOpbtion = DriverProperties.getAppiumDriver().findElementsByXPath(
                "//android.widget.TextView[@text='" + nameOption+ "']");
        if (listOpbtion.get(0).isDisplayed()) {
            listOpbtion.get(0).click();
        }
    }

    public boolean getGoogleMapIsLoaded() {
        DriverProperties.waitForMobileElementIsVisible(30, googleMapHelsinkiDevice);
        return googleMapHelsinkiDevice.isDisplayed();
    }
}
