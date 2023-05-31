package com.coherent.finalTask;

import com.coherent.task60.TestResultLoggerExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Feature("Create Account")
@Tag("AP-2")

public class LogInTest extends BaseTest{
    private static MainPage mainPage = new MainPage();
    private static LoginPage loginPage = new LoginPage();
    private static AccountPage accountPage = new AccountPage();
    private static PropertiesHelper propertiesHelper = new PropertiesHelper();
    private static String userLoginFile = "magentoLogin.properties";
    private  String firstName = propertiesHelper.propertiesReader("magentoUser.firstName", userLoginFile);
    private  String lastName = propertiesHelper.propertiesReader("magentoUser.lastName", userLoginFile);
    private  String email = propertiesHelper.propertiesReader("magentoUser.email", userLoginFile);
    private String expectedUserData  = firstName + " " + lastName + "\n" + email;

    @Description("Test Description: Verify the ability to login in account")
    @Test
    @DisplayName("Login to Account")
    public void LogIn(){
        mainPage.signIn();
        loginPage.SignIn();
        accountPage.navigateToMyAccountTab();
        loginPage.getActualResult();
        String actualUserName = loginPage.getActualResult().getText();

        Assertions.assertEquals(expectedUserData, actualUserName);
    }
}
