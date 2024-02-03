package core;


import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;


abstract public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BaseSeleniumPage.setDriver(driver);

    }

    @AfterEach
    public void rearDown() throws InterruptedException {
//        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}