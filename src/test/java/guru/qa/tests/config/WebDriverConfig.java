package guru.qa.tests.config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:${switch}.properties")
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://www.pochta.ru/")
    String getBaseUrl();

    @Key("browserName")
    String getBrowserName();

    @Key("browserVersion")
    @DefaultValue("91.0")
    String getBrowserVersion();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("RemoteWebDriver")
    String getRemoteWebDriver();
}
