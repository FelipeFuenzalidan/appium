package tests;


import io.appium.java_client.appmanagement.ApplicationState;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.DriverProperties;

public class BaseTest {

    /**
     * Open app if it is closed
     * @throws InterruptedException Exception
     */
    @BeforeMethod
    public void BeforeMethod() throws InterruptedException {
        if (DriverProperties.getAppiumDriver().queryAppState("com.pixelart.odl") !=  (ApplicationState.RUNNING_IN_FOREGROUND)) {
            DriverProperties.getAppiumDriver().launchApp();
            Thread.sleep(5000);
        }
    }

    /**
     * Closed the app
     */
    @AfterMethod(groups = {"SuiteOpenDeviceLab"})
    public void AfterMethod(){
        DriverProperties.getAppiumDriver().closeApp();
    }




}
