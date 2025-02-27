package Tests;

import Logger.LoggerUtility;
import Pages.AlertsPage;
import Pages.CommonPage;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import ShareDataBrowser.ShareData;
import org.testng.annotations.Test;

public class AlertTest extends Hooks {

    HomePage homePage;
    CommonPage commonPage;
    AlertsPage alertsPage;

    @Test
    public void metodaTest() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        alertsPage = new AlertsPage(getDriver());

        homePage.clickOnAlert();
        LoggerUtility.infoTest("The user click on alert cart.");
        commonPage.clickOnSubmenu("Alerts");
        LoggerUtility.infoTest("Alerts submenu");

        alertsPage.dealWithAlertOk();
        LoggerUtility.infoTest("dealWithAlertOk");
        alertsPage.dealWithAlertDelay();
        LoggerUtility.infoTest("dealWithAlertDelay");
        alertsPage.dealWithAlertConfirm();
        LoggerUtility.infoTest("dealWithAlertConfirm");
        alertsPage.dealWithAlertPrompt("Stefi");
        LoggerUtility.infoTest("dealWithAlertPrompt");

    }
}
