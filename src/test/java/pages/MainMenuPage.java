package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.DriverProperties;

public class MainMenuPage {

    public MainMenuPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverProperties.getAppiumDriver()), this);
    }

    @AndroidFindBy(id = "android:id/up")
    private MobileElement mainMenu;


    public void clickMainMenu() {
        DriverProperties.waitImplicitMobileElement(30);
        mainMenu.click();
    }

    public void clickOptionDeviceMainMenu(String option) {
        DriverProperties.waitForMobileElementIsVisible(30, (MobileElement) DriverProperties.getAppiumDriver().findElementByXPath(
                "//android.widget.TextView[@text='" + option + "']"));
        DriverProperties.getAppiumDriver().findElementByXPath(
                "//android.widget.TextView[@text='" + option + "']").click();
    }
}
