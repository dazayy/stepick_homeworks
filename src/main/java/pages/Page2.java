package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.support.PageFactory;
import providor.ConfigurationProvidor;

public class Page2 extends BaseSeleniumPage {



    public Page2() {
        driver.get(ConfigurationProvidor.URL);
        PageFactory.initElements(driver, this);
    }
}
