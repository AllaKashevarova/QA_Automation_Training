package com.coherent.task60;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

@ExtendWith(TestResultLoggerExtension.class)
public class LogoutTest {
    private LoginPage loginPage = new LoginPage();

    @Test
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
