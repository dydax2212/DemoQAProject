package Tests;

import HelperMethods.JavaMethods;
import Logger.LoggerUtility;
import ObjectData.PracticeFormObjectData;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.PracticeFormPage;
import ShareDataBrowser.Hooks;
import org.testng.annotations.Test;
import xmlReaderUtility.xmlReader;

import java.util.Map;


public class PracticeFormTest extends Hooks {
    HomePage homePage;
    CommonPage commonPage;
    PracticeFormPage practiceFormPage;
    private Map<String, PracticeFormObjectData> practiceFormObjectDataMap;

    @Test

    public void metodaTest(){
        practiceFormObjectDataMap = xmlReader.loadData("src/test/resources/practiceFormData.xml", PracticeFormObjectData.class);
        PracticeFormObjectData data = practiceFormObjectDataMap.get("dataSet_1");

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());

        homePage.clickOnForms();
        commonPage.clickOnSubmenu("Practice Form");

        practiceFormPage = new PracticeFormPage(getDriver());

        practiceFormPage.fillFirstRegion(data);

        practiceFormPage.selectGenderInPracticeForm(data);
        practiceFormPage.setSubjects(data);

        JavaMethods javaMethods = new JavaMethods(getDriver());
        javaMethods.scrollToXY(0,500);

        practiceFormPage.addAddressStateCity(data);
        practiceFormPage.uploadImage(data);
        LoggerUtility.infoTest("upload image");
        practiceFormPage.selectHobbyInPracticeForm(data);


    }
}
