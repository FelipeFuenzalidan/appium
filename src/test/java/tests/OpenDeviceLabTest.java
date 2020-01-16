package tests;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ApiDeviceLab;
import utils.DriverProperties;


public class OpenDeviceLabTest extends BaseTest {

    //Variable for the class
    private HomeOpenDeviceLabPage home = new HomeOpenDeviceLabPage();
    private OpenDeviceLabGrazPage labGrazDevice = new OpenDeviceLabGrazPage();
    private HelsinkiOpenDeviceLabPage helsinkiDevice = new HelsinkiOpenDeviceLabPage();
    private MainMenuPage mainMenu = new MainMenuPage();
    private SearchCountry searchCountry =new SearchCountry();
    private AboutOpenDeviceLabPage aboutOpenDeviceLabPage = new AboutOpenDeviceLabPage();
    private FavoriteDeviceLabPage favoriteDeviceLab = new FavoriteDeviceLabPage();
    private CommentsPage comments = new CommentsPage();

    /**
     * Exercise one from the exam, "Open Device Lab Graz" device is used for the exercise
     */
    @Test (groups = {"SuiteOpenDeviceLab"})
    public void HomeScreenTest() {
        Assert.assertEquals(home.getTitleHome(), "There're 149 ODL's and 3813 devices in 24 countries");
        Assert.assertTrue(home.getDeviceNameDisplayed("Open Device Lab Graz"));
        home.clickDeviceName("Open Device Lab Graz");
        Assert.assertNotNull(home.getActivity());
        Assert.assertTrue(labGrazDevice.getTextNumDevive() >=  0);
        labGrazDevice.clickAvailableBrands();
        Assert.assertNotNull(ApiDeviceLab.getValueOfKeyResponse("?id=166", "brands_available"));
        Assert.assertEquals(labGrazDevice.getApiAvailableBrandsOption(), labGrazDevice.getAvailableBrandsOption());
        labGrazDevice.clickOptionAvailableBrands("HTC");
        Assert.assertEquals(labGrazDevice.getCountryText(), "Austria");
    }

    @Test (groups = "SuiteOpenDeviceLab")
    public void DeviceLabDetailScreen(){
        Assert.assertTrue(home.getDeviceNameDisplayed("Helsinki Open Device Lab"));
        home.clickDeviceName("Helsinki Open Device Lab");
        Assert.assertTrue(helsinkiDevice.getTitleHelsinkiDeviceLoaded());
        Assert.assertTrue(helsinkiDevice.getGeneralInfoSectionIsPresent());
        Assert.assertTrue(helsinkiDevice.getDeviceSectionIsPresent());
        Assert.assertTrue(helsinkiDevice.getAddressSectionIsPresent());
        Assert.assertTrue(helsinkiDevice.getLinkSectionIsPresent());
        Assert.assertNotNull(helsinkiDevice.getTextCountryAddress());
        helsinkiDevice.clickOptionHelsinkiDevice("Map");
        Assert.assertTrue(helsinkiDevice.getGoogleMapIsLoaded());
    }

    @Test (groups = "SuiteOpenDeviceLab")
    public void SearchByCountry() {
        mainMenu.clickMainMenu();
        mainMenu.clickOptionDeviceMainMenu("Search by Country");
        searchCountry.clickDdlCountry();
        Assert.assertFalse(searchCountry.getDdlCountryOptionIsPresent("Bolivia"));
        searchCountry.clickDdlCountryOption("Spain");
        searchCountry.clickSearchButton();
         Assert.assertTrue(searchCountry.getTitleSpainDeviceIsPresent());
         Assert.assertEquals(searchCountry.getTextTitleSpainDevice(), "3 ODL's found");
    }

    @Test (groups = "SuiteOpenDeviceLab")
    public void AboutOpenDeviceLab() throws InterruptedException {
        mainMenu.clickMainMenu();
        mainMenu.clickOptionDeviceMainMenu("About the Open Device Lab");
        Assert.assertNotNull(aboutOpenDeviceLabPage.getActivity());
        Assert.assertTrue(aboutOpenDeviceLabPage.getTitleAboutOpenDeviceLabIsPresent(
                "What is an \"Open Device Lab\"?"));
        Assert.assertTrue(aboutOpenDeviceLabPage.getTitleAboutOpenDeviceLabIsPresent("How to contribute"));
        Assert.assertTrue(aboutOpenDeviceLabPage.getTitleAboutOpenDeviceLabIsPresent("Wanna sponsor?"));
        aboutOpenDeviceLabPage.clickIconFooterName("tw");
        aboutOpenDeviceLabPage.changedContext("WEBVIEW_chrome");
        Thread.sleep(3000);
        Assert.assertTrue(aboutOpenDeviceLabPage.getUrlBrowser().contains("twitter"));
    }

    @Test(groups = "removeFavoritesDevice")
    public void FavoriteDeviceLab() throws InterruptedException {
        mainMenu.clickMainMenu();
        mainMenu.clickOptionDeviceMainMenu("Favorites");
        favoriteDeviceLab.getFavoritesDeviceIsNotPresent();
        mainMenu.clickMainMenu();
        mainMenu.clickOptionDeviceMainMenu("All ODLs");
        Assert.assertTrue(favoriteDeviceLab.getTitleOpenDeviceIsPresent());
        home.clickDeviceName("Helsinki Open Device Lab");
        Thread.sleep(2000);
        Assert.assertTrue(helsinkiDevice.getTitleHelsinkiDeviceLoaded());
        helsinkiDevice.clickOptionHelsinkiDevice("Comments");
        Thread.sleep(3000);
        favoriteDeviceLab.clickStartButton();
        DriverProperties.getAppiumDriver().pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(2000);
        Assert.assertTrue(favoriteDeviceLab.getTitleOpenDeviceIsPresent());
        mainMenu.clickMainMenu();
        mainMenu.clickOptionDeviceMainMenu("Favorites");
        Thread.sleep(4000);
        Assert.assertTrue(favoriteDeviceLab.getFavoritesDeviceIsPresent(), "Device is not displayed");
        mainMenu.clickMainMenu();
        mainMenu.clickOptionDeviceMainMenu("Favorites");
        favoriteDeviceLab.clickDeviceHelsinki();
        favoriteDeviceLab.clickStartButtonRemoveFavorites();
        DriverProperties.getAppiumDriver().closeApp();
    }

    @Test (groups = "SuiteOpenDeviceLab")
    public void CommentDevice() {
        Assert.assertTrue(home.getDeviceNameDisplayed("Open Device Lab Graz"));
        home.clickDeviceName("Open Device Lab Graz");
        labGrazDevice.clickOptionOptionOpenDeviceLabGraz("Comments");
        labGrazDevice.clickOptionOptionOpenDeviceLabGraz("New Comments");
        Assert.assertTrue(comments.getFieldNameIsMandatory());
        comments.setSendKeysNameField("Test Appium");
        Assert.assertTrue(comments.getFieldEmailIsMandatory());
        comments.setSendKeysEmailField("appium@globant.com");
        Assert.assertTrue(comments.getEmailAddressIsCorrect());

    }
}
