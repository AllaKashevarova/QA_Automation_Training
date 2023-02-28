package com.coherent.task60;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LogoutTest {

    @Test
    public void logoutTest() throws IOException {
        EmailBoxPage emailBoxPage = new EmailBoxPage();
        LoginPage loginPage = new LoginPage();
        loginPage.load();
        loginPage.logIn();
        emailBoxPage.logOut();

        Assertions.assertTrue(loginPage.logInButton.isDisplayed());
    }

    @AfterEach
    public void cleanup(){
        SingletoneWebDriver.cleanup();
    }
}
