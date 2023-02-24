package com.coherent.task60;

import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.load();
        //loginPage.get();
        loginPage.logIn();
        loginPage.cleanup();



    }


}
