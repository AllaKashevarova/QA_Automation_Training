package com.coherent.task60;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.IOException;

@ExtendWith(TestResultLoggerExtension.class)
public class LoginTest {
    private PropertiesHelper propertiesHelper = new PropertiesHelper();
    private LoginPage loginPage = new LoginPage();
    private String userName;

    {
        userName = propertiesHelper.propertiesReader("user.name");
    }

    @Description("Bla bla")
    @Test
    public void loginTest() throws IOException {
        loginPage.load();
        loginPage.logIn();
        String actualResultText = loginPage.getActualResult().getText();

        Assertions.assertEquals(actualResultText, "Test!");
        //Assertions.assertEquals(actualResultText, userName);
    }

    @AfterAll
    public static void cleanup() {
        SingletoneWebDriver.cleanup();
    }
}



