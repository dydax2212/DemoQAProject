package Tests;

import Pages.HomePage;
import ShareDataBrowser.Hooks;
import ShareDataBrowser.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends Hooks {
    HomePage homePage;
    //private static final String NAME = "Stefania";

    @Test
    public void methodTest() {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("window.scrollTo(0,500)");

        homePage = new HomePage(getDriver());
        homePage.clickOnElements();


        WebElement elementWebTables  = getDriver().findElement(By.xpath("//span[text()='Web Tables']"));
        elementWebTables.click();

        List<WebElement> listaElementeTabel = getDriver().findElements(By.xpath("//*[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        int numarElementeLista = listaElementeTabel.size();




        WebElement addRecord = getDriver().findElement(By.id("addNewRecordButton"));
        addRecord.click();

        String firstName = "Stefania";
        String lastName = "Munteanu";
        String email = "stefania.munteanu@gmail.com";
        String age = "33";
        String salary = "7000";
        String departament = "Dev";

        WebElement firstNameField = getDriver().findElement(By.id("firstName"));
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = getDriver().findElement(By.id("lastName"));
        lastNameField.sendKeys(lastName);

        WebElement emailField = getDriver().findElement(By.id("userEmail"));
        emailField.sendKeys(email);

        WebElement ageField = getDriver().findElement(By.id("age"));
        ageField.sendKeys(age);

        WebElement salaryField = getDriver().findElement(By.id("salary"));
        salaryField.sendKeys(salary);

        WebElement departamentField = getDriver().findElement(By.id("department"));
        departamentField.sendKeys(departament);

        WebElement submitButton = getDriver().findElement(By.id("submit"));
        submitButton.click();

        List<WebElement> listaElementeTabelUpdated = getDriver().findElements(By.xpath("//*[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        int randNou = numarElementeLista + 1;
        Assert.assertEquals(listaElementeTabelUpdated.size(), randNou);

//
//        //cum facem daca introducem mai multe entry-uri in tabel?
//        WebElement outFirstName = driver.findElement(By.xpath("//* [@class='rt-table']/div[@class='rt-tbody']/div[@class='rt-tr-group'][+4+]/div[@class='rt-tr -even']/div[@class='rt-td'][1]"));
//        //*[@class='rt-tr-group'][4]//*[@class][1]
        WebElement outFirstName = getDriver().findElement(By.xpath("//*[@class='rt-tr-group'][4]//*[@class='rt-td'][1]"));
        Assert.assertTrue(outFirstName.getText().contains(firstName));

        WebElement outLastName = getDriver().findElement(By.xpath("//* [@class='rt-table']/div[@class='rt-tbody']/div[@class='rt-tr-group'][4]/div[@class='rt-tr -even']/div[@class='rt-td'][2]"));
        Assert.assertTrue(outLastName.getText().contains(lastName));

        WebElement outEmail = getDriver().findElement(By.xpath("//* [@class='rt-table']/div[@class='rt-tbody']/div[@class='rt-tr-group'][4]/div[@class='rt-tr -even']/div[@class='rt-td'][4]"));
        Assert.assertTrue(outEmail.getText().contains(email));

        WebElement outAge = getDriver().findElement(By.xpath("//* [@class='rt-table']/div[@class='rt-tbody']/div[@class='rt-tr-group'][4]/div[@class='rt-tr -even']/div[@class='rt-td'][3]"));
        Assert.assertTrue(outAge.getText().contains(age));

        WebElement outSalary = getDriver().findElement(By.xpath("//* [@class='rt-table']/div[@class='rt-tbody']/div[@class='rt-tr-group'][4]/div[@class='rt-tr -even']/div[@class='rt-td'][5]"));
        Assert.assertTrue(outSalary.getText().contains(salary));

        WebElement outDepartament = getDriver().findElement(By.xpath("//* [@class='rt-table']/div[@class='rt-tbody']/div[@class='rt-tr-group'][4]/div[@class='rt-tr -even']/div[@class='rt-td'][6]"));
        Assert.assertTrue(outDepartament.getText().contains(departament));

       // driver.close();

    }
}
