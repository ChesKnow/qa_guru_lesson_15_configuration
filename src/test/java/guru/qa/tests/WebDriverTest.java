package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.tests.config.WebDriverConfig;
import guru.qa.tests.config.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {
    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        Configuration.browser = String.valueOf(WebDriverProvider.config.getBrowserName());
        Configuration.browserVersion = WebDriverProvider.config.getBrowserVersion();
        Configuration.remote = String.valueOf(WebDriverProvider.config.getRemoteWebDriver());
    }

    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }


    @AfterEach
    public void stopDriver() {
        driver.quit();
    }

    @Test
    public void testPochtaRuTitle() {

        assertEquals(driver.getTitle(), "Почта России");

    }
}
