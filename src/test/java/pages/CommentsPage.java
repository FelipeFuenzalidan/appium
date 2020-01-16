package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.DriverProperties;

public class CommentsPage {

    public CommentsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverProperties.getAppiumDriver()), this);
    }

    @AndroidFindBy(id = "com.pixelart.odl:id/etSendIt")
    private MobileElement sendButton;

    @AndroidFindBy(id = "com.pixelart.odl:id/etName")
    private MobileElement nameText;

    @AndroidFindBy(id = "com.pixelart.odl:id/etMail")
    private MobileElement emailText;

    public boolean getFieldNameIsMandatory() {
        DriverProperties.waitForMobileElementIsClick(30, sendButton);
        return nameText.getText().equals("your Name");
    }

    public void setSendKeysNameField(String text) {
        DriverProperties.waitForMobileElementIsVisible(30, nameText);
        nameText.sendKeys(text);
    }

    public boolean getFieldEmailIsMandatory() {
        DriverProperties.waitForMobileElementIsClick(30, sendButton);
        return  emailText.getText().equals("your eMail");
    }

    public void setSendKeysEmailField(String text) {
        DriverProperties.waitForMobileElementIsVisible(30, nameText);
        emailText.sendKeys(text);
    }

    public boolean getEmailAddressIsCorrect() {
        return emailText.getText().contains("@");
    }
}
