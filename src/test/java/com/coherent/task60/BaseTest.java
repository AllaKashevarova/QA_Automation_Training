package com.coherent.task60;

import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@ExtendWith(AllureJunit5.class)
public class BaseTest {

    @BeforeEach
    public void beforeEach(TestInfo testInfo) {
        Allure.step("System Information", () -> {
            // Get the browser name and version
            Capabilities capabilities = ((RemoteWebDriver) SingletoneWebDriver.getDriver()).getCapabilities();
            String browserName = capabilities.getBrowserName();
            String browserVersion = capabilities.getBrowserVersion();

            // Add the system information to the report
            Allure.addAttachment("Browser Name", browserName);
            Allure.addAttachment("Browser Version", browserVersion);
            // Add other system info as needed
        });
    }

    @AfterAll
    public static void cleanup() {
        SingletoneWebDriver.cleanup();
    }

}
