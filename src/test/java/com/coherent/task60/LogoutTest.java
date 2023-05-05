package com.coherent.task60;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import junit.framework.TestListener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import java.io.IOException;

@ExtendWith(TestResultLoggerExtension.class)
@Feature("Login and logout")
@Tag("2")
public class LogoutTest extends BaseTest {
    private LoginPage loginPage = new LoginPage();

    @Test
    @AllureId("1111")
    @DisplayName("Log Out Test")
    @Description("Test Description: Test Yandex mail Logout")
    public void logoutTest() throws IOException {
        EmailBoxPage emailBoxPage = new EmailBoxPage();
        WebDriver driver = emailBoxPage.getDriver();
        loginPage.load();
        loginPage.logIn();
        emailBoxPage.logOut();

        Assertions.assertTrue(emailBoxPage.getLogInButtonLocator().isDisplayed());
        //Assertions.assertTrue(emailBoxPage.getLogInButtonLocator().isSelected());
    }

}
