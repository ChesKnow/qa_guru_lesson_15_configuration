package guru.qa.tests.config;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;
import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {
        //System.setProperty("webdriver.chrome.driver","C:/Program Files/Google/Chrome/Application/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver","C:/Program Files/Mozilla Firefox/geckodriver.exe");
        WebDriver driver = createWebDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }

    private WebDriver createWebDriver() {
        if (Objects.nonNull(config.getBrowserName())) {
            switch (config.getBrowserName()) {
                case CHROME: {
                    return new ChromeDriver();}
                case FIREFOX:{
                    return new FirefoxDriver();}
                default:{
                    throw new RuntimeException("Type of browser not supported");}
            }
        }
        throw new RuntimeException("Type of browser could not be null");

    }
}
