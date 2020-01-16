package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.DriverProperties;
import utils.Scrolling;

import java.util.List;

public class HomeOpenDeviceLabPage {

    public HomeOpenDeviceLabPage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverProperties.getAppiumDriver()), this);
    }

    @AndroidFindBy(id = "com.pixelart.odl:id/textView1")
    private MobileElement tituloHome_1;

    @AndroidFindBy(id = "com.pixelart.odl:id/h_id")
    private MobileElement tituloHome_2;

    @AndroidFindBy(id = "com.pixelart.odl:id/textView3")
    private MobileElement tituloHome_3;

    @AndroidFindBy(id = "com.pixelart.odl:id/h_dev")
    private MobileElement tituloHome_4;

    @AndroidFindBy(id = "com.pixelart.odl:id/textView5")
    private MobileElement tituloHome_5;

    @AndroidFindBy(id = "com.pixelart.odl:id/h_coun")
    private MobileElement tituloHome_6;

    @AndroidFindBy(id = "com.pixelart.odl:id/textView7")
    private MobileElement tituloHome_7;


    public String getTitleHome(){
        return tituloHome_1.getText() + " " + tituloHome_2.getText() + " " + tituloHome_3.getText()
                + " " + tituloHome_4.getText() + " " + tituloHome_5.getText() + " " + tituloHome_6.getText() + " " +
                tituloHome_7.getText();
    }

    private List<MobileElement> listDeviceName(String deviceName){
        DriverProperties.waitImplicitMobileElement(30);
        return DriverProperties.getAppiumDriver().findElementsByXPath("//android.widget.TextView[@text='"
                + deviceName + "']");
    }

    public boolean getDeviceNameDisplayed(String deviceName){
        boolean device = false;
        DriverProperties.waitImplicitMobileElement(30);
        while(listDeviceName(deviceName).size() == 0) {
            Scrolling.scrollDown();
        }
        if(listDeviceName(deviceName).size() > 0) {
            listDeviceName(deviceName).get(0).isDisplayed();
            device = true;
        }
        return device;
    }

    public void clickDeviceName(String deviceName) {
        DriverProperties.waitImplicitMobileElement(30);
        while(listDeviceName(deviceName).size() == 0) {
            Scrolling.scrollDown();
        }
        if(listDeviceName(deviceName).size() > 0) {
            listDeviceName(deviceName).get(0).click();
        }
    }

    public String getActivity() {
        return DriverProperties.getAppiumDriver().currentActivity();
    }
}
