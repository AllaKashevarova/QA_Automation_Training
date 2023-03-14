package com.coherent.task60;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.IOException;

public class LogoutTest {
    private ScreenshotHelper screenshotHelper = new ScreenshotHelper();
    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private LoginPage loginPage = new LoginPage();
    private String path = propertiesHelper.propertiesReader("error.screenshots");;

    @Test
    public void logoutTest() throws IOException {
        EmailBoxPage emailBoxPage = new EmailBoxPage();
        WebDriver driver = emailBoxPage.getDriver();

        loginPage.load();
        loginPage.logIn();
        emailBoxPage.logOut();

        Assertions.assertTrue(emailBoxPage.getLogInButtonLocator().isDisplayed());
    }

    @AfterEach
        public void cleanup() {
        SingletoneWebDriver.cleanup();
    }
}
