package Tests;

import Pages.BrowserWindowsPage;
import Pages.CommonPage;
import Pages.HomePage;
import ShareDataBrowser.Hooks;
import ShareDataBrowser.ShareData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserWindows extends Hooks {

        HomePage homePage;
        CommonPage commonPage;
        BrowserWindowsPage browserWindowsPage;

        @Test
        public void metodaTest() {
//
            homePage = new HomePage(getDriver());
            commonPage = new CommonPage(getDriver());
            browserWindowsPage = new BrowserWindowsPage(getDriver());

            homePage.clickOnAlert();
            commonPage.clickOnSubmenu("Browser Windows");

            browserWindowsPage.dealWithNewTab();
            browserWindowsPage.switchToNewTab(1);
            Assert.assertEquals(browserWindowsPage.getOutSampleHeadingText(), "This is a sample page");

            getDriver().close();

            browserWindowsPage.swithToFirstTab();
            browserWindowsPage.dealWithNewWindow();
            browserWindowsPage.swithToLastTab();
            Assert.assertEquals(browserWindowsPage.getOutSampleHeadingText(), "This is a sample page");

            getDriver().close();
            browserWindowsPage.swithToFirstTab();
            getDriver().close();



    }
}
