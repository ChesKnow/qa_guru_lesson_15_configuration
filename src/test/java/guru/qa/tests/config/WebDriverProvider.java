package guru.qa.tests.config;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", config.getBrowserName());
        options.setCapability("browserVersion", config.getBrowserVersion());
        WebDriver driver = null;
        if (config.isRemote() == false) {
            driver = new ChromeDriver();}
        else {
        try {
            driver = new RemoteWebDriver(new URL(config.getRemoteWebDriver()), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }}
        driver.get(config.getBaseUrl());
        return driver;
    }

}
