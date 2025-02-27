package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
    WebDriver driver;
    ElementsMethod elementsMethod;
    AlertMethods alertMethods;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(driver);
        this.alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertButton")
    WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    @FindBy(id = "promtButton")
    WebElement promptButton;

    public void dealWithAlertOk(){
        elementsMethod.clickOnElement(alertButton);
        alertMethods.AlertOk();
    }

    public void dealWithAlertDelay(){
        elementsMethod.clickOnElement(timerAlertButton);
        alertMethods.alertDelay();
    }

    public void dealWithAlertConfirm(){
        elementsMethod.clickOnElement(confirmButton);
        alertMethods.alertConfirm();
    }

    public void dealWithAlertPrompt(String text){
        elementsMethod.clickOnElement(promptButton);
        alertMethods.alertPrompt(text);
    }
}
