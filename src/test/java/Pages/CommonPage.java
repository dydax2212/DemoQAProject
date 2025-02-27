package Pages;

import HelperMethods.ElementsMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {
    WebDriver driver;
    ElementsMethod elementsMethod;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[@class='text']")
    List<WebElement> elements;

    public void clickOnSubmenu(String subMenuText){
        elementsMethod.clickOnElementByText(elements, subMenuText);
    }
}
