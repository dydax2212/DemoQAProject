package HelperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ElementsMethod {

    WebDriver diver;

    public ElementsMethod(WebDriver diver) {
        this.diver = diver;
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public void clickOnElementByText(List<WebElement> webElementList, String text){
        for (int i = 0; i < webElementList.size(); i++){
            if (webElementList.get(i).getText().equals(text)){
                clickOnElement(webElementList.get(i));
                break;
            }
        }

    }

    public String getElementText(WebElement element){
        return element.getText();
    }

    public void sendTextToTextbox(WebElement element, String text){
        element.sendKeys(text);
    }

    public void moveToElementInMenu (WebElement element) {
        Actions actions = new Actions(diver);
        actions.moveToElement(element)
                .build()
                .perform();
    }
    public void clickOnElementInMenu (WebElement element) {
        Actions actions = new Actions(diver);
        actions.click(element)
                .build()
                .perform();
    }

    public void clickOnCheckBoxByText(List<WebElement> element, String text){

        for (WebElement x : element){
            String dummy = x.getText();
            String dummy2 = text;
          if (x.getText().equals(text)) x.click();

        }
    }

    public void enterTextInTextBoxWithSearch (WebElement element, String text) {
        element.sendKeys(text);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ENTER);
    }

    public void selectOptionFromDropdown (WebElement element, String text) {
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }


    public void clickOnElementInDropdown (WebElement element, String text) {

        element.sendKeys(text);
        element.click();

    }

//    public void clickOnMonthYearDropdown(WebElement element, String data) {
//
//        Select selectHelp = new Select(element);
//        selectHelp.selectByVisibleText(data);
//    }


}
