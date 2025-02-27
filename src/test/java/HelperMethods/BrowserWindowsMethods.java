package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsMethods {
    WebDriver driver;

    public BrowserWindowsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNewTab(int nrTab) {
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(nrTab));
    }

    public void switchToFirstTab(){
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.getFirst());
    }

    public void switchToLastTab(){
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.getLast());
    }

}
