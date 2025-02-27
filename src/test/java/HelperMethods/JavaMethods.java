package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaMethods {

    WebDriver diver;

    public JavaMethods(WebDriver diver) {
        this.diver = diver;
    }

    public void scrollToXY(int x, int y){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) diver;
        javascriptExecutor.executeScript("window.scrollTo("+x+","+y+")");
    }
}
