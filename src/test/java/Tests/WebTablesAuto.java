package Tests;

import HelperMethods.JavaMethods;
import InputsTest.WebTablesInputsTest;
import Pages.HomePage;
import Pages.WebTablesAutoPage;
import ShareDataBrowser.Hooks;
import ShareDataBrowser.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablesAuto extends Hooks {

    HomePage homePage;
    WebTablesAutoPage webTablesAutoPage;

    @Test
    public void methodTest() {

        JavaMethods javaMethods = new JavaMethods(getDriver());
        javaMethods.scrollToXY(0,500);

        homePage = new HomePage(getDriver());
        webTablesAutoPage = new WebTablesAutoPage(getDriver());

        homePage.clickOnElements();
        webTablesAutoPage.clickOnWebTables();;

        WebTablesInputsTest input1 = new WebTablesInputsTest("Stefania", "Munteanu", "aaa.bbb@gmail.com", "33", "1500", "DEV");
        createNewRowInTable(input1);
        checkNewRowInTable(input1, webTablesAutoPage.getNumberElementsInTable());

        WebTablesInputsTest input2 = new WebTablesInputsTest("Vlad", "Munteanu", "aaa11.bbb@gmail.com", "25", "1700", "OPS");
        createNewRowInTable(input2);
        checkNewRowInTable(input2, webTablesAutoPage.getNumberElementsInTable());


    }

    public void checkNewRowInTable (WebTablesInputsTest input, int nrRow) {

        WebElement outFirstName = getDriver().findElement(By.xpath("//*[@class='rt-tr-group'][" + nrRow + "]//*[@class='rt-td'][1]"));
        Assert.assertTrue(outFirstName.getText().contains(input.getFirstName()));

        WebElement outLastName = getDriver().findElement(By.xpath("//*[@class='rt-tr-group'][" + nrRow + "]//*[@class='rt-td'][2]"));
        Assert.assertTrue(outLastName.getText().contains(input.getLastName()));

        WebElement outEmail = getDriver().findElement(By.xpath("//*[@class='rt-tr-group'][" + nrRow + "]//*[@class='rt-td'][4]"));
        Assert.assertTrue(outEmail.getText().contains(input.getEmail()));

        WebElement outAge = getDriver().findElement(By.xpath("//*[@class='rt-tr-group'][" + nrRow + "]//*[@class='rt-td'][3]"));
        Assert.assertTrue(outAge.getText().contains(input.getAge()));

        WebElement outSalary = getDriver().findElement(By.xpath("//*[@class='rt-tr-group'][" + nrRow + "]//*[@class='rt-td'][5]"));
        Assert.assertTrue(outSalary.getText().contains(input.getSalary()));

        WebElement outDepartament = getDriver().findElement(By.xpath("//*[@class='rt-tr-group'][" + nrRow + "]//*[@class='rt-td'][6]"));
        Assert.assertTrue(outDepartament.getText().contains(input.getDepartament()));
    }

    public void createNewRowInTable(WebTablesInputsTest input) {
        webTablesAutoPage.addRecord();
        webTablesAutoPage.addRowInTable(input);
        webTablesAutoPage.clickOnSubmit();
    }

}
