package Pages;

import HelperMethods.ElementsMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    ElementsMethod elementsMethod;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='card mt-4 top-card'][2]")
        WebElement formsButton;

    @FindBy(xpath = "//*[@class='card mt-4 top-card'][3]")
        WebElement alertWindowFrameButton;

    @FindBy(xpath = "//h5[text()='Elements']")
        WebElement elementButton;

    @FindBy(xpath="//*[text()='Widgets']")
            WebElement WidgetsButton;

    public void clickOnForms(){
        elementsMethod.clickOnElement(formsButton);
    }

    public void clickOnAlert(){
        elementsMethod.clickOnElement(alertWindowFrameButton);
    }

    public void clickOnElements(){
        elementsMethod.clickOnElement(elementButton);
    }

    public void clickOnWidgets(){
        elementsMethod.clickOnElement(WidgetsButton);
    }

}
