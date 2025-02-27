package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MenuPage {
    WebDriver driver;
    ElementsMethod elementsMethod;
    AlertMethods alertMethods;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(driver);
        this.alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='element-list collapse show']//*[@class='btn btn-light ']")
    List<WebElement> widgetsList;

    @FindBy(xpath =  "//*[text()='Main Item 2']")
    WebElement mainItem2;

    @FindBy(xpath =  "//*[text()='SUB SUB LIST »']")
    WebElement sublist;

    @FindBy(xpath =  "//*[text()='Sub Sub Item 1']")
    WebElement subSubItem;

    public void clickOnWidgetsFromList(int x){
       elementsMethod.clickOnElement(widgetsList.get(x));
    }

    public void clickOnMenu() {
        elementsMethod.moveToElementInMenu(mainItem2);
    }

    public void clickOnMenuSublist() {
        elementsMethod.moveToElementInMenu(sublist);
    }

    public void clickOnMenuSubItem() {
        elementsMethod.clickOnElementInMenu(subSubItem);
    }


}
