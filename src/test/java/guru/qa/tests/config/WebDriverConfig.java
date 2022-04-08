package guru.qa.tests.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${switch}.properties")
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://www.pochta.ru/")
    String getBaseUrl();

    @Key("browserName")
    @DefaultValue("FIREFOX")
    Browser getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("RemoteWebDriver")
    @DefaultValue("false")
    Boolean isRemote();
}
