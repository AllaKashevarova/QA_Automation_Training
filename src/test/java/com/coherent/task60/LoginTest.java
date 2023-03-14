package com.coherent.task60;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.testng.ITestResult;

import java.io.IOException;

public class LoginTest {
    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private ScreenshotHelper screenshotHelper = new ScreenshotHelper();
    private LoginPage loginPage = new LoginPage();
    private String userName;
    private String path;

    {
        userName = propertiesHelper.propertiesReader("user.name");
        path = propertiesHelper.propertiesReader("error.screenshots");
    }

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            //super.failed(e, description);
            screenshotHelper.takeScreenshot(loginPage.getDriver(), path);
            System.out.println("failed method has been invoked");
        }
    };

        @Test
        public void loginTest() throws IOException {
            loginPage.load();
            loginPage.logIn();
            String actualResultText = loginPage.getActualResult().getText();

            Assertions.assertEquals(actualResultText, "Test!");
            //Assertions.assertEquals(actualResultText, userName);
            //screenshotHelper.takeScreenshot(loginPage.getDriver(), path);
        }

        @AfterEach
        public void cleanup() {
            SingletoneWebDriver.cleanup();
        }
    }



