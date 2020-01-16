package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.DriverProperties;
import utils.Scrolling;

import java.util.List;

public class AboutOpenDeviceLabPage {

    public AboutOpenDeviceLabPage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverProperties.getAppiumDriver()), this);
    }

    @AndroidBy(className = "android.view.View")
    private MobileElement titleAboutOpenDeviceLab;


    public String getActivity() {
        return DriverProperties.getAppiumDriver().currentActivity();
    }

    private List<MobileElement> listTitleAboutOpenDevice(String title){
        DriverProperties.waitImplicitMobileElement(30);
        return DriverProperties.getAppiumDriver().findElementsByXPath("//android.view.View[@text='"
                + title + "']");
    }

    private List<MobileElement> listIconFooterOpenDevice(String iconName){
        DriverProperties.waitImplicitMobileElement(30);
        return DriverProperties.getAppiumDriver().findElementsByXPath("//android.view.View[@text='"
                + iconName + "']");
    }

    public boolean getTitleAboutOpenDeviceLabIsPresent(String deviceName){
        boolean title = false;
        while(listTitleAboutOpenDevice(deviceName).size() == 0) {
            Scrolling.scrollDown();
        }
        if(listTitleAboutOpenDevice(deviceName).size() > 0) {
            listTitleAboutOpenDevice(deviceName).get(0).isDisplayed();
            title = true;
        }
        return title;
    }

    public void clickIconFooterName(String iconName) {
        while(listTitleAboutOpenDevice(iconName).size() == 0) {
            Scrolling.scrollDown();
        }
        if (listIconFooterOpenDevice(iconName).get(0).isDisplayed()) {
            listIconFooterOpenDevice(iconName).get(0).click();
        }
    }

    public void changedContext(String context) {
        DriverProperties.getAppiumDriver().context(context);
    }

    public String getUrlBrowser() {
        return DriverProperties.getAppiumDriver().getCurrentUrl();
    }
}
