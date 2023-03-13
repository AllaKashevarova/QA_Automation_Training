package com.coherent.task60;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class LoginTest {
    PropertiesHelper propertiesHelper = new PropertiesHelper();
    ScreenshotHelper screenshotHelper = new ScreenshotHelper();
    private String userName;
    private String path;

    {
        userName = propertiesHelper.propertiesReader("user.name");
        path = propertiesHelper.propertiesReader("error.screenshots");
    }

    @Test
    public void loginTest() throws IOException {

        LoginPage loginPage = new LoginPage();
        loginPage.load();
        loginPage.logIn();
        String actualResultText = loginPage.getActualResult().getText();

        Assertions.assertEquals(actualResultText, userName);
//TODO 1.Invoke method just when test fails 2.Generate new name automatically
        screenshotHelper.onTestFailure(loginPage.getDriver(), path);
    }

    @AfterEach
    public void cleanup(){
        SingletoneWebDriver.cleanup();
    }
}
