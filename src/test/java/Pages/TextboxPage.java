package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethod;
import ObjectData.TextboxTableObjectData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextboxPage {
    WebDriver driver;
    ElementsMethod elementsMethod;
    AlertMethods alertMethods;


    public TextboxPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(driver);
        this.alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "userName")
    WebElement userNameField;

    @FindBy (id = "userEmail")
    WebElement userEmail ;

    @FindBy(id = "currentAddress")
    WebElement currentAddressField;

    @FindBy (id ="permanentAddress")
    WebElement permanentAddressField;

    @FindBy (id = "submit")
    WebElement submitButton;

    @FindBy(id = "name")
    WebElement outName;

    @FindBy (id = "email")
    WebElement outEmail;

    @FindBy (xpath = "//* [@class='mb-1'][3]")
    WebElement outCurrentAddress;

    @FindBy (xpath = "//* [@class='mb-1'][4]")
    WebElement outPermanentAddress;

    public void fillData (TextboxTableObjectData data) {
        elementsMethod.sendTextToTextbox(userNameField, data.getName());
        elementsMethod.sendTextToTextbox(userEmail, data.getEmail());
        elementsMethod.sendTextToTextbox(currentAddressField, data.getCurrentAddress());
        elementsMethod.sendTextToTextbox(permanentAddressField, data.getPermanentAddress());
    }

    public void typeUserName(TextboxTableObjectData data){
        elementsMethod.sendTextToTextbox(userNameField, data.getName());
    }

    public void typeUserEmail (TextboxTableObjectData data){
        elementsMethod.sendTextToTextbox(userEmail, data.getEmail());
    }

    public void typeUserCurrentAddress (TextboxTableObjectData data){
        elementsMethod.sendTextToTextbox(currentAddressField, data.getCurrentAddress());
    }

    public void typeUserPermanentAddress (TextboxTableObjectData data){
        elementsMethod.sendTextToTextbox(permanentAddressField, data.getPermanentAddress());
    }

    public void clickOnSubmit(){
        elementsMethod.clickOnElement(submitButton);
    }

    public String getOutName (){
        return elementsMethod.getElementText(outName);
    }

    public String getOutEmail (){
        return elementsMethod.getElementText(outEmail);
    }

    public String getOutCurrentAddress (){
        return elementsMethod.getElementText(outCurrentAddress);
    }

    public String getOutPermanentAddress (){
        return elementsMethod.getElementText(outPermanentAddress);
    }
}
