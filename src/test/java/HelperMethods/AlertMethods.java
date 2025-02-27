package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {
    WebDriver driver;
    WebDriverWait driverWait;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
//
    public void AlertOk(){
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();
    }

    public void alertDelay(){
        driverWait.until(ExpectedConditions.alertIsPresent());
        AlertOk();
    }

    public void alertCancel(){
        Alert alertCancel = driver.switchTo().alert();
        alertCancel.dismiss();
    }

    public void alertConfirm(){
        Alert alertConfirm = driver.switchTo().alert();
        alertConfirm.accept();
    }

    public void alertPrompt (String text){
        Alert alertText = driver.switchTo().alert();
        alertText.sendKeys(text);
        alertText.accept();
    }


}
