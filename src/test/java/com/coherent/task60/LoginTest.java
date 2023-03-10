package com.coherent.task60;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LoginTest {
    PropertiesHelper propertiesHelper = new PropertiesHelper();
    private String userName;

    {
        userName = propertiesHelper.propertiesReader("user.name");
    }

    @Test
    public void loginTest() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.load();
        loginPage.logIn();
        String actualResultText = loginPage.getActualResult().getText();

        Assertions.assertEquals(actualResultText, userName);
    }

    @AfterEach
    public void cleanup(){
        SingletoneWebDriver.cleanup();
    }
}
