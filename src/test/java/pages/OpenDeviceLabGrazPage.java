package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.ApiDeviceLab;
import utils.DriverProperties;
import utils.Scrolling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpenDeviceLabGrazPage {

    public OpenDeviceLabGrazPage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverProperties.getAppiumDriver()), this);
    }

    @AndroidFindBy(id = "com.pixelart.odl:id/details_num_devices")
    private MobileElement txtNumDevice;

    @AndroidFindBy(id = "com.pixelart.odl:id/brands_spinner")
    private MobileElement ddlAvailableBrands;

    @AndroidFindBy(id = "com.pixelart.odl:id/details_country")
    private  MobileElement txtCountry;


    public int getTextNumDevive() {
        return Integer.parseInt(txtNumDevice.getText());
    }

    public void clickAvailableBrands() {
        ddlAvailableBrands.click();
    }

    public ArrayList<String> getApiAvailableBrandsOption() {
        String apiAvailableBrandsOption = ApiDeviceLab.getValueOfKeyResponse("?id=166", "brands_available").
                replaceAll("[\\[\\]]", "");

        return new ArrayList(Arrays.asList(apiAvailableBrandsOption.split(", ")));

    }

    public ArrayList<String> getAvailableBrandsOption() {
        List<MobileElement> listAvailableBrandsOption = DriverProperties.getAppiumDriver().
                findElementsById("android:id/text1");

        ArrayList<String> newListAvailableBrandsOption = new ArrayList();

        for (int i=0; i<listAvailableBrandsOption.size(); i++){

            newListAvailableBrandsOption.add(listAvailableBrandsOption.get(i).getText());
        }

        return newListAvailableBrandsOption;

    }

    public void clickOptionAvailableBrands(String AvailableBrands){
        DriverProperties.getAppiumDriver().findElementByXPath("//android.widget.CheckedTextView[@text='"
                + AvailableBrands + "']").click();
    }

    public String getCountryText() {
        String textCountry = null;

        Scrolling.scrollDown();

        if (txtCountry.isDisplayed()){

            textCountry = txtCountry.getText();
        }

        return textCountry;
    }

    private List<MobileElement> getListOptionOpenDeviceLabGraz(String optionName) {
        DriverProperties.waitImplicitMobileElement(30);
        return DriverProperties.getAppiumDriver().findElementsByXPath(
                "//android.widget.TextView[@text='" + optionName+ "']");
    }

    public void clickOptionOptionOpenDeviceLabGraz(String optionName) {
        DriverProperties.waitImplicitMobileElement(30);
        while (getListOptionOpenDeviceLabGraz(optionName).size() == 0) {
            Scrolling.scrollRight();
        }
        if (getListOptionOpenDeviceLabGraz(optionName).size() > 0) {
            DriverProperties.waitForMobileElementIsVisible(30, getListOptionOpenDeviceLabGraz(optionName).get(0));
            getListOptionOpenDeviceLabGraz(optionName).get(0).isEnabled();
            getListOptionOpenDeviceLabGraz(optionName).get(0).click();
        }
    }

}
