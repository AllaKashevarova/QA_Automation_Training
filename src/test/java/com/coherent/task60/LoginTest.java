package com.coherent.task60;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

@ExtendWith(TestResultLoggerExtension.class)
@ExtendWith({AllureJunit5.class})
@Feature("Login and logout")
@Tag("1")
public class LoginTest extends BaseTest {
    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private LoginPage loginPage = new LoginPage();
    private String userName;
    private String loginPropertiesFile = "login.properties";

    {
        userName = propertiesHelper.propertiesReader("user.name", loginPropertiesFile);
    }

    @Description("Test Description: Test Login to Yandex mail")
    @Test
    @DisplayName("Log In Test")
    public void loginTest() throws IOException {
        loginPage.load();
        loginPage.logIn();
        String actualResultText = loginPage.getActualResult().getText();

        Assertions.assertEquals(actualResultText, "Test!");
        //Assertions.assertEquals(actualResultText, userName);
    }


}



