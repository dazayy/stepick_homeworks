package pages;

import helpers.Calculation;
import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import providor.ConfigurationProvidor;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.ElementNotInteractableException;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;

public class Page1 extends BaseSeleniumPage {


    @FindBy(xpath = "//h5[@id=\"price\"]")
    private WebElement price;

    @FindBy(xpath = "//button[@id=\"book\"]")
    private WebElement bookButton;

    @FindBy(xpath = "//span[@id=\"input_value\"]")
    private WebElement xValue;

    @FindBy(xpath = "//input[@id=\"answer\"]")
    private WebElement input;

    @FindBy(xpath = "//button[@id=\"solve\"]")
    private  WebElement submitButton;

    public Page1() {
        driver.get(ConfigurationProvidor.URL);
        PageFactory.initElements(driver, this);
    }

    public Page1 getPage() {

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);

        wait.until(d -> price.getText().equals("$100"));
        bookButton.click();

        String x = Calculation.CalculateValue(xValue.getText());
        input.sendKeys(x);
        submitButton.click();


        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        // Save value from alert to system buffer
        StringSelection stringSelection = new StringSelection(alertText);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        return this;
    }


}
