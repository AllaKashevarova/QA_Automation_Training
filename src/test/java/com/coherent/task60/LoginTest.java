package com.coherent.task60;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.setup();
        loginPage.logIn();
        loginPage.cleanup();



    }


}
