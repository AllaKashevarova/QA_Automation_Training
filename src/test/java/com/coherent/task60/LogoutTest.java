package com.coherent.task60;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LogoutTest {


    @Test
    public void logoutTest() throws IOException {
        EmailBoxPage emailBoxPage = new EmailBoxPage();
        WebDriver driver = emailBoxPage.getDriver();
        LoginPage loginPage = new LoginPage();
        loginPage.load();
        loginPage.logIn();
        emailBoxPage.logOut();

        Assertions.assertTrue(emailBoxPage.getLogInButtonLocator().isDisplayed());
    }

    @AfterEach
    public void cleanup(){
        SingletoneWebDriver.cleanup();
    }
}
