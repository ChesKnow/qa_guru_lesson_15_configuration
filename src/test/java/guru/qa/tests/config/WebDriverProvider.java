package guru.qa.tests.config;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {

        WebDriver driver = createWebDriver();


        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", config.getBrowserName());
        options.setCapability("browserVersion", config.getBrowserVersion());
        options.setCapability("isRemote", config.isRemote());
        driver.get(config.getBaseUrl());
        return driver;
    }

    private WebDriver createWebDriver() throws MalformedURLException {
        if (config.isRemote()) {
            switch (config.isRemote()) {
                case false: {
                    return new ChromeDriver();}
                case true:{
                    return new RemoteWebDriver(new URL(config.getRemoteWebDriver()), options.);}

            }
        }

    }

}
