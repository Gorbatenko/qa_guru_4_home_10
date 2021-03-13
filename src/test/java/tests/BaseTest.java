package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.AttachmentsHelper.*;
import static helpers.AttachmentsHelper.attachScreenshot;

public class BaseTest {
    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1540x1080";
        Configuration.browser = System.getProperty("browser", "chrome");
        setEnvironmentAllure("task", System.getProperty("task", "test"));
        setEnvironmentAllure("browser", Configuration.browser);

        if (System.getProperty("remote_driver") != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = System.getProperty("remote_driver");
            setEnvironmentAllure("selenoid", System.getProperty("selenoid"));
        }
    }

    @AfterEach
    void afterEach() {
        attachVideo();
        attachPageSource();
        attachScreenshot("Last screenshot");
        closeWebDriver();
    }

}
