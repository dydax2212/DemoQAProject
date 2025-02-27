package Tests;

import HelperMethods.JavaMethods;
import Pages.HomePage;
import Pages.MenuPage;
import ShareDataBrowser.Hooks;
import ShareDataBrowser.ShareData;
import org.testng.annotations.Test;

public class MenuTest extends Hooks {

    HomePage homePage;
    MenuPage menuPage;

    @Test
    public void metodaTest() {

        homePage = new HomePage(getDriver());
        menuPage = new MenuPage(getDriver());
        homePage.clickOnWidgets();

        JavaMethods javaMethods = new JavaMethods(getDriver());
        javaMethods.scrollToXY(0,500);
       menuPage.clickOnWidgetsFromList(7);
        menuPage.clickOnMenu();
        menuPage.clickOnMenuSublist();
        menuPage.clickOnMenuSubItem();

    }
}
