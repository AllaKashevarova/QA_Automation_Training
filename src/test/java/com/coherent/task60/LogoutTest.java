package com.coherent.task60;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

@ExtendWith(TestResultLoggerExtension.class)
@Feature("Login and logout")
public class LogoutTest {
    private LoginPage loginPage = new LoginPage();

    @Test
    @Description("Test Description: Test Yandex mail Logout")
    public void logoutTest() throws IOException {
        EmailBoxPage emailBoxPage = new EmailBoxPage();
        WebDriver driver = emailBoxPage.getDriver();
        loginPage.load();
        loginPage.logIn();
        emailBoxPage.logOut();

        //Assertions.assertTrue(emailBoxPage.getLogInButtonLocator().isDisplayed());
        Assertions.assertTrue(emailBoxPage.getLogInButtonLocator().isSelected());
    }

    @AfterAll
    public static void cleanup() {
        SingletoneWebDriver.cleanup();
    }
}
