package guru.qa.tests;

import guru.qa.tests.config.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
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
