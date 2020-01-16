package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.DriverProperties;

import java.util.ArrayList;
import java.util.List;

public class SearchCountry {

    public SearchCountry() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverProperties.getAppiumDriver()), this);
    }

    @AndroidFindBy(id = "com.pixelart.odl:id/spinnercountry")
    private MobileElement ddlCountry;

    @AndroidFindBy(id = "com.pixelart.odl:id/btn_search")
    private MobileElement searchButton;

    @AndroidFindBy(id = "com.pixelart.odl:id/tvresult")
    private MobileElement titleSpainDevice;


    public void clickDdlCountry() {
        DriverProperties.waitForMobileElementIsClick(30, ddlCountry);
        ddlCountry.click();
    }

    private ArrayList<String> getDdlCountryOption() {
        DriverProperties.waitImplicitMobileElement(30);
        List<MobileElement> listCountryOption = DriverProperties.getAppiumDriver().
                findElementsById("android:id/text1");
        ArrayList<String> newListAvailableBrandsOption = new ArrayList<String>();
        for (MobileElement element : listCountryOption) {
            newListAvailableBrandsOption.add(element.getText());
        }
        return newListAvailableBrandsOption;
    }

    public boolean getDdlCountryOptionIsPresent(String valueOption) {
        return getDdlCountryOption().stream().anyMatch(valueOption::equals);
    }

    public void clickDdlCountryOption(String valueOption) {
        DriverProperties.getAppiumDriver().findElementByXPath(
                "//android.widget.CheckedTextView[@text='Germany']").click();
        DriverProperties.waitImplicitMobileElement(20);
        ddlCountry.click();
        MobileElement element = (MobileElement) DriverProperties.getAppiumDriver().findElementByXPath(
                "//android.widget.CheckedTextView[@text='" + valueOption + "']");
        DriverProperties.waitImplicitMobileElement(40);
        if (element.isDisplayed()){
            element.click();
        }
    }

    public void clickSearchButton() {
        DriverProperties.waitForMobileElementIsClick(30, searchButton);
        if (searchButton.isDisplayed()) {
            searchButton.click();
        }
    }

    public boolean getTitleSpainDeviceIsPresent() {
        DriverProperties.waitForMobileElementIsClick(30, titleSpainDevice);
        return titleSpainDevice.isDisplayed();
    }

    public String getTextTitleSpainDevice() {
        DriverProperties.waitForMobileElementIsVisible(30, titleSpainDevice);
        return titleSpainDevice.getText();
    }
}
