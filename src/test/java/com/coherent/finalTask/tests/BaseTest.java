package com.coherent.finalTask.tests;

import com.coherent.task60.SingletoneWebDriver;
import com.coherent.task60.TestResultLoggerExtension;
import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@ExtendWith(TestResultLoggerExtension.class)
@ExtendWith(AllureJunit5.class)
public abstract class BaseTest {

    @BeforeEach
    public void beforeEach() {
        Allure.step("System Information", () -> {
            // Get the browser name and version
            Capabilities capabilities = ((RemoteWebDriver) SingletoneWebDriver.getDriver()).getCapabilities();
            String browserName = capabilities.getBrowserName();
            String browserVersion = capabilities.getBrowserVersion();

            // Add the system information to the report
            Allure.addAttachment("Browser Name", browserName);
            Allure.addAttachment("Browser Version", browserVersion);
        });
    }

    @AfterAll
    public static void cleanUp() {
        SingletonWebDriver.cleanup();
    }
}
