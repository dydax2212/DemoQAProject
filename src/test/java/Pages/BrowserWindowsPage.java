package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.BrowserWindowsMethods;
import HelperMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindowsPage {
    WebDriver driver;
    ElementsMethod elementsMethod;
    BrowserWindowsMethods browserWindowsMethods;

    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(driver);
        this.browserWindowsMethods = new BrowserWindowsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;

    @FindBy (id = "sampleHeading")
    WebElement sampleHeading;

    @FindBy (id = "windowButton")
    WebElement windowButton;

    public void dealWithNewTab(){
        elementsMethod.clickOnElement(tabButton);

    }

    public void dealWithNewWindow(){
        elementsMethod.clickOnElement(windowButton);
    }

    public void switchToNewTab (int nrTab){
        browserWindowsMethods.switchToNewTab(nrTab);
    }

    public void swithToFirstTab(){
        browserWindowsMethods.switchToFirstTab();
    }

    public void swithToLastTab(){
        browserWindowsMethods.switchToLastTab();
    }

    public String getOutSampleHeadingText (){

        return elementsMethod.getElementText(sampleHeading);
    }




}
