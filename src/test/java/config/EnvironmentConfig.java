package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${platform}.properties")
public interface EnvironmentConfig extends Config {

    @Key("browser.size")
    String getBrowserSize();

    @Key("browser")
    String getBrowser();

    @Key("platform")
    @DefaultValue("selenoid")
    String getPlatform();

    @Key("selenoid.url.remote")
    String getSelenoidRemote();

    @Key("selenoid.url.video")
    String getSelenoidVideo();

    @Key("selenoid.login")
    String getSelenoidLogin();

    @Key("selenoid.password")
    String getSelenoidPassword();

}
