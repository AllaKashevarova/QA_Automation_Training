package com.coherent.task60;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LoginTest {
    PropertiesHelper propertiesHelper = new PropertiesHelper();
    private String userName = propertiesHelper.propertiesReader("userName");

    public LoginTest() throws IOException {
    }

    @Test
    public void loginTest() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.load();
        loginPage.logIn();
        WebElement actualResult = loginPage.actualResult;

        Assertions.assertEquals(actualResult.getText(), userName);
    }

    @AfterEach
    public void cleanup(){
        SingletoneWebDriver.cleanup();
    }
}
