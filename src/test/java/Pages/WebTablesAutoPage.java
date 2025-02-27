package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethod;
import InputsTest.WebTablesInputsTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesAutoPage {
    WebDriver driver;
    ElementsMethod elementsMethod;

    public WebTablesAutoPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    WebElement elementWebTables;

    @FindBy(id = "addNewRecordButton")
    WebElement addRecord;

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "userEmail")
    WebElement emailField;

    @FindBy(id = "age")
    WebElement ageField;

    @FindBy(id = "salary")
    WebElement salaryField;

    @FindBy(id = "department")
    WebElement departamentField;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//*[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    List<WebElement> listaElementeTabel;


    public void clickOnWebTables(){

        elementsMethod.clickOnElement(elementWebTables);
    }

    public void addRecord(){
        elementsMethod.clickOnElement(addRecord);
    }

    public void clickOnSubmit() {
        elementsMethod.clickOnElement(submitButton);
    }

    public int getNumberElementsInTable() {
        return listaElementeTabel.size();
    }



    public void addRowInTable(WebTablesInputsTest input){

        elementsMethod.sendTextToTextbox(firstNameField, input.getFirstName());
        elementsMethod.sendTextToTextbox(lastNameField, input.getLastName());
        elementsMethod.sendTextToTextbox(emailField, input.getEmail());
        elementsMethod.sendTextToTextbox(ageField, input.getAge());
        elementsMethod.sendTextToTextbox(salaryField, input.getSalary());
        elementsMethod.sendTextToTextbox(departamentField, input.getDepartament());
    }

}
