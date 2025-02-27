package Tests;

import HelperMethods.JavaMethods;
import ObjectData.TextboxTableObjectData;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.TextboxPage;
import ShareDataBrowser.Hooks;
import ShareDataBrowser.ShareData;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import xmlReaderUtility.xmlReader;

import java.util.Map;

public class TextboxTest extends Hooks {

    HomePage homePage;
    CommonPage commonPage;
    TextboxPage textboxPage;
    JavaMethods javaMethods;
    private Map<String, TextboxTableObjectData> textboxTableObjectDataMap;

    @Test
    public void methodTest() {
        textboxTableObjectDataMap = xmlReader.loadData("src/test/resources/textboxData.xml", TextboxTableObjectData.class);
        TextboxTableObjectData  data = textboxTableObjectDataMap.get("dataSet_1");


        javaMethods = new JavaMethods(getDriver());
        javaMethods.scrollToXY(0,500);

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        textboxPage = new TextboxPage(getDriver());

        homePage.clickOnElements();
        commonPage.clickOnSubmenu("Text Box");

        textboxPage.fillData(data);
        javaMethods.scrollToXY(0,800);
        textboxPage.clickOnSubmit();

        Assert.assertTrue(textboxPage.getOutName().contains(data.getName()));
        Assert.assertTrue(textboxPage.getOutEmail().contains(data.getEmail()));
        Assert.assertTrue(textboxPage.getOutCurrentAddress().contains(data.getCurrentAddress()));
        Assert.assertTrue(textboxPage.getOutPermanentAddress().contains(data.getPermanentAddress()));

    }

    @Test
    public void methodTest2() {
        textboxTableObjectDataMap = xmlReader.loadData("src/test/resources/textboxData.xml", TextboxTableObjectData.class);
        TextboxTableObjectData  data = textboxTableObjectDataMap.get("dataSet_2");

//        String name = "Stefania";
//        String email = "stefania.munteanu@gmail.com";
//        String currentAddress = "Nicolae Labis 1, Brasov";
//        String permanentAddress = "Nicolae Labis 1, Brasov, Romania";

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("window.scrollTo(0,500)");

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        textboxPage = new TextboxPage(getDriver());

        homePage.clickOnElements();
        commonPage.clickOnSubmenu("Text Box");

        textboxPage.typeUserName(data);
        textboxPage.typeUserEmail(data);
        textboxPage.typeUserCurrentAddress(data);
        textboxPage.typeUserPermanentAddress(data);

        javascriptExecutor.executeScript("window.scrollTo(0,800)");

        textboxPage.clickOnSubmit();

        Assert.assertTrue(textboxPage.getOutName().contains(data.getName()));
        Assert.assertTrue(textboxPage.getOutEmail().contains(data.getEmail()));
        Assert.assertTrue(textboxPage.getOutCurrentAddress().contains(data.getCurrentAddress()));
        Assert.assertTrue(textboxPage.getOutPermanentAddress().contains(data.getPermanentAddress()));

        //  driver.close();
    }
}
