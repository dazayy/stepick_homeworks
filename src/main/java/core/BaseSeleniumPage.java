package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BaseSeleniumPage {
    protected static WebDriver driver;
    protected static Wait<WebDriver> wait;


    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}